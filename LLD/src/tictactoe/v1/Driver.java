package tictactoe.v1;

public class Driver {
    public static void main(String[] args) {
        System.out.println("TicTacToe");
        Game game = new Game();
        game.initializeGameObjects(10, 4);
        game.testInitialization();
        game.startGame();
    }
}
