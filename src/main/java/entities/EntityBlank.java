package entities;

import helpers.EntityType;

public class EntityBlank extends AbstractEntity implements MaterialI {
    public EntityBlank() {
        super(EntityType.BLANK);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof EntityBlank;
    }
}
