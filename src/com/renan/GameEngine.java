package com.renan;

import java.util.Scanner;

public class GameEngine {
    private boolean isPlayerXTurn = true;
    private int lineChosen;
    private int columnChosen;
    private final Board board = new Board();
    private final Scanner scanner = new Scanner(System.in);


    private void listenPlayers(char player) {
        boolean validMove = true;
        do {
            this.board.renderBoard();
            if (!validMove) System.out.printf("Oops, movimento inválido! Por favor, repita novamente.%n%n");
            System.out.println("Jogador " + player + " escolha a linha que você deseja jogar");
            this.lineChosen = (scanner.nextInt() - 1);
            System.out.println("Jogador " + player + " escolha a coluna que você deseja jogar");
            this.columnChosen = (scanner.nextInt() - 1);
            validMove = this.board.validateMove(this.lineChosen, this.columnChosen);
        }
        while (!validMove);
    }

    private boolean checkWinner() {
       for (int i = 1; i <= 8; i++){
           String line = "";
           switch (i) {
               case 1:
                   line = this.board.getLineElements(0,0, 0, 1, 0, 2);
                   break;
               case 2:
                   line = this.board.getLineElements(1, 0, 1, 1, 1, 2);
                   break;
               case 3:
                   line = this.board.getLineElements(2,0, 2,1, 2, 2);
                   break;
               case 4:
                   line = this.board.getLineElements(0, 0, 1, 0, 2, 0);
                   break;
               case 5:
                   line = this.board.getLineElements(0,1, 1, 1, 2 ,1);
                   break;
               case 6:
                   line = this.board.getLineElements(0, 2, 1, 2, 2, 2);
                   break;
               case 7:
                   line = this.board.getLineElements(0, 0, 1, 1, 2, 2);
                   break;
               case 8:
                   line = this.board.getLineElements(0, 2, 1, 1, 2, 0);
                   break;
           }
           if (line.equals("XXX")) {
               this.board.renderBoard();
               System.out.println("Jogador X venceu!");
               return true;
           }
           if (line.equals("OOO")) {
               this.board.renderBoard();
               System.out.println("Jogador O venceu!");
               return true;
           }
       }

       if (this.board.checkIfBoardIsFull()) {
           this.board.renderBoard();
           System.out.println("Empate! Jogo Finalizado.");
           return true;
       }

       return false;
    }

    public void run() {
        boolean endedGame = false;
        while (!endedGame) {
            for (int i = 1; i <=2; i++) {
                char player = this.isPlayerXTurn ? 'X' : 'O';
                int line = 0;
                int column = 0;

                this.listenPlayers(player);

                this.board.setElement(this.lineChosen, this.columnChosen, player);

                endedGame = checkWinner();
                if (endedGame) break;

                this.isPlayerXTurn = !this.isPlayerXTurn;
            }
        }
    }
}
