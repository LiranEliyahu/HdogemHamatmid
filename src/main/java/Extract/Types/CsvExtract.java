package Extract.Types;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Stack;
import Extract.AbstractClass.ExtractFile;

public class CsvExtract extends ExtractFile {
    private final Stack<String[]> lines = new Stack<>();

    //cTor
    public CsvExtract(String path) throws IOException {
        setPath(path);
        extractInfo();
    }

    //getter
    public Stack<String[]> getLines() {
        return this.lines;
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
