package com.lab;

import java.util.Scanner;

public class App {
    static Minesweeper initMineField() {
        Minesweeper game = new Minesweeper(9, 9);
        game.setMineCell(0, 1);
        game.setMineCell(1, 5);
        game.setMineCell(1, 8);
        game.setMineCell(2, 4);
        game.setMineCell(3, 6);
        game.setMineCell(4, 2);
        game.setMineCell(5, 4);
        game.setMineCell(6, 2);
        game.setMineCell(7, 2);
        game.setMineCell(8, 6);
        return game;
    }

    static Minesweeper initMineFieldFromFile(String minefieldFile) {
        return new Minesweeper(minefieldFile);
    }

    public static void main(String[] args) {
        
        System.out.println("Welcome to Minesweeper Game!");
        System.out.println("1. Load predefined minefield");
        System.out.println("2. Load minefield from file");
        System.out.print("Choose an option (1/2): ");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        Minesweeper game = null;

        if (choice == 1) {
            game = initMineField();  
        } else if (choice == 2) {
            System.out.print("Enter the file name (e.g., minefield01.txt): ");
            String fileName = input.next();
            game = initMineFieldFromFile(fileName);  
        } else {
            System.out.println("Invalid option! Exiting.");
            return;
        }

        
        game.displayField();

        
        System.out.print("Enter X coordinate (0-" + (game.fieldX - 1) + "): ");
        int x = input.nextInt();
        System.out.print("Enter Y coordinate (0-" + (game.fieldY - 1) + "): ");
        int y = input.nextInt();

        
        game.checkMine(x, y);
    }
}
