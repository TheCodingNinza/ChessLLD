package com.saurabhsameer;

import java.util.HashSet;
import java.util.Set;

public class Horse implements Piece{

    private Coordinate currentPosition;
    private Color color;

    public Horse(Coordinate currentPosition, Color color) {
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

    @Override
    public Coordinate getCurrentPosition() {
        return this.currentPosition;
    }

    @Override
    public Set<Coordinate> validPositions(Board board){
        Set<Coordinate> validPos = new HashSet<>();
        Cell[][] boardObj = board.getBoard();

        int i = -1, j = -1;
        i = this.currentPosition.getX()-1;
        j = this.currentPosition.getY()-2;
        if(i >= 0 && j >= 0 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    validPos.add(tempPos);
                };
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX() - 2;
        j = this.currentPosition.getY() - 1;
        if(i >= 0 && j >= 0 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        i = this.currentPosition.getX() + 1;
        j = this.currentPosition.getY() - 2;
        if(i <= 8 && j >= 0 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        i = this.currentPosition.getX() + 2;
        j = this.currentPosition.getY() - 1;
        if(i <= 8 && j >= 0 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        i = this.currentPosition.getX() - 1;
        j = this.currentPosition.getY() + 2;
        if(i >= 0 && j <= 8 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        i = this.currentPosition.getX() - 2;
        j = this.currentPosition.getY() + 1;
        if(i >= 0 && j <= 8 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        i = this.currentPosition.getX() + 1;
        j = this.currentPosition.getY() + 2;
        if(i <= 8 && j <= 8 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        i = this.currentPosition.getX() + 2;
        j = this.currentPosition.getY() + 1;
        if(i <= 8 && j <= 8 && this.currentPosition.getX() == i && this.currentPosition.getY() == j){
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

        return validPos;
        
    }

    private boolean validatePosition(Coordinate position, Board board){
        Set<Coordinate> validPos = validPositions(board);
        return validPos.contains(position);
    }



    @Override
    public Color getColor() {
        return this.color;
    }
}