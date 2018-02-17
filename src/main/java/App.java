import map.Island;

public class App {

    public static void main(String[] args) {
        int wide = 10, height = 10,
                stones = 10, weapons = 5, takos = 5,
                zombies = 5, humans = 10,
                steps = 0;
        Island island = new Island(wide, height, stones, weapons, takos, zombies, humans);
        island.printIsland();
        while (island.turn()) {
            steps ++;
            island.printIsland();
        }
        System.out.println("GAME OVER! Game steps was - " + steps);
    }
}
