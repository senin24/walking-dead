package entities;

public abstract class EntityAbstract implements Entity {

    protected final EntityTypeEnum typeEnum;

    protected EntityAbstract(EntityTypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }


    public EntityTypeEnum getTypeEnum() {
        return typeEnum;
    }



}
