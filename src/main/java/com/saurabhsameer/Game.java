package com.saurabhsameer;

public class Game {

    private GameStatus status;

    private Turn currentTurn;
    private Board board;
    private Player playerOne;
    private Player playerTwo;

    private Coordinate whiteKingCurrentPosition;

    private Coordinate blackKingCurrentPosition;

    private boolean isMovementOfWhiteKingMandatory;

    private boolean isMovementOfBlackKingMandatory;

    public Game(Board board, Player playerOne, Player playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.status = GameStatus.NOTSTARTED;
        this.currentTurn = Turn.WHITE;
        this.whiteKingCurrentPosition = new Coordinate(0,4);
        this.blackKingCurrentPosition = new Coordinate(7, 3);
        this.isMovementOfBlackKingMandatory = false;
        this.isMovementOfWhiteKingMandatory = false;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public void play(Coordinate currPos, Coordinate moveToPos){

        if(this.board.getBoard()[currPos.getX()][currPos.getY()].isOccupied() == false){
            return;
        }

        if(this.currentTurn == Turn.WHITE){
            if(isMovementOfWhiteKingMandatory
                    && this.board.getBoard()[whiteKingCurrentPosition.getX()][whiteKingCurrentPosition.getY()]
                    .getCurrentPieceOnCell().validPositions(board).size() == 0){
                this.status = GameStatus.BLACKPLAYERWINS;
                return;
            }
            if(this.isMovementOfWhiteKingMandatory){
                if(this.board.getBoard()[currPos.getX()][currPos.getY()]
                        .getCurrentPieceOnCell().getClass() != King.class
                        && this.board.getBoard()[currPos.getX()][currPos.getY()]
                        .getCurrentPieceOnCell().getColor() != Color.WHITE){
                    return;
                }
            }
            boolean isMoved = playerOne.moveAPiece(currPos, moveToPos);
            if(isMoved) {
                if(this.board.getBoard()[moveToPos.getX()][moveToPos.getY()]
                        .getCurrentPieceOnCell().getClass() == King.class){
                    this.whiteKingCurrentPosition = moveToPos;
                }
                if(this.board.getBoard()[moveToPos.getX()][moveToPos.getY()]
                        .getCurrentPieceOnCell().validPositions(board).contains(this.blackKingCurrentPosition)){
                    this.isMovementOfBlackKingMandatory = true;
                }else{
                    this.isMovementOfBlackKingMandatory = false;
                }
                this.currentTurn = Turn.BLACK;
            }
        }else{
            if(isMovementOfBlackKingMandatory
                    && this.board.getBoard()[blackKingCurrentPosition.getX()][blackKingCurrentPosition.getY()]
                    .getCurrentPieceOnCell().validPositions(board).size() == 0){
                this.status = GameStatus.WHITEPLAYERWINS;
                return;
            }
            if(this.isMovementOfBlackKingMandatory){
                if(this.board.getBoard()[currPos.getX()][currPos.getY()]
                        .getCurrentPieceOnCell().getClass() != King.class
                        && this.board.getBoard()[currPos.getX()][currPos.getY()]
                        .getCurrentPieceOnCell().getColor() != Color.BLACK){
                    return;
                }
            }
            boolean isMoved = playerTwo.moveAPiece(currPos, moveToPos);
            if(isMoved) {
                if(this.board.getBoard()[currPos.getX()][currPos.getY()]
                        .getCurrentPieceOnCell().getClass() == King.class){
                    this.blackKingCurrentPosition = moveToPos;
                }
                if(this.board.getBoard()[currPos.getX()][currPos.getY()]
                        .getCurrentPieceOnCell().validPositions(board).contains(this.whiteKingCurrentPosition)){
                    this.isMovementOfWhiteKingMandatory = true;
                }else{
                    this.isMovementOfWhiteKingMandatory = false;
                }
                this.currentTurn = Turn.WHITE;
            }
        }

    }

    public void printBoard(){
        Cell[][] boardObj = this.board.getBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(!boardObj[i][j].isOccupied())
                    System.out.print("0 \t");
                else
                    System.out.print(boardObj[i][j].getCurrentPieceOnCell().getClass()+"\t");
            }
            System.out.println("");
        }
    }


}
