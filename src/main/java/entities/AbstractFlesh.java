package entities;

import entities.fields.Steps;
import map.Location;

import java.util.Map;

public abstract class AbstractFlesh extends AbstractEntity implements Flesh {

    protected Location currentLocation;
    protected Steps steps;
    protected boolean isDead;


    public AbstractFlesh(EntityType typeEnum, Location currentLocation) {
        super(typeEnum);
        this.currentLocation = currentLocation;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public boolean isDead() {
        return isDead;
    }

    public abstract Map<Location, Entity> walk(Map<Location, Entity> around);

}
