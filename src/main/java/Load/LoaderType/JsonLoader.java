package Load.LoaderType;

import Load.AbstractClass.Loader;
import Parse.ParserType.ParseToJson;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

public class JsonLoader extends Loader {
    private int limit;

    //cTor
    public JsonLoader(String path, String targetDir) throws IOException {
        setPath(path);
        setLimit(50000);
        setTarget(targetDir);
        LoadToDir();
    }

    //getters & setters
    protected int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void LoadToDir() throws IOException {
        JSONArray tests = new ParseToJson(getPath()).getTests();

        int currLength = 0;
        int newLength = 0;
        int fileIndex = 1;
        String fileName = "list_";

        while(currLength < tests.size()){
            FileWriter f = getDirWriter(getTarget() + fileName + fileIndex + ".json");
            newLength += Math.min((tests.size() - currLength), getLimit());
            f.write(String.valueOf(tests.subList(currLength, newLength)));
            f.flush();
            currLength += newLength;
            fileIndex++;
        }
    }

    private FileWriter getDirWriter(String file) throws IOException {
        return new FileWriter(file);
    }
}

















