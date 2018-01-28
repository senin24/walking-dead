import map.Island;

public class App {

    public static void main(String[] args) {
        int wide = 10, height = 10, stones = 10, weapons = 5, takos = 5, zombies = 10, humans = 10;
        Island island = new Island(wide, height, stones, weapons, takos, zombies, humans);
        island.printIsland();
    }
}
