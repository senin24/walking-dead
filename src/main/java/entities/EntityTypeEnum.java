package entities;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

public enum EntityTypeEnum {

    HUMAN ("Человек", 'H', Ansi.BColor.CYAN) {
        public FleshHuman getEntity () {
            return new FleshHuman();
        }
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    ZOMBIE ("Зомби", 'Z', Ansi.BColor.RED) {
        public Entity getEntity() {
            return new FleshZombie();
        }
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    STONE ("Препятствие", 'S', Ansi.BColor.WHITE) {
        public Entity getEntity() {
            return new MaterialStone();
        }
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    TAKO ("Еда", 'T', Ansi.BColor.GREEN) {
        public Entity getEntity() {
            return new MaterialTako();
        }
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    WEAPON ("Оружие", 'W', Ansi.BColor.BLUE) {
        public Entity getEntity() {
            return new MaterialWeapon();
        }
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    };

    private String nameEntity;
    protected char display;
    protected Ansi.BColor color;
    // https://github.com/dialex/JCDP
    ColoredPrinter cp = new ColoredPrinter.Builder(1, false).build();

    EntityTypeEnum(String nameEntity, char display, Ansi.BColor color) {
        this.nameEntity = nameEntity;
        this.display = display;
        this.color = color;
    }

    public String getNameEntity() {
        return nameEntity;
    }

    public abstract Entity getEntity ();
    //method for print Memo
    public abstract void printEntity ();

    //method for print map
    public void printEntity (Entity entity) {
        //Human entity print field
        if (entity.getTypeEnum() == EntityTypeEnum.HUMAN){
            FleshHuman human = (FleshHuman) entity;
            String displayHuman = "H";
            if (human.isMale()) {
                displayHuman += "M";
            } else {
                displayHuman += "F";
            }
            if (human.isWeapon()) {
                displayHuman += "W";
            } else {
                displayHuman += "-";
            }
            cp.print(displayHuman, Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
        } else {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
        }
        cp.clear();
    }



}
