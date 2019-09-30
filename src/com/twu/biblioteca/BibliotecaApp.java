package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        app.start();
    }

    public void start() {
        System.out.println(generateWelcomeMessage());

        boolean running = true;
        while(running) {
            System.out.println(generateMenu());
            try {
                int option = readUserInput();
                switch (option) {
                    case 1:
                        //Go to the books listing
                        System.out.println("Will show the books list");
                        break;
                    default:
                        System.out.println("Please select a valid option!");
                }
            } catch (InvalidOptionException e) {
                System.out.println("Please select a valid option!");
            }
        }
    }

    private int readUserInput() {
        System.out.print("Type your input: ");
        String line = sc.nextLine();
        return BibliotecaApp.parseUserInput(line);
    }

    public static int parseUserInput(String input) {
        try {
            int option = Integer.valueOf(input);
            if (option < 1) {
                throw new InvalidOptionException();
            }
            return option;
        } catch(NumberFormatException e) {
            throw new InvalidOptionException();
        }
    }

    public String generateWelcomeMessage() {
        return "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    }

    public String generateMenu() {
        return "1 - List of books";
    }
}
