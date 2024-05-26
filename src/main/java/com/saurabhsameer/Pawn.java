package com.saurabhsameer;

import java.util.HashSet;
import java.util.Set;

public class Pawn implements Piece{

    private Coordinate currentPosition;

    private Color color;

    public Pawn(Coordinate currentPosition, Color color) {
        this.currentPosition = currentPosition;
        this.color = color;
    }

    @Override
    public boolean moveToPosition(Coordinate position, Board board, Player player) {
        if(player.getColor() != this.color)
            return false;
        boolean result = validatePosition(position, board);
        if(result){
            if(board.getBoard()[position.getX()][position.getY()].isOccupied()) {
                if(board.getBoard()[position.getX()][position.getY()].getCurrentPieceOnCell().getColor() != this.color) {
                    board.getBoard()[position.getX()][position.getY()].setCurrentPieceOnCell(this);
                    board.getBoard()[this.currentPosition.getX()][this.currentPosition.getY()] = new Cell(false,
                            board.getBoard()[this.currentPosition.getX()][this.currentPosition.getY()].getColor(),
                            null);
                    this.currentPosition = position;
                }else{
                    return false;
                }
            }else{
                board.getBoard()[position.getX()][position.getY()].setCurrentPieceOnCell(this);
                board.getBoard()[position.getX()][position.getY()].setOccupied(true);
                board.getBoard()[this.currentPosition.getX()][this.currentPosition.getY()] = new Cell(false,
                        board.getBoard()[this.currentPosition.getX()][this.currentPosition.getY()].getColor(),
                        null);
                this.currentPosition = position;
            }
            return true;
        }
        return false;
    }



    private boolean validatePosition(Coordinate position, Board board) {
        Cell[][] boardObj = board.getBoard();
        int i,j;
        if(this.color == Color.BLACK){

            i = this.currentPosition.getX()-1;
            j = this.currentPosition.getY();
            if(i >= 0 && i < 8 && j >= 0 && j < 8){
                if(position.getX() == i && position.getY() == j){
                    return true;
                }
            }

            i = this.currentPosition.getX()-1;
            j = this.currentPosition.getY()-1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8 && boardObj[i][j].isOccupied()){
                if(position.getX() == i && position.getY() == j){
                    return true;
                }
            }

            i = this.currentPosition.getX()-1;
            j = this.currentPosition.getY()+1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8 && boardObj[i][j].isOccupied()){
                if(position.getX() == i && position.getY() == j){
                    return true;
                }
            }

            return false;

        }else{
            i = this.currentPosition.getX()+1;
            j = this.currentPosition.getY();
            if(i >= 0 && i < 8 && j >= 0 && j < 8){
                if(position.getX() == i && position.getY() == j){
                    return true;
                }
            }

            i = this.currentPosition.getX()+1;
            j = this.currentPosition.getY()-1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8 && boardObj[i][j].isOccupied()){
                if(position.getX() == i && position.getY() == j){
                    return true;
                }
            }

            i = this.currentPosition.getX()+1;
            j = this.currentPosition.getY()+1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8 && boardObj[i][j].isOccupied()){
                if(position.getX() == i && position.getY() == j){
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public Coordinate getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public Set<Coordinate> validPositions(Board board) {
        Set<Coordinate> validPos = new HashSet<>();
        Cell[][] boardObj = board.getBoard();

        int i,j;
        if(this.color == Color.BLACK){

            i = this.currentPosition.getX()-1;
            j = this.currentPosition.getY()-1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8){
                if(boardObj[i][j].isOccupied()){
                    if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                        Coordinate tempPos = new Coordinate(i,j);
                        validPos.add(tempPos);
                    }
                }else{
                    Coordinate tempPos = new Coordinate(i,j);
                    validPos.add(tempPos);
                }
            }

            i = this.currentPosition.getX()-1;
            j = this.currentPosition.getY()+1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8){
                if(boardObj[i][j].isOccupied()){
                    if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                        Coordinate tempPos = new Coordinate(i,j);
                        validPos.add(tempPos);
                    }
                }else{
                    Coordinate tempPos = new Coordinate(i,j);
                    validPos.add(tempPos);
                }
            }
        }else{

            i = this.currentPosition.getX()+1;
            j = this.currentPosition.getY()-1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8){
                if(boardObj[i][j].isOccupied()){
                    if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                        Coordinate tempPos = new Coordinate(i,j);
                        validPos.add(tempPos);
                    }
                }else{
                    Coordinate tempPos = new Coordinate(i,j);
                    validPos.add(tempPos);
                }
            }

            i = this.currentPosition.getX()+1;
            j = this.currentPosition.getY()+1;
            if(i >= 0 && i < 8 && j >= 0 && j < 8){
                if(boardObj[i][j].isOccupied()){
                    if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                        Coordinate tempPos = new Coordinate(i,j);
                        validPos.add(tempPos);
                    }
                }else{
                    Coordinate tempPos = new Coordinate(i,j);
                    validPos.add(tempPos);
                }
            }
        }
        return validPos;
    }
}
