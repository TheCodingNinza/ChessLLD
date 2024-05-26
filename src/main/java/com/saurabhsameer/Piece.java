package com.saurabhsameer;

import java.util.Set;

public interface Piece {

    boolean moveToPosition(Coordinate position, Board board, Player player);

    Coordinate getCurrentPosition();

    Color getColor();

    Set<Coordinate> validPositions(Board board);
}
