package entities;

import helpers.EntityType;
import helpers.Steps;
import map.Location;
import helpers.Util;

import java.util.HashMap;
import java.util.Map;

public class FleshZombie extends FleshIAbstract implements EntityI {

    private final static int ZOMBIE_STEPS_DEAD = 60;

    public FleshZombie(Location location) {
        super(EntityType.ZOMBIE, location);
        steps = new Steps(ZOMBIE_STEPS_DEAD);
    }

    //this constructor need for compare TemplatesHumanSteps
    public FleshZombie() {
        super(EntityType.ZOMBIE, null);
    }

    public void resetStepsToDead() {
        steps.resetSteps(ZOMBIE_STEPS_DEAD);
    }

    public Map<Location, EntityI> walk(Map<Location, EntityI> around) {
        Map<Location, EntityI> current = new HashMap<>();
        current.put(currentLocation, this);
        //if zombie is dead then skip walk
        if (isDead) return current;
        if (steps.getCurrentStepRange() == Steps.StepRange.DEATH) {
            isDead = true;
            return current;
        }
        //walking:
        steps.reduceSteps();
        EntityI entityI = null;
        // FleshZombie seek human and dead zombie around
        for (Map.Entry<Location, EntityI> e: around.entrySet()) {
            entityI = e.getValue();
            // FleshZombie eat human without weapon (live or dead) or dead zombie
            if (((entityI instanceof FleshHuman)&& !(((FleshHuman) entityI).isWeapon())) ||
                    ((entityI instanceof FleshZombie) && ((FleshI) entityI).isDead() )) {
                resetStepsToDead();
                current.remove(currentLocation);
                currentLocation = ((FleshI) entityI).getLocation();
                current.put(currentLocation, this);
                return current;
            }
            // If FleshHuman have weapon then FleshZombie dead :(
            if ((entityI instanceof FleshHuman)&& (((FleshHuman) entityI).isWeapon())){
//                Island.getEntities().put(currentLocation, new EntityBlank());
                current.remove(currentLocation);
                current.put(currentLocation, new EntityBlank());
                return current;
            }
        }
        //FleshZombie seek blank field around
        for (Map.Entry<Location, EntityI> e: around.entrySet()) {
            entityI = e.getValue();
            if (entityI instanceof EntityBlank) {
                current.remove(currentLocation);
                currentLocation = Util.getKeyByValue(around, entityI);
                current.put(currentLocation, this);
                return current;
            }
        }
        //FleshZombie hold
        return current;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof FleshZombie;
    }
}
