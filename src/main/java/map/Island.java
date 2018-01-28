package map;

import entities.Entity;
import entities.EntityTypeEnum;
import utils.Util;

import java.util.HashMap;
import java.util.Map;

public class Island {

    private Map<Location, Entity> entities = new HashMap<Location, Entity>();
    private int wide;
    private int height;

    public Island(int wide, int height, int stones, int weapons, int takos, int zombies, int humans) {
        this.wide = wide;
        this.height = height;
        putEntity(stones, EntityTypeEnum.STONE);
        putEntity(weapons, EntityTypeEnum.WEAPON);
        putEntity(takos, EntityTypeEnum.TAKO);
        putEntity(zombies, EntityTypeEnum.ZOMBIE);
        putEntity(humans, EntityTypeEnum.HUMAN);
    }

    private void putEntity(int count, EntityTypeEnum typeEnum) {
        Location location;
        while (count > 0) {
            do {
                location = new Location(Util.getRandom(wide), Util.getRandom(height));
            } while (entities.containsKey(location));
            entities.put(location, typeEnum.getEntity());
            count--;
        }
    }

    public void printIsland() {
        Location location;
        Entity entity;
        for (int y=0; y<height; y++) {
            for (int x=0; x<wide; x++) {
                location = new Location(x , y);
                entity = entities.get(location);
                if (entities.containsKey(location)) {
                    entity.getTypeEnum().printEntity(entity);
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
            System.out.println();
        }
        for (EntityTypeEnum typeEnum: EntityTypeEnum.values()){
            typeEnum.printEntity();
            System.out.println(String.format(" - '%s', count - %d", typeEnum.getNameEntity(), getCountEntity(typeEnum)));
        }
    }

    private int getCountEntity(EntityTypeEnum typeEnum) {
        int i = 0;
        for (Map.Entry<Location, Entity> e: entities.entrySet()){
            if (e.getValue().getTypeEnum() == typeEnum) i++;
        }
        return i;
    }
}