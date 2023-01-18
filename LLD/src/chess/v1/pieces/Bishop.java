package chess.v1.pieces;

import chess.v1.Color;
import chess.v1.Piece;
import chess.v1.PieceType;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(PieceType.BISHOP, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
}
