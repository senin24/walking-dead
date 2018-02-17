package entities;

import helpers.EntityType;

public class MaterialWeapon extends AbstractEntity implements MaterialI {

    public MaterialWeapon() {
        super(EntityType.WEAPON);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof MaterialWeapon;
    }
}
