package Parse.Interface;

import Extract.Types.CsvExtract;
import health_care_provider.errors.InvalidIdException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public interface Parser {
    void parseData(CsvExtract csvStack) throws ParserConfigurationException, TransformerException, InvalidIdException;
}
