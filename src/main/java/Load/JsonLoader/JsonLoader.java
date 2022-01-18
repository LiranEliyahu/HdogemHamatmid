package Load.JsonLoader;

import Load.Interface.Loader;
import Parse.ParserType.ParseToJson;
import org.json.simple.JSONArray;
import java.io.FileWriter;
import java.io.IOException;

public class JsonLoader implements Loader {
    private int limit;
    private String path;
    private String target;

    //cTor
    public JsonLoader(String path, String targetDir) throws IOException {
        setPath(path);
        setLimit(50000);
        setTarget(targetDir);
        LoadToDir(new ParseToJson(getPath()).getTests());
    }

    //getters & setters
    protected int getLimit() {
        return limit;
    }
    protected String getPath() {
        return path;
    }
    protected String getTarget() {
        return target;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    protected void setTarget(String target) {
        this.target = target;
    }

    @Override
    public void LoadToDir(JSONArray tests) throws IOException {
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

















