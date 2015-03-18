package nyc.c4q.ac21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
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
        double words = 0;
        double sentences = 0;
        double verbosity;

        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {          // grabs each new line of text from the scanner
                String line = sc.nextLine();

                for (int i = 0; i < line.length(); i++) { // loops through the line of text, tallying spaces and punctuation
                    if (line.charAt(i) == ' ')
                        words += 1;
                    if (line.charAt(i) == '.' || line.charAt(i) == '!' || line.charAt(i) == '?')  // could be improved to account for multiple punctuation marks in one sentence (e.g. '...')
                        sentences += 1;
                }

            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        verbosity = words / sentences;
        return verbosity;

    }

}