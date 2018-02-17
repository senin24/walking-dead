package helpers;

import entities.*;
import helpers.Steps;
import helpers.TemplateHuman;

import java.util.ArrayList;
import java.util.List;

public class TemplatesHumanSteps {

    public static final List<TemplateHuman> templatesHumanSteps = new ArrayList<TemplateHuman>();

    static {
        //isWeapon false, steps Normal, MaterialWeapon around
        int score = 100;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)),
                new MaterialWeapon(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)),
                new MaterialWeapon(), score));

        //isWeapon true, steps Normal, FleshZombie around
        score = 90;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshZombie(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshZombie(), score));

        //isWeapon true, steps Warning, FleshZombie around
        score = 80;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.WARNING)),
                new FleshZombie(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.WARNING)),
                new FleshZombie(), score));

        //steps Warning, MaterialTako around
        score = 85;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.WARNING)),
                new MaterialTako(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.WARNING)),
                new MaterialTako(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.WARNING)),
                new MaterialTako(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.WARNING)),
                new MaterialTako(), score));

        //sex, steps Normal, around Female
        score = 75;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, true, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(false, true, new Steps(Steps.StepRange.WARNING)), score));

        //sex, steps Normal, around Male
        score = 75;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, true, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)),
                new FleshHuman(true, true, new Steps(Steps.StepRange.WARNING)), score));

        // go to blank
        score = 20;
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.NORMAL)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.NORMAL)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.NORMAL)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.NORMAL)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, false, new Steps(Steps.StepRange.WARNING)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, false, new Steps(Steps.StepRange.WARNING)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(false, true, new Steps(Steps.StepRange.WARNING)),
                new EntityBlank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new FleshHuman(true, true, new Steps(Steps.StepRange.WARNING)),
                new EntityBlank(), score));
    }


}
