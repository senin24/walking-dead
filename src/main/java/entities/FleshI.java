package entities;

import map.Location;

import java.util.Map;

public interface FleshI extends EntityI {

    Map<Location, EntityI> walk(Map<Location, EntityI> around);

    void resetStepsToDead();

    Location getLocation();

    boolean isDead();


}
