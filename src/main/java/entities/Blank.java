package entities;

public class Blank extends AbstractEntity implements Material{
    public Blank() {
        super(EntityType.BLANK);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o instanceof Blank;
    }
}
