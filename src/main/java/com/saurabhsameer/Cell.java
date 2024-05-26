package com.saurabhsameer;

public class Cell {

    private boolean isOccupied;
    private Color color;
    private Piece currentPieceOnCell;

    public Cell(boolean isOccupied, Color color, Piece currentPieceOnCell) {
        this.isOccupied = isOccupied;
        this.color = color;
        this.currentPieceOnCell = currentPieceOnCell;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Color getColor() {
        return color;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setCurrentPieceOnCell(Piece currentPieceOnCell) {
        this.currentPieceOnCell = currentPieceOnCell;
    }

    public Piece getCurrentPieceOnCell() {
        return currentPieceOnCell;
    }
}
