package entities;

public abstract class AbstractFlesh extends AbstractEntity implements Flesh {

    protected int stepsToDead;

    public AbstractFlesh(EntityType typeEnum) {
        super(typeEnum);
    }

    public int getStepsToDead() {
        return stepsToDead;
    }

    public void walk() {

    }

}
