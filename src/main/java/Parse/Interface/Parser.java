package Parse.Interface;

import Extract.Types.CsvExtract;
import javax.xml.parsers.ParserConfigurationException;

public interface Parser {
    void parseData(CsvExtract csvStack) throws ParserConfigurationException;
}
