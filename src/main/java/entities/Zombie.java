package entities;

import entities.fields.Steps;
import map.Island;
import map.Location;
import utils.Util;

import java.util.HashMap;
import java.util.Map;

public class Zombie extends AbstractFlesh implements Entity {

    private final static int ZOMBIE_STEPS_DEAD = 60;

    public Zombie(Location location) {
        super(EntityType.ZOMBIE, location);
        steps = new Steps(ZOMBIE_STEPS_DEAD);
    }

    //this constructor need for compare TemplatesHumanSteps
    public Zombie() {
        super(EntityType.ZOMBIE, null);
    }

    public void resetStepsToDead() {
        steps.resetSteps(ZOMBIE_STEPS_DEAD);
    }

    public Map<Location, Entity> walk(Map<Location, Entity> around) {
        Map<Location, Entity> current = new HashMap<>();
        current.put(currentLocation, this);
        //if zombie is dead then skip walk
        if (isDead) return current;
        if (steps.getCurrentStepRange() == Steps.StepRange.DEATH) {
            isDead = true;
            return current;
        }
        //walking:
        steps.reduceSteps();
        Entity entity = null;
        // Zombie seek human and dead zombie around
        for (Map.Entry<Location, Entity> e: around.entrySet()) {
            entity = e.getValue();
            // Zombie eat human without weapon (live or dead) or dead zombie
            if (((entity instanceof Human)&& !(((Human) entity).isWeapon())) ||
                    ((entity instanceof Zombie) && ((Flesh) entity).isDead() )) {
                resetStepsToDead();
                current.remove(currentLocation);
                currentLocation = ((Flesh) entity).getLocation();
                current.put(currentLocation, this);
                return current;
            }
            // If Human have weapon then Zombie dead :(
            if ((entity instanceof Human)&& (((Human) entity).isWeapon())){
//                Island.getEntities().put(currentLocation, new Blank());
                current.remove(currentLocation);
                current.put(currentLocation, new Blank());
                return current;
            }
        }
        //Zombie seek blank field around
        for (Map.Entry<Location, Entity> e: around.entrySet()) {
            entity = e.getValue();
            if (entity instanceof Blank) {
                current.remove(currentLocation);
                currentLocation = Util.getKeyByValue(around, entity);
                current.put(currentLocation, this);
                return current;
            }
        }
        //Zombie hold
        return current;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Zombie;
    }
}
