package chess.v1.pieces;

import chess.v1.Color;
import chess.v1.Piece;
import chess.v1.PieceType;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(PieceType.PAWN, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
}
