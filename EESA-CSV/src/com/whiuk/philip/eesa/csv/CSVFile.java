package com.whiuk.philip.eesa.csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Provides methods for creating, writing and manipulating a CSV file.
 * @author Philip
 */
public class CSVFile {
    /**
     * 
     */
    private final File file;
    /**
     * 
     */
    private final String delimeter;    
    /**
     * 
     */
    private ArrayList<String[]> lines;
    /**
     * 
     * @param f The file backing the CSV data
     * @param d The delimiter used to separate values
     */
    public CSVFile(final File f, final String d) {
        file = f;
        delimeter = d;
        lines = new ArrayList<String[]>(0);
    }
    /**
     * 
     * @param line A single line in separated fields to be added
     */
    public final void addLine(final String[] line) {
        lines.add(line);
    }
    /**
     * 
     * @return The data from the file separated into fields
     */
    public final String[][] getLines() {
        return lines.toArray(new String[][]{});
    }
    /*
     * 
     */
    /**
     * 
     * @throws CSVException CSV Exception
     */
    public final void readFromFile() throws CSVException {
        BufferedReader reader = null;        
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                lines.add(reader.readLine().split(","));
                line = reader.readLine();
            }
        } catch (FileNotFoundException ex) {
            throw new CSVException(ex);
        } catch (IOException ex) {
            throw new CSVException(ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                throw new CSVException(ex);
            }
        }
    }
    /**
     * 
     * @throws CSVException 
     */
    public final void writeToFile() throws CSVException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < lines.size(); i++) {
                String[] line = lines.get(i);
                for (int j = 0; j < line.length; j++) {
                    if (j != 0) {
                        writer.append(delimeter);
                    }
                    writer.write(line[j]);
                }
                writer.newLine();
            }
        } catch (FileNotFoundException ex) {
            throw new CSVException(ex);
        } catch (IOException ex) {
            throw new CSVException(ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                throw new CSVException(ex);
            }
        }
    }
}
