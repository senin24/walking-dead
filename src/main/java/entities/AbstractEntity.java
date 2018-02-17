package entities;

import helpers.EntityType;

public abstract class AbstractEntity implements EntityI {

    protected final EntityType type;

    protected AbstractEntity(EntityType type) {
        this.type = type;
    }


    public EntityType getType() {
        return type;
    }



}
