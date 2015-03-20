package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Access Code 2.1
 * Ramona Harrison
 * VerbosityCalculator.java
 * Calculate the verbosity of a text
 */

public class VerbosityCalculator {

    public static void main(String[] args){

        File dickens = new File("/Users/mona/Desktop/accesscode/VerbosityCalculator/resources/a-tale-of-two-cities.txt");
        File melville = new File("/Users/mona/Desktop/accesscode/VerbosityCalculator/resources/moby-dick.txt");

        double dickensVerbosity = read(dickens);
        double melvilleVerbosity = read(melville);

        System.out.printf("Verbosity of Charles Dickens' A Tale of Two Cities: %.2f", dickensVerbosity);
        System.out.printf("\nVerbosity of Herman Melville's Moby Dick: %.2f", melvilleVerbosity);

        if (dickensVerbosity > melvilleVerbosity)
            System.out.println("\n\nDickens is more verbose.");
        else
            System.out.println("\n\nMelville is more verbose.");

    }

    public static double read(File file) {
                                                                // reads specified file to calculate verbosity

        double totalWords = 0;
        double sentences = 0;
        double verbosity;

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {                          // grabs each new line of text from the scanner
                String line = sc.nextLine();
                String[] words = line.split(" ");               // splits the line into a string array

                for (int i = 0; i < words.length; i++) {        // loops through the array, tallying words
                    totalWords += 1;

                    if (words[i].length() > 0) {                // checks each word to see if it ends with a valid punctuation mark, tallying sentences

                        char last = words[i].charAt(words[i].length() - 1);
                        if (( last == '.' || last == '!' || last == '?') && !extraneousPunctuation(words[i])) {
                            sentences += 1;
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        verbosity = totalWords / sentences;                     // calculates and returns verbosity
        return verbosity;

    }

    public static boolean extraneousPunctuation(String word) {
        if (word.equalsIgnoreCase("Mr.") ||  word.equalsIgnoreCase("Mrs.") || word.contains("...")) {
            return true;
        } else {                                                // discounts instances of 'extraneous punctuation'
            return false;                                       // (more cases could be added to improve accuracy)
        }

    }

}