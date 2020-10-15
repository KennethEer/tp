package seedu.modtracker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Deals with loading tasks from and saving tasks to a file.
 */
public class Storage {
    private final String filePath;
    private File file;

    /**
     * Creates a new Storage object with a File created at the specified file path.
     *
     * @param filePath File path whereby data is loaded from and stored at.
     */
    public Storage(String filePath) {
        if (filePath == null) {
            throw new NullPointerException();
        }

        this.filePath = filePath;
        try {
            file = new File(filePath);
            file.getParentFile().mkdirs();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a scanner object to read the file.
     *
     * @return Scanner to read the file of the Storage object.
     * @throws FileNotFoundException If the file cannot be found.
     */
    public Scanner getReader() throws FileNotFoundException {
        assert file != null : "File should not be null";
        return new Scanner(file);
    }

    /**
     * Appends the specified input to the storage file and creates a new line.
     *
     * @param input The input to be appended to the file.
     */
    public void appendToFile(String input) {
        assert filePath != null : "File path should not be null";
        assert file != null : "File should not be null";
        try {
            // creates a FileWriter in append mode
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(input + System.lineSeparator());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
