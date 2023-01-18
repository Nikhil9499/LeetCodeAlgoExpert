package chess.v1;

import chess.v1.pieces.*;
import lombok.Data;

import java.util.Deque;

@Data
public class Board {
    private Deque<Player> players;
    private Cell[][] cells;
    private int boardSize;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        initialiseBoard(boardSize);
    }

    public void initialiseBoard(int boardSize) {
        this.boardSize = boardSize;
        cells = new Cell[boardSize][boardSize];
        initialiseCells();
    }

    private void initialiseCells() {
        for (int i=0; i<this.boardSize; i++) {
            Color color;
            if (i<=1) {
                color = Color.BLACK;
            } else {
                color = Color.WHITE;
            }

            for (int j=0; j<this.boardSize; j++) {
                // Pawns
                Cell cell = Cell.builder().build();
                if (i == 1 || i == this.boardSize - 2) {
                    cell = Cell.builder()
                            .piece(new Pawn(color))
                            .x(i)
                            .y(j)
                            .build();
                } else if (i==0 || i==boardSize-1) {
                    // Rook
                    if (j==0 || j==boardSize-1) {
                        cell = Cell.builder()
                                .piece(new Rook(color))
                                .x(i)
                                .y(j)
                                .build();
                    }

                    // Knight
                    if (j==1 || j==boardSize-2) {
                        cell = Cell.builder()
                                .piece(new Knight(color))
                                .x(i)
                                .y(j)
                                .build();
                    }

                    // Bishop
                    if (j==2 || j==boardSize-3) {
                        cell = Cell.builder()
                                .piece(new Bishop(color))
                                .x(i)
                                .y(j)
                                .build();
                    }

                    //King
                    if (j==3) {
                        cell = Cell.builder()
                                .piece(new King(color))
                                .x(i)
                                .y(j)
                                .build();
                    }

                    //Queen
                    if (j==4) {
                        cell = Cell.builder()
                                .piece(new Queen(color))
                                .x(i)
                                .y(j)
                                .build();
                    }
                }

                this.cells[i][j] = cell;
            }
        }
    }

    public Cell getCell(int x, int y) {
        return cells[x][y];
    }
}
