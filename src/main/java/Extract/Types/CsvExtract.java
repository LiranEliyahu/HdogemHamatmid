package Extract.Types;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import Extract.AbstractClass.ExtractFile;

public class CsvExtract extends ExtractFile {
    private Stack<String[]> lines;

    public CsvExtract(String path) throws IOException {
        setPath(path);
        extractInfo();
    }

    protected Stack<String[]> getLines() {
        return lines;
    }

    @Override
    protected void extractInfo() throws IOException {
        BufferedReader file = getFile();
        String row;

        while ((row = file.readLine()) != null) {
            String[] data = row.split(",");
            getLines().push(data);
        }
        file.close();
    }
}
