package com.renan;

import java.sql.Array;
import java.util.Arrays;

public class Board {
    private final char[][] elements = new char[3][3];

    public void setElement(int line, int column, char player) {
        this.elements[line][column] = player;
    }

    public String getLineElements(int line,int column, int line2,int column2, int line3,int column3) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.elements[line][column]).append(this.elements[line2][column2]).append(this.elements[line3][column3]);
        return sb.toString();
    }

    public boolean validateMove(int line, int column) {
        int[] desiredPositions = {0, 1, 2};
        if (Arrays.stream(desiredPositions).noneMatch(x -> x == line || x == column)) return false;
        if (this.elements[line][column] != 0)  return false;
        return true;
    }

    public boolean checkIfBoardIsFull() {
        for (int i = 0; i < this.elements.length; i++ ) {
            for (int j = 0; j < this.elements.length; j++) {
                if (this.elements[i][j] == 0) return false;
            }
        }
        return true;
    }

    public void renderBoard () {
        System.out.println("   1   2   3");
        for (int i = 0; i < this.elements.length; i++) {
            System.out.print(i + 1 + "-");
            for (int j = 0; j < this.elements[i].length; j++) {
                System.out.print((this.elements[i][j] == 0 ? "   " : (" " + this.elements[i][j] + " ")) + (j != 2 ? "|" : ""));
                if (j == 2) {
                    System.out.printf("%n");
                }
            }
            if (i != 2) {
                System.out.println("---------------");
            }
        }
        System.out.printf("%n");
    };
}

