package chess.v1.pieces;

import chess.v1.Color;
import chess.v1.Piece;
import chess.v1.PieceType;

public class Queen extends Piece {

    public Queen(Color color) {
        super(PieceType.QUEEN, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
}
