package snakesAndLadder;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Dice {

    private int diceCount;

    public int roll() {
        int min = 1, max = 6;
        Random r = new Random();
        int diceSum = 0;
        int dices = diceCount;

        while (dices-- > 0) {
            diceSum += (min + r.nextInt(max));
        }
        System.out.println("Dice Sum is " + diceSum);
        return diceSum;
    }
}
