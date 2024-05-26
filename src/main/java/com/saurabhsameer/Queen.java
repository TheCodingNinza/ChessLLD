package com.saurabhsameer;

import java.util.*;

public class Queen implements Piece{

    private Coordinate currentPosition;
    private Color color;

    private Set<Coordinate> enemyPositions;

    public Queen(Coordinate currentPosition, Color color) {
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
    public  Set<Coordinate> validPositions(Board board){
        Set<Coordinate> validPos = new HashSet<>();
        Set<Coordinate> enemyPos = new HashSet<>();
        Cell[][] boardObj = board.getBoard();

        for(int i = this.currentPosition.getX()-1, j = this.currentPosition.getY()-1;
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            i--;
            j--;
        }
        for(int i = this.currentPosition.getX()+1, j = this.currentPosition.getY()+1;
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            i++;
            j++;
        }
        for(int i = this.currentPosition.getX()-1, j = this.currentPosition.getY()+1;
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            i--;
            j++;
        }
        for(int i = this.currentPosition.getX()+1, j = this.currentPosition.getY()-1;
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            i++;
            j--;
        }
        for(int i = this.currentPosition.getX()-1, j = this.currentPosition.getY();
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            i--;
        }
        for(int i = this.currentPosition.getX()+1, j = this.currentPosition.getY();
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            i++;
        }
        for(int i = this.currentPosition.getX(), j = this.currentPosition.getY()+1;
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            j++;
        }
        for(int i = this.currentPosition.getX(), j = this.currentPosition.getY()-1;
            i < 8 &&  i > -1 && j < 8 && j > -1;){
            if(boardObj[i][j].isOccupied()){
                if(boardObj[i][j].getCurrentPieceOnCell().getColor() != this.color){
                    Coordinate tempPos = new Coordinate(i,j);
                    enemyPos.add(tempPos);
                }
                break;
            }else{
                Coordinate tempPos = new Coordinate(i,j);
                validPos.add(tempPos);
            }
            j--;
        }

        this.enemyPositions = enemyPos;

        return validPos;
    }

    private boolean validatePosition(Coordinate position, Board board){
        Set<Coordinate> validPos = validPositions(board);
//        List<Coordinate> valP = new ArrayList<>(validPos) ;
//        System.out.println("valid pos");
//        for (int i = 0; i < valP.size(); i++) {
//            System.out.println("X: "+valP.get(i).getX()+" Y: "+valP.get(i).getY());
//        }
//        System.out.println("enemy pos:");
//        valP = new ArrayList<>(this.enemyPositions);
//        for (int i = 0; i < valP.size(); i++) {
//            System.out.println("X: "+valP.get(i).getX()+" Y: "+valP.get(i).getY());
//        }

        return validPos.contains(position) || this.enemyPositions.contains(position);
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
