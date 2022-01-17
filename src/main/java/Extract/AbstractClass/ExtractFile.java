package Extract.AbstractClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public abstract class ExtractFile {
    private String path;

    protected void setPath(String path) throws IOException {
        this.path = path;
        extractInfo();
    }

    protected String getPath() {
        return path;
    }

    protected abstract void extractInfo() throws IOException;

    protected BufferedReader getFile() throws FileNotFoundException{
        return new BufferedReader(new FileReader(getPath()));

    }
}
