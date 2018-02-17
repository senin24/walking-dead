package entities;

import helpers.EntityType;

public class MaterialTako extends AbstractEntity implements MaterialI {
    public MaterialTako() {
        super(EntityType.TAKO);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof MaterialTako;
    }
}
