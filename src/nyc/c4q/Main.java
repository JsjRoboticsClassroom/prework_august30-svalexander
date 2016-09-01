package nyc.c4q;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        while (hangman.getMisses() < 5) {
            hangman.printCurrentWord();
            hangman.promptPlayer("Enter a letter: ");
            hangman.readLetter();
            hangman.checkLetter();
            if (hangman.guessedSuccessfully()) {
                break;
            }
            System.out.println(Drawing.get(hangman.getMisses()));
            System.out.println("Misses -> " + hangman.getMisses());
        }
        if (hangman.guessedSuccessfully()) {
            System.out.println("Success");
        } else {
            System.out.println("The answer was " + hangman.getSecretWord());
        }
        System.out.println("Would you like to play again?");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        Boolean newGame = true;
        while (newGame) {
            if (input.toLowerCase().equals("yes") || (input.toLowerCase().equals("y"))) {
                Hangman hangman2 = new Hangman();
                while (hangman2.getMisses() < 5) {
                    hangman2.printCurrentWord();
                    hangman2.promptPlayer("Enter a letter: ");
                    hangman2.readLetter();
                    hangman2.checkLetter();
                    if (hangman2.guessedSuccessfully()) {
                        break;
                    }
                    System.out.println(Drawing.get(hangman2.getMisses()));
                    System.out.println("Misses -> " + hangman2.getMisses());
                }
                if (hangman2.guessedSuccessfully()) {
                    System.out.println("Success");
                } else {
                    System.out.println("The answer was " + hangman2.getSecretWord());
                }

            } else if (input.toLowerCase().equals("no") || input.toLowerCase().equals("n")) {
                System.out.println("Ok, till next time");
            } else {
                System.out.println("Please enter yes or no");
                String input2 = scanner.next();
            }
        }

    }
}
