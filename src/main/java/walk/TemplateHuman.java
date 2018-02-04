package walk;

import entities.Entity;
import entities.Human;

import java.util.Comparator;

public class TemplateHuman {

    private Human human;
    private Entity entity;
    private int score;

    public TemplateHuman(Human human, Entity entity, int score) {
        this.human = human;
        this.entity = entity;
        this.score = score;
    }

    public Entity getEntity() {
        return entity;
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

        if (!human.equals(that.human)) return false;
        return entity.equals(that.entity);
    }

    @Override
    public int hashCode() {
        int result = human.hashCode();
        result = 31 * result + entity.hashCode();
        return result;
    }
}
