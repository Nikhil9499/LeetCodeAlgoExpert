package chess.v1;

public class Driver {
    public static void main(String[] args) {
        Game chessGame = new Game();
        chessGame.initialiseGame(8, 2);
        chessGame.checkInitialization();
        chessGame.startGame();
    }
}
