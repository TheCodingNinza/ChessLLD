package com.saurabhsameer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class King implements Piece{

    private Coordinate currentPosition;
    private Color color;

    private Set<Coordinate> enemyPositions;

    public King(Coordinate currentPosition, Color color) {
        this.currentPosition = currentPosition;
        this.color = color;
    }

    @Override
    public boolean moveToPosition(Coordinate position, Board board, Player player) {
        if(player.getColor() != this.color)
            return false;
        boolean result = validatePosition(position,board);
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
    public Set<Coordinate> validPositions(Board board){
        Set<Coordinate> validPos = new HashSet<>();
        Set<Coordinate> enemyPos = new HashSet<>();

        Cell[][] boardObj = board.getBoard();

        int i, j;

        i = this.currentPosition.getX()-1;
        j = this.currentPosition.getY()-1;
        if(i < 8 &&  i > -1 && j < 8 && j > -1) {
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX()+1;
        j = this.currentPosition.getY()+1;
        if(i < 8 &&  i > -1 && j < 8 && j > -1) {
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX()-1;
        j = this.currentPosition.getY()+1;
        if(i < 8 &&  i > -1 && j < 8 && j > -1){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX()+1;
        j = this.currentPosition.getY()-1;
        if(i < 8 &&  i > -1 && j < 8 && j > -1){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }


        i = this.currentPosition.getX()-1;
        j = this.currentPosition.getY();
        if(i < 8 &&  i > -1 && j < 8 && j > -1){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX()+1;
        j = this.currentPosition.getY();
        if(i < 8 &&  i > -1 && j < 8 && j > -1){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX();
        j = this.currentPosition.getY()+1;
        if(i < 8 &&  i > -1 && j < 8 && j > -1){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }

        i = this.currentPosition.getX();
        j = this.currentPosition.getY()-1;
        if(i < 8 &&  i > -1 && j < 8 && j > -1){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
        }
        this.enemyPositions = enemyPos;

        return validPos;

    }

    private boolean validatePosition(Coordinate position,Board board){
        Set<Coordinate> validPos = validPositions(board);
        boolean result = validPos.contains(position) || this.enemyPositions.contains(position);
        if(result){
            List<Set<Coordinate>> unsafePositions = new ArrayList<>();
            Cell[][] boardObj = board.getBoard();
            for(int i=0; i< boardObj.length; i++){
                for(int j=0; j < boardObj[0].length;j++){
                    if(boardObj[i][j].isOccupied() && boardObj[i][j].getColor() != this.color){
                        Set<Coordinate> unsafePosition = boardObj[i][j].getCurrentPieceOnCell().validPositions(board);
                        unsafePositions.add(unsafePosition);
                    }
                }
            }
            for(Set<Coordinate> unsafePosition: unsafePositions){
                if(unsafePosition.contains(position))
                    return false;
            }
            return true;
        }else{
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
}
