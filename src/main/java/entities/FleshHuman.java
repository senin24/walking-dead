package entities;

import utils.Util;

public class FleshHuman extends FleshAbstract implements Entity {

    private boolean isMale; //only zombies don't have sex ((
    private boolean isWeapon;

    public FleshHuman() {
        super(EntityTypeEnum.HUMAN);
        super.stepsToDead = HUMAN_STEPS_DEAD;
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
        super.stepsToDead = HUMAN_STEPS_DEAD;
    }
}
