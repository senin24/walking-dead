package entities;

import helpers.EntityType;
import helpers.Steps;
import map.Island;
import map.Location;
import helpers.Util;
import helpers.TemplateHuman;
import helpers.TemplatesHumanSteps;

import java.util.*;

public class FleshHuman extends FleshIAbstract implements EntityI {

    private boolean isMale; //only zombies don't have sex ((
    private boolean isWeapon;
    private List<TemplateHuman> currentVariantsSteps;

    private final static int HUMAN_STEPS_DEAD = 50;

    public FleshHuman(Location location) {
        super(EntityType.HUMAN,location);
        steps = new Steps(HUMAN_STEPS_DEAD);
        this.isMale = Util.getRandom();
    }

    //this constructor need for compare TemplatesHumanSteps
    public FleshHuman(boolean isMale, boolean isWeapon, Steps steps) {
        super(EntityType.HUMAN, null);
        this.isMale = isMale;
        this.isWeapon = isWeapon;
        this.steps = steps;
    }

    public boolean isMale() {
        return isMale;
    }

    public boolean isWeapon() {
        return isWeapon;
    }

    public Map<Location, EntityI> walk(Map<Location, EntityI> around) {
        Map<Location, EntityI> current = new HashMap<>();
        current.put(currentLocation, this);
        //if human is dead then skip walk
        if (isDead) return current;
        if (steps.getCurrentStepRange() == Steps.StepRange.DEATH) {
            isDead = true;
            return current;
        }
        steps.reduceSteps();

        currentVariantsSteps = new ArrayList<TemplateHuman>();
        for (Map.Entry<Location, EntityI> e: around.entrySet()){
            EntityI entityI = e.getValue();
            TemplateHuman possibleVariantsStep = 
                    new TemplateHuman(this, entityI, 0);
            if (TemplatesHumanSteps.templatesHumanSteps.contains(possibleVariantsStep)) {
                currentVariantsSteps.add(possibleVariantsStep); 
            }
        }
        if (currentVariantsSteps.isEmpty()) return current;

        //get the best variant of step
        Collections.sort(currentVariantsSteps, TemplateHuman.getCompByScore());
        EntityI currentEntityI = currentVariantsSteps.get(0).getEntityI();
        switch (currentEntityI.getType()) {
            case TAKO:
                Island.createNewEntity(EntityType.TAKO);
                resetStepsToDead();
                break;
            case WEAPON:
                isWeapon = true;
                break;
            case HUMAN:
                Island.createNewEntity(EntityType.HUMAN);
                return current;
        }
        current.remove(currentLocation);
        currentLocation = Util.getKeyByValue(around, currentEntityI);
        current.put(currentLocation, this);
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FleshHuman)) return false;

        if (isDead) return false;

        FleshHuman fleshHuman = (FleshHuman) o;

        if (isMale != fleshHuman.isMale) return false;
//        if (steps.getCurrentStepRange() != fleshHuman.steps.getCurrentStepRange()) {
//            return false;
//        }
        if (!this.steps.equals(fleshHuman.steps)) return false;
        return isWeapon == fleshHuman.isWeapon;
    }

    @Override
    public int hashCode() {
        int result = (isMale ? 1 : 0);
        result = 31 * result + (isWeapon ? 1 : 0);
        return result;
    }

    public void printEntity() {

    }


    public void resetStepsToDead() {
        steps.resetSteps(HUMAN_STEPS_DEAD);
    }
}
