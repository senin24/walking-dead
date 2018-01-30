package map;

import entities.Entity;
import entities.EntityType;
import utils.Util;

import java.util.HashMap;
import java.util.Map;

public class Island {

    private Map<Location, Entity> entities = new HashMap<Location, Entity>();
    private int width;
    private int height;

    public Island(int width, int height, int stones, int weapons, int takos, int zombies, int humans) {
        this.width = width;
        this.height = height;
        putEntity(stones, EntityType.STONE);
        putEntity(weapons, EntityType.WEAPON);
        putEntity(takos, EntityType.TAKO);
        putEntity(zombies, EntityType.ZOMBIE);
        putEntity(humans, EntityType.HUMAN);
    }

    private void putEntity(int count, EntityType typeEnum) {
        Location location;
        while (count > 0) {
            do {
                location = new Location(Util.getRandom(width), Util.getRandom(height));
            } while (entities.containsKey(location));
            entities.put(location, typeEnum.getEntity());
            count--;
        }
    }

    public void printIsland() {
        Location location;
        Entity entity;
        for (int y=0; y<height; y++) {
            for (int x = 0; x< width; x++) {
                location = new Location(x , y);
                entity = entities.get(location);
                if (entities.containsKey(location)) {
                    entity.getType().printEntity(entity);
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
            System.out.println();
        }
        for (EntityType typeEnum: EntityType.values()){
            typeEnum.printEntity();
            System.out.println(String.format(" - '%s', count - %d", typeEnum.getNameEntity(), getCountEntity(typeEnum)));
        }
    }

    private int getCountEntity(EntityType typeEnum) {
        int i = 0;
        for (Map.Entry<Location, Entity> e: entities.entrySet()){
            if (e.getValue().getType() == typeEnum) i++;
        }
        return i;
    }
}