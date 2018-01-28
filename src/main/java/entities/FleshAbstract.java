package entities;

public abstract class FleshAbstract extends EntityAbstract implements Flesh {

    protected int stepsToDead;

    public FleshAbstract(EntityTypeEnum typeEnum) {
        super(typeEnum);
    }

    public int getStepsToDead() {
        return stepsToDead;
    }

    public void walk() {

    }

}
