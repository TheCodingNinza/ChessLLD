package com.saurabhsameer;

import java.util.Arrays;

public class Board {

    private final int SIZE = 8;
    private Cell[][] board;


    public Board() {
        this.board = new Cell[SIZE][SIZE];
        initializeBoard();
    }

    private void initializeBoard(){
        int[] rowNumbers = {1,SIZE-2};

        for(int rowNumber: rowNumbers){
            for(int i=0; i < SIZE; i++){
                Cell cell = null;
                Color pieceColor = null;
                Color cellColor = null;
                if(rowNumber == 1){
                    pieceColor = Color.WHITE;
                    if(i % 2 == 0)
                        cellColor = Color.BLACK;
                    else
                        cellColor = Color.WHITE;
                }else{
                    pieceColor = Color.BLACK;
                    if(i % 2 == 0)
                        cellColor = Color.WHITE;
                    else
                        cellColor = Color.BLACK;
                }
                cell = new Cell(true, cellColor, new Pawn(new Coordinate(rowNumber, i), pieceColor));
                board[rowNumber][i] = cell;

            }
        }

        int pointerOne = 0;
        int pointerTwo = SIZE-1;

        while(pointerOne < 3){
            Cell cellOne = null;
            Cell cellTwo = null;
            Cell cellThree = null;
            Cell cellFour = null;

            if(pointerOne == 0){
                cellOne = new Cell(true, Color.WHITE,
                        new Elephant(new Coordinate(0,pointerOne),Color.WHITE));
                cellTwo = new Cell(true, Color.BLACK,
                        new Elephant(new Coordinate(0,pointerTwo),Color.WHITE));
                cellThree = new Cell(true, Color.BLACK,
                        new Elephant(new Coordinate(SIZE-1,pointerOne),Color.BLACK));
                cellFour = new Cell(true, Color.WHITE,
                        new Elephant(new Coordinate(SIZE-1,pointerTwo),Color.BLACK));
            } else if (pointerOne == 1) {
                cellOne = new Cell(true, Color.BLACK,
                        new Horse(new Coordinate(0,pointerOne),Color.WHITE));
                cellTwo = new Cell(true, Color.WHITE,
                        new Horse(new Coordinate(0,pointerTwo),Color.WHITE));
                cellThree = new Cell(true, Color.WHITE,
                        new Horse(new Coordinate(SIZE-1,pointerOne),Color.BLACK));
                cellFour = new Cell(true, Color.BLACK,
                        new Horse(new Coordinate(SIZE-1,pointerTwo),Color.BLACK));
            } else if (pointerOne == 2) {
                cellOne = new Cell(true, Color.WHITE,
                        new Bishop(new Coordinate(0,pointerOne),Color.WHITE));
                cellTwo = new Cell(true, Color.BLACK,
                        new Bishop(new Coordinate(0,pointerTwo),Color.WHITE));
                cellThree = new Cell(true, Color.BLACK,
                        new Bishop(new Coordinate(SIZE-1,pointerOne),Color.BLACK));
                cellFour = new Cell(true, Color.WHITE,
                        new Bishop(new Coordinate(SIZE-1,pointerTwo),Color.BLACK));
            }

            this.board[cellOne.getCurrentPieceOnCell().getCurrentPosition().getX()][cellOne.getCurrentPieceOnCell()
                    .getCurrentPosition().getY()] = cellOne;

            this.board[cellTwo.getCurrentPieceOnCell().getCurrentPosition().getX()][cellTwo.getCurrentPieceOnCell()
                    .getCurrentPosition().getY()] = cellTwo;

            this.board[cellThree.getCurrentPieceOnCell().getCurrentPosition().getX()][cellThree.getCurrentPieceOnCell()
                    .getCurrentPosition().getY()] = cellThree;

            this.board[cellFour.getCurrentPieceOnCell().getCurrentPosition().getX()][cellFour.getCurrentPieceOnCell()
                    .getCurrentPosition().getY()] = cellFour;

            pointerOne++;
            pointerTwo--;

        }

        this.board[0][pointerOne] = new Cell(true, Color.BLACK,
                new Queen(new Coordinate(0, pointerOne), Color.WHITE));
        this.board[SIZE-1][pointerOne] = new Cell(true, Color.WHITE,
                new King(new Coordinate(SIZE-1, pointerOne), Color.BLACK));
        this.board[0][pointerTwo] = new Cell(true, Color.WHITE,
                new King(new Coordinate(0, pointerTwo), Color.WHITE));
        this.board[SIZE-1][pointerTwo] = new Cell(true, Color.BLACK,
                new Queen(new Coordinate(SIZE-1, pointerTwo), Color.BLACK));

        Color switchColor = Color.WHITE;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(this.board[i][j] == null){
                    this.board[i][j] = new Cell(false, switchColor, null);
                }
                if(switchColor == Color.WHITE){
                    switchColor= Color.BLACK;
                }else{
                    switchColor = Color.WHITE;
                }
            }
        }
    }

    public Cell[][] getBoard() {
        return board;
    }


}
