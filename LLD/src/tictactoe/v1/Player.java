package tictactoe.v1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Player {
    private String id;
    private String symbolType;

    public int playTurn(int boardSize) {
        Random random = new Random();
        return random.nextInt(boardSize * boardSize);
    }
}
