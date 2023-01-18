package chess.v1.pieces;

import chess.v1.Color;
import chess.v1.Piece;
import chess.v1.PieceType;

public class Knight extends Piece {

    public Knight(Color color) {
        super(PieceType.KNIGHT, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
}
