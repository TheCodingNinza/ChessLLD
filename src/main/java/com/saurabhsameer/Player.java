package com.saurabhsameer;

public class Player {

    private String name;
    private String email;

    private Color color;

    private Board board;

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }

    public Color getColor() {
        return color;
    }

    public Player(String name, String email, Color color, Board board) {
        this.name = name;
        this.email = email;
        this.color = color;
        this.board = board;
    }

    public boolean moveAPiece(Coordinate currentPos, Coordinate newPos){

        Cell[][] boardObj = this.board.getBoard();
        boolean res = boardObj[currentPos.getX()][currentPos.getY()].getCurrentPieceOnCell().moveToPosition(newPos,board,this);
        return res;

    }
}
