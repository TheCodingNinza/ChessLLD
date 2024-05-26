package com.saurabhsameer;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Board chessBoard = new Board();


        Player whitePlayer = new Player("Saurabh", "saurabh@gmail.com", Color.WHITE, chessBoard);
        Player blackPlayer = new Player("Sameer", "sameer@gmail.com", Color.BLACK, chessBoard);

        Game game = new Game(chessBoard, whitePlayer, blackPlayer);

        Coordinate[] fromCoordinates = {
                new Coordinate(1, 4), new Coordinate(6, 4), // Pawn moves
                new Coordinate(0, 3), new Coordinate(7, 3), // Queen moves
                new Coordinate(0, 2), new Coordinate(7, 2), // Bishop moves
                new Coordinate(0, 0), new Coordinate(7, 0), // Rook moves
                new Coordinate(1, 5), new Coordinate(4, 3)  // Pawn and queen moves
        };

        Coordinate[] toCoordinates = {
                new Coordinate(2, 4), new Coordinate(5, 4),
                new Coordinate(3, 3), new Coordinate(4, 3),
                new Coordinate(3, 5), new Coordinate(4, 5),
                new Coordinate(0, 2), new Coordinate(5, 0),
                new Coordinate(2, 5), new Coordinate(2, 5)  // Checkmate move
        };


        game.setStatus(GameStatus.ONGOING);
        int i = 0;
        while(game.getStatus() == GameStatus.ONGOING){
                game.play(fromCoordinates[i], toCoordinates[i]);
                i++;
                game.printBoard();
//                if(i == 8)
//                    break;
        }






    }


    static class RandomCoordinateGenerator {
        // Simple Linear Congruential Generator (LCG) for demonstration purposes
        private static long seed = System.currentTimeMillis();

        private static int nextInt(int bound) {
            seed = (seed * 48271) % 2147483647;
            return (int) (seed % bound);
        }

        public static Coordinate generateRandomCoordinate() {
            int x = nextInt(8); // 0 to 7 inclusive
            int y = nextInt(8); // 0 to 7 inclusive
            return new Coordinate(x, y);
        }

        public static void main(String[] args) {
            Coordinate randomCoordinate = generateRandomCoordinate();
            System.out.println(randomCoordinate);
        }
    }

}
