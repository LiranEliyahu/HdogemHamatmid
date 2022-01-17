package Parse.AbstractClass;

import Extract.Types.CsvExtract;

import java.io.IOException;

public abstract class Parser extends CsvExtract {
    private String targetPath;

    public Parser(String path) throws IOException {
        super(path);
    }

    protected String getTargetPath() {
        return targetPath;
    }

    protected void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

    protected abstract void parseData();
}
