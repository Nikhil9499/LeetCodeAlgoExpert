package chess.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Cell {
    private Piece piece;
    private int x, y;

    @Override
    public String toString() {
        return piece.getPieceType().toString();
    }
}
