
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Language flash card class
 * @author vijayramalingom
 */
public class LanguageFlashCards extends AbstractFlashCards {
    /**
     * comma delimeter
     */
    private static final String COMMA_DELIMETER = ",";
    /**
     * stores the inputed filename 
     */
    String filename;
    
    /**
     * default constructor throws exception if filename is not found
     * @param filename
     * @throws IOException 
     */
    public LanguageFlashCards(String filename) throws IOException {
        super();
        this.filename = filename;
        String columnHeadings[];
        int i = 0;
        FileReader file = new FileReader(this.filename);
        try {
            BufferedReader reader = new BufferedReader(file);
            String line;
            while ((line=reader.readLine()) != null) {
                columnHeadings = line.split(",");
                if (i != 0) {
                    this.addCard(columnHeadings[0], columnHeadings[1]);
                }
                i++;
            }
        }
        catch (Exception e1) {
            System.err.println(e1.getMessage());
        }
        finally {
            file.close();
        }
        
    }
}

