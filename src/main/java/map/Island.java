package map;

import entities.*;
import utils.Util;
import walk.TemplateHuman;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Island {

    private static Map<Location, Entity> entities = new HashMap<Location, Entity>();
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

    public static Map<Location, Entity> getEntities() {
        return entities;
    }

    public static void createNewEntity(EntityType type) {
        Location location;
        do {
            location = new Location(Util.getRandom(width), Util.getRandom(height));
        } while (!(entities.get(location) instanceof Blank));
        if (type == EntityType.HUMAN) {
            entities.put(location, new Human(location));
        } else {
            entities.put(location, new Tako());
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
                    entities.put(location, new Stone());
                    break;
                case WEAPON:
                    entities.put(location, new Weapon());
                    break;
                case TAKO:
                    entities.put(location, new Tako());
                    break;
                case ZOMBIE:
                    entities.put(location, new Zombie(location));
                    break;
                case HUMAN:
                    entities.put(location, new Human(location));
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
                    entities.put(location, new Blank());
                }
            }
        }
    }

    public void printIsland() {
        Location location;
        Entity entity;
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
        for (Map.Entry<Location, Entity> e: entities.entrySet()){
            if (e.getValue().getType() == type) i++;
        }
        return i;
    }

    public boolean turn() {
        for (Map.Entry<Location, Entity> e: entities.entrySet()){
            Entity entity = e.getValue();
            //Material don't walk
            if (entity instanceof Material) continue;
            Flesh flesh = (Flesh) entity;
            Map<Location, Entity> newField = flesh.walk(getAroundEntities(e.getKey()));
            entities.put(flesh.getLocation(), new Blank());
            entities.putAll(newField);
        }
        printIsland();
        //Is Game Over?
        if (getCountEntity(EntityType.HUMAN) == 0) {
            System.out.println ("ZOMBIE WIN!!!");
            return false;
        } else if (getCountEntity(EntityType.ZOMBIE) == 0){
            System.out.println ("HUMAN WIN!!!");
            return false;
        }
        return true;
    }

    private  Map<Location, Entity> getAroundEntities(Location point) {
        int x = point.getX(), y = point.getY();
        int x1, y1;
        Map<Location, Entity> around = new HashMap<>();
        Location location;
        for (int i = -1; i < 3; i++){
            x1 = x + i;
            if (x1 < 0 || x1 > width) continue;
            for (int j = -1; j < 3; j++) {
                y1 = y + j;
                if (y1 < 0 || y1 > height) continue;
                location = new Location(x1, y1);
                around.put(location, entities.get(location));
            }
        }
        return around;
    }
}