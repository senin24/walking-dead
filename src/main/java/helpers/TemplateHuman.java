package helpers;

import entities.EntityI;
import entities.FleshHuman;

import java.util.Comparator;

public class TemplateHuman {

    private FleshHuman fleshHuman;
    private EntityI entityI;
    private int score;

    public TemplateHuman(FleshHuman fleshHuman, EntityI entityI, int score) {
        this.fleshHuman = fleshHuman;
        this.entityI = entityI;
        this.score = score;
    }

    public EntityI getEntityI() {
        return entityI;
    }

    public static Comparator<TemplateHuman> getCompByScore() {
        Comparator<TemplateHuman> comp = new Comparator<TemplateHuman>() {
            public int compare(TemplateHuman t1, TemplateHuman t2) {
                if (t1.score == t2.score) return 0;
                return (t1.score > t2.score) ? -1 : 1;
            }
        };
        return comp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplateHuman that = (TemplateHuman) o;

        if (!fleshHuman.equals(that.fleshHuman)) return false;
        return entityI.equals(that.entityI);
    }

    @Override
    public int hashCode() {
        int result = fleshHuman.hashCode();
        result = 31 * result + entityI.hashCode();
        return result;
    }
}
