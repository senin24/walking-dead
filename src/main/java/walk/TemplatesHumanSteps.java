package walk;

import entities.*;
import entities.fields.Steps;

import java.util.ArrayList;
import java.util.List;

public class TemplatesHumanSteps {

    public static final List<TemplateHuman> templatesHumanSteps = new ArrayList<TemplateHuman>();

    static {
        //isWeapon false, steps Normal, Weapon around
        int score = 100;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)),
                new Weapon(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)),
                new Weapon(), score));

        //isWeapon true, steps Normal, Zombie around
        score = 90;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)),
                new Zombie(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)),
                new Zombie(), score));

        //isWeapon true, steps Warning, Zombie around
        score = 80;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.WARNING)),
                new Zombie(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.WARNING)),
                new Zombie(), score));

        //steps Warning, Tako around
        score = 85;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.WARNING)),
                new Tako(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.WARNING)),
                new Tako(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.WARNING)),
                new Tako(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.WARNING)),
                new Tako(), score));

        //sex, steps Normal, around Female
        score = 75;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, true, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(false, true, new Steps(Steps.StepRange.WARNING)), score));

        //sex, steps Normal, around Male
        score = 75;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, true, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, false, new Steps(Steps.StepRange.WARNING)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)),
                new Human(true, true, new Steps(Steps.StepRange.WARNING)), score));

        // go to blank
        score = 20;
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.NORMAL)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.NORMAL)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.NORMAL)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.NORMAL)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, false, new Steps(Steps.StepRange.WARNING)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, false, new Steps(Steps.StepRange.WARNING)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(false, true, new Steps(Steps.StepRange.WARNING)),
                new Blank(), score));
        templatesHumanSteps.add(new TemplateHuman(
                new Human(true, true, new Steps(Steps.StepRange.WARNING)),
                new Blank(), score));
    }


}
