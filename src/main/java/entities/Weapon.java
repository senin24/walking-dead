package entities;

public class Weapon extends AbstractEntity implements Material {

    public Weapon() {
        super(EntityType.WEAPON);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Weapon;
    }
}
