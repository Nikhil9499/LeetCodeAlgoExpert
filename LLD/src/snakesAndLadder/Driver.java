package snakesAndLadder;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        game.initializeGame(10, 1, 2, 5, 8);
        game.testInitialization();
        game.start();
    }
}
