package entities;

public interface Entity {

    int HUMAN_STEPS_DEAD = 5;
    int ZOMBIE_STEPS_DEAD = 10;

    EntityTypeEnum getTypeEnum ();
}
