package Parse.ParserType;

import Extract.Types.CsvExtract;
import Parse.Interface.Parser;
import Parse.Enum.Fields;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.IOException;

public class ParseToJson implements Parser{
    private final JSONArray tests = new JSONArray();

    //cTor
    public ParseToJson(String path) throws IOException {
        parseData(new CsvExtract(path));
    }

    //getter
    public JSONArray getTests() {
        return tests;
    }

    @Override
    public void parseData(CsvExtract newStack) {
        int caseNumber = 1;
        while(!newStack.getLines().isEmpty()){
            getTests().add(organizer(newStack.getLines().pop(), caseNumber));
            caseNumber++;
        }
    }

    private JSONObject organizer(String[] line, int current){
        JSONObject info = new JSONObject();
        JSONObject testNumber = new JSONObject();

        for (int i = 0; i < line.length; i++) {
             info.put(Fields.values()[i].getField(), line[i]);
        }

        testNumber.put("test_" + current,info);
        return testNumber;
    }
}
