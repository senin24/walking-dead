package entities;

public abstract class AbstractEntity implements Entity {

    protected final EntityType type;

    protected AbstractEntity(EntityType type) {
        this.type = type;
    }


    public EntityType getType() {
        return type;
    }



}
