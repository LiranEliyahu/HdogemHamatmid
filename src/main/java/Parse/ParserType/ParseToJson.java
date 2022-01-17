package Parse.ParserType;

import Parse.AbstractClass.Parser;
import org.json.simple.JSONArray;
import java.io.IOException;

public class ParseToJson extends Parser {
    private JSONArray tests;
    private final int limit = 50000;

    protected int getLimit() {
        return limit;
    }
    public JSONArray getTests() {
        return tests;
    }

    public ParseToJson(String targetPath, String path) throws IOException {
        super(path);
        setTargetPath(targetPath);
    }

    @Override
    protected void parseData() {

        while(!getLines().isEmpty()){
            for (int i = 0; i < getLimit(); i++) {
                getLines().pop();
            }
        }

        getLines();
    }
}
