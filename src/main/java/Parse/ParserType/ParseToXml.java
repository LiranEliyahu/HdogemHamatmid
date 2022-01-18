package Parse.ParserType;

import Extract.Types.CsvExtract;
import Parse.Interface.Parser;
import java.io.IOException;

public class ParseToXml implements Parser {
    
    //cTor
    public ParseToXml(String path) throws IOException {
        parseData(new CsvExtract(path));
    }

    @Override
    public void parseData(CsvExtract newStack) {

    }
}
