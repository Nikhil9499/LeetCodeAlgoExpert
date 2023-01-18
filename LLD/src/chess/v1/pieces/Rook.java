package chess.v1.pieces;

import chess.v1.Color;
import chess.v1.Piece;
import chess.v1.PieceType;

public class Rook extends Piece {

    public Rook(Color color) {
        super(PieceType.ROOK, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
}
