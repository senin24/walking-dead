package entities;

public class FleshZombie extends FleshAbstract implements Entity {

    public FleshZombie() {
        super(EntityTypeEnum.ZOMBIE);
        super.stepsToDead = ZOMBIE_STEPS_DEAD;
    }

    public void resetStepsToDead() {
        super.stepsToDead = ZOMBIE_STEPS_DEAD;
    }
}
