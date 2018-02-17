package entities;

import helpers.EntityType;
import helpers.Steps;
import map.Location;

import java.util.Map;

public abstract class FleshIAbstract extends AbstractEntity implements FleshI {

    protected Location currentLocation;
    protected Steps steps;
    protected boolean isDead;


    public FleshIAbstract(EntityType typeEnum, Location currentLocation) {
        super(typeEnum);
        this.currentLocation = currentLocation;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public boolean isDead() {
        return isDead;
    }

    public abstract Map<Location, EntityI> walk(Map<Location, EntityI> around);

}
