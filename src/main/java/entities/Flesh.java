package entities;

import map.Location;

import java.util.Map;

public interface Flesh extends Entity {

    Map<Location, Entity> walk(Map<Location, Entity> around);

    void resetStepsToDead();

    Location getLocation();

    boolean isDead();


}
