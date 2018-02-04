package entities;

import com.diogonunes.jcdp.color.ColoredPrinter;
import com.diogonunes.jcdp.color.api.Ansi;

//Utility Enum class for print entities

public enum EntityType {

    HUMAN ("Человек", 'H', Ansi.BColor.CYAN) {
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    ZOMBIE ("Зомби", 'Z', Ansi.BColor.RED) {
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    STONE ("Препятствие", 'S', Ansi.BColor.WHITE) {
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    TAKO ("Еда", 'T', Ansi.BColor.GREEN) {
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    BLANK ("Пусто", '.', Ansi.BColor.GREEN) {
        public void printEntity() {
            cp.print(" " + this.display + " ", Ansi.Attribute.BOLD, Ansi.FColor.WHITE, this.color);
            cp.clear();
        }
    },
    WEAPON ("Оружие", 'W', Ansi.BColor.BLUE) {
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

    EntityType(String nameEntity, char display, Ansi.BColor color) {
        this.nameEntity = nameEntity;
        this.display = display;
        this.color = color;
    }

    public String getNameEntity() {
        return nameEntity;
    }

    //method for print Memo
    public abstract void printEntity ();

    //method for print map
    public void printEntity (Entity entity) {
        //Human entity print field
        if (entity.getType() == EntityType.HUMAN){
            Human human = (Human) entity;
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
