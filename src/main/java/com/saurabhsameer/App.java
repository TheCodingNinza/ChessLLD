package com.saurabhsameer;

import java.util.Random;

public class App {

    public static void main(String[] args) {
        Board chessBoard = new Board();


        Player whitePlayer = new Player("Saurabh", "saurabh@richa.com", Color.WHITE, chessBoard);
        Player blackPlayer = new Player("Sameer", "sameer@richa.com", Color.BLACK, chessBoard);

        Game game = new Game(chessBoard, whitePlayer, blackPlayer);


        game.setStatus(GameStatus.ONGOING);
        int count = 0;
        while(game.getStatus() == GameStatus.ONGOING){
            if(count == 0){
                game.play(new Coordinate(1,0),
                        new Coordinate(2,0));
            }else{
                game.play(RandomCoordinateGenerator.generateRandomCoordinate(),
                        RandomCoordinateGenerator.generateRandomCoordinate());
            }

             if(count == 5)
                 break;
             game.printBoard();
             count++;
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
