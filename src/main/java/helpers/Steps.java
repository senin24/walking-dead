package helpers;

public class Steps {

    private int stepCount;
    private int maxStepCount;
    private StepRange stepRange;

    public Steps(int stepCount) {
        this.stepCount = stepCount;
        maxStepCount = stepCount;
        stepRange = StepRange.NORMAL;
    }

    // Constr for TemplatesHumanSteps
    public Steps(StepRange stepRange) {
        this.stepRange = stepRange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Steps steps = (Steps) o;
        return stepRange == steps.stepRange;
    }

    @Override
    public int hashCode() {
        return stepRange.hashCode();
    }

    public enum StepRange {
        NORMAL,
        WARNING,
        DEATH
    }

    public StepRange getCurrentStepRange () {
        if (stepCount == 0) return StepRange.DEATH;
        if (stepCount >0 && stepCount < maxStepCount*0.5) return StepRange.WARNING;
        return StepRange.NORMAL;
    }

    public void resetSteps (int stepCount) {
        this.stepCount = stepCount;
        stepRange = StepRange.NORMAL;
    }

    public void reduceSteps () {
        stepCount --;
    }



}
