package entities;

import entities.fields.Steps;
import map.Island;
import map.Location;
import utils.Util;
import walk.TemplateHuman;
import walk.TemplatesHumanSteps;

import java.util.*;

public class Human extends AbstractFlesh implements Entity {

    private boolean isMale; //only zombies don't have sex ((
    private boolean isWeapon;
    private List<TemplateHuman> currentVariantsSteps;

    private final static int HUMAN_STEPS_DEAD = 5;

    public Human(Location location) {
        super(EntityType.HUMAN,location);
        steps = new Steps(HUMAN_STEPS_DEAD);
        this.isMale = Util.getRandom();
    }

    //this constructor need for compare TemplatesHumanSteps
    public Human(boolean isMale, boolean isWeapon, Steps steps) {
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

    public Map<Location, Entity> walk(Map<Location, Entity> around) {
        Map<Location, Entity> current = new HashMap<>();
        current.put(currentLocation, this);
        //if human is dead then skip walk
        if (isDead) return current;
        if (steps.getCurrentStepRange() == Steps.StepRange.DEATH) {
            isDead = true;
            return current;
        }
        steps.reduceSteps();

        currentVariantsSteps = new ArrayList<TemplateHuman>();
        for (Map.Entry<Location, Entity> e: around.entrySet()){
            Entity entity = e.getValue();
            TemplateHuman possibleVariantsStep = 
                    new TemplateHuman(this, entity, 0);
            if (TemplatesHumanSteps.templatesHumanSteps.contains(possibleVariantsStep)) {
                currentVariantsSteps.add(possibleVariantsStep); 
            }
        }
        if (currentVariantsSteps.isEmpty()) return current;

        //get the best variant of step
        Collections.sort(currentVariantsSteps, TemplateHuman.getCompByScore());
        Entity currentEntity = currentVariantsSteps.get(0).getEntity();
        switch (currentEntity.getType()) {
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
        currentLocation = Util.getKeyByValue(around, currentEntity);
        current.put(currentLocation, this);
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        if (isDead) return false;

        Human human = (Human) o;

        if (isMale != human.isMale) return false;
        if (steps.getCurrentStepRange() != human.steps.getCurrentStepRange()) {
            return false;
        }
        return isWeapon == human.isWeapon;
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
