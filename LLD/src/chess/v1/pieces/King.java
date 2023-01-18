package chess.v1.pieces;

import chess.v1.Color;
import chess.v1.Piece;
import chess.v1.PieceType;

public class King extends Piece {

    public King(Color color) {
        super(PieceType.KING, color);
    }

    @Override
    public boolean isValidMove() {
        return true;
    }
}
