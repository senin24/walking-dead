package entities;

import utils.Util;

public class Human extends AbstractFlesh implements Entity {

    private boolean isMale; //only zombies don't have sex ((
    private boolean isWeapon;

    int HUMAN_STEPS_DEAD = 5;

    public Human() {
        super(EntityType.HUMAN);
        stepsToDead = HUMAN_STEPS_DEAD;
        this.isMale = Util.getRandom();
    }

    public boolean isMale() {
        return isMale;
    }

    public boolean isWeapon() {
        return isWeapon;
    }

    public void setWeapon(boolean weapon) {
        isWeapon = weapon;
    }




    public void printEntity() {

    }


    public void resetStepsToDead() {
        stepsToDead = HUMAN_STEPS_DEAD;
    }
}
