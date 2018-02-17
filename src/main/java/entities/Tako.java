package entities;

public class Tako extends AbstractEntity implements Material {
    public Tako() {
        super(EntityType.TAKO);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Tako;
    }
}
