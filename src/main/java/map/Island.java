package map;

import entities.*;
import helpers.EntityType;
import helpers.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Island {

    private static Map<Location, EntityI> entities = new HashMap<Location, EntityI>();
    private static int width;
    private static int height;

    public Island(int width, int height, int stones, int weapons, int takos, int zombies, int humans) {
        this.width = width;
        this.height = height;
        putEntities(stones, EntityType.STONE);
        putEntities(weapons, EntityType.WEAPON);
        putEntities(takos, EntityType.TAKO);
        putEntities(zombies, EntityType.ZOMBIE);
        putEntities(humans, EntityType.HUMAN);
        initBlankFields();
    }

    public static Map<Location, EntityI> getEntities() {
        return entities;
    }

    public static void createNewEntity(EntityType type) {
        Location location;
        Map<Location, EntityI> blank = new HashMap<>();
        // get all blank entities
        List<Location> blankLocations = new ArrayList<>();
        for (Map.Entry<Location, EntityI> e: entities.entrySet()){
            if (e.getValue() instanceof EntityBlank) {
                blankLocations.add(e.getKey());
            }
        }
        if (blank.size() == 0) return; // overpopulation! starvation coming soon :(
        // Get random blank space
        Location randomLocation = blankLocations.get(Util.getRandom(blank.size()));
        // Create new entity
        if (type == EntityType.HUMAN) {
            entities.put(randomLocation, new FleshHuman(randomLocation));
        } else {
            entities.put(randomLocation, new MaterialTako());
        }
    }

    private void putEntities(int count, EntityType type) {
        Location location;
        while (count > 0) {
            do {
                location = new Location(Util.getRandom(width), Util.getRandom(height));
            } while (entities.containsKey(location));
            switch (type) {
                case STONE:
                    entities.put(location, new MaterialStone());
                    break;
                case WEAPON:
                    entities.put(location, new MaterialWeapon());
                    break;
                case TAKO:
                    entities.put(location, new MaterialTako());
                    break;
                case ZOMBIE:
                    entities.put(location, new FleshZombie(location));
                    break;
                case HUMAN:
                    entities.put(location, new FleshHuman(location));
                    break;
                default:
                    return;
            }
            count--;
        }
    }

    private void initBlankFields() {
        Location location;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                location = new Location(x, y);
                if (entities.get(location) == null) {
                    entities.put(location, new EntityBlank());
                }
            }
        }
    }

    public void printIsland() {
        Location location;
        EntityI entityI;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                location = new Location(x, y);
                entities.get(location).getType().printEntity(entities.get(location));
            }
            System.out.println();
            System.out.println();
        }
        for (EntityType type: EntityType.values()){
            type.printEntity();
            System.out.println(String.format(" - '%s', count - %d", type.getNameEntity(), getCountEntity(type)));
        }
    }

    private int getCountEntity(EntityType type) {
        int i = 0;
        for (Map.Entry<Location, EntityI> e: entities.entrySet()){
            EntityI currentEntityI = e.getValue();
            // Step of itteration skip if current FleshHuman o FleshZombie is dead
            if (currentEntityI instanceof FleshI) {
                if (((FleshI) currentEntityI).isDead()) {
                    continue;
                }
            }
            if (e.getValue().getType() == type) i++;
        }
        return i;
    }

    public boolean turn() {
        for (Map.Entry<Location, EntityI> e: entities.entrySet()){
            EntityI entityI = e.getValue();
            if (entityI instanceof MaterialI) continue; // MaterialI don't walk
            FleshI fleshI = (FleshI) entityI;
            Location beforeLocation = fleshI.getLocation();
            Map<Location, EntityI> newField = fleshI.walk(getAroundEntities(e.getKey()));
            entities.put(beforeLocation, new EntityBlank());
            entities.putAll(newField);
//            printIsland();
        }

        //Is Game Over?
        if (getCountEntity(EntityType.HUMAN) == 0) {
            printIsland();
            System.out.println ("ZOMBIE WIN!!!");
            return false;
        } else if (getCountEntity(EntityType.ZOMBIE) == 0){
            printIsland();
            System.out.println ("HUMAN WIN!!!");
            return false;
        }
        return true;
    }

    private  Map<Location, EntityI> getAroundEntities(Location point) {
        int x = point.getX(), y = point.getY();
        int x1, y1;
        Map<Location, EntityI> around = new HashMap<>();
        Location location;
        for (int i = -1; i < 2; i++){
            x1 = x + i;
            //check that x1 steel exist inside island
            if (x1 < 0 || x1 >= width) continue;
            for (int j = -1; j < 2; j++) {
                y1 = y + j;
                //check that y1 steel exist inside island
                if (y1 < 0 || y1 >= height) continue;
                //check that x1 and y1 not equals x and y of entity
                if (y1 == y && x1 == x) continue;
                location = new Location(x1, y1);
                around.put(location, entities.get(location));
            }
        }
        return around;
    }
}