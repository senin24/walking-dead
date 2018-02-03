package entities;

public class Zombie extends AbstractFlesh implements Entity {

    int ZOMBIE_STEPS_DEAD = 10;

    public Zombie() {
        super(EntityType.ZOMBIE);
        stepsToDead = ZOMBIE_STEPS_DEAD;
    }

    public void resetStepsToDead() {
        stepsToDead = ZOMBIE_STEPS_DEAD;
    }
}
