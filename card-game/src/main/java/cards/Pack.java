package cards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pack {
    
    public static ArrayList<Integer> getPack(String fileName) throws IOException {

        // create array for values
        ArrayList<Integer> cardValues = new ArrayList<Integer>();

        // check if filePath is null
        if(fileName == null) {
            throw new FileNotFoundException("Must enter a file value.");
        }

        File fileObj = new File(fileName + ".txt");

        try {
            BufferedReader fileParser = new BufferedReader(new FileReader(fileObj));
            String currentLine = "";
            int currentLineInt = 0;

            while ((currentLine = fileParser.readLine()) != null) {
                currentLine = currentLine.replaceAll(" ", "");

                try {
                    currentLineInt = Integer.parseInt(currentLine);
                } catch (NumberFormatException e) {
                    System.out.println("Pack must contain only integers");
                }

                if (currentLineInt >= 0) {
                    cardValues.add(Integer.parseInt(currentLine));
                }
                else {
                    System.out.println("Pack is invalid: Numbers must be non-negative");
                    System.exit(0);
                }

            }

            fileParser.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.exit(0);
        }

         return cardValues;
    }
}
