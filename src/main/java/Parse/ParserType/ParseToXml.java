package Parse.ParserType;

import Parse.Enum.FieldsOfStageA;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import Extract.Types.CsvExtract;
import Parse.Interface.Parser;
import java.io.IOException;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ParseToXml implements Parser {
    private final Stack<Document> docStack = new Stack<>();
    private int limit;

    //cTor
    public ParseToXml(String path) throws IOException, ParserConfigurationException {
        parseData(new CsvExtract(path));
        setLimit(50000);
    }

    //getters & setters
    public Stack<Document> getDocStack() {
        return docStack;
    }
    public int getLimit() {
        return limit;
    }
    protected void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void parseData(CsvExtract csvStack) throws ParserConfigurationException {
        while(!csvStack.getLines().isEmpty()){
            Document d = getNewDoc();

            for (int i = 0; i < getLimit() && (!csvStack.getLines().isEmpty()); i++) {
                d.appendChild(getXmlElment(d, csvStack.getLines().pop()));
            }
            getDocStack().push(d);
        }
    }

    private Document getNewDoc() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.newDocument();
    }

    private Element getXmlElment(Document d, String[] line){
        Element e = d.createElement("labTest");

        for (int i = 0; i < line.length; i++) {
            Element newTest = d.createElement(FieldsOfStageA.values()[i].getField());
            newTest.setTextContent(line[i]);
            e.appendChild(newTest);
        }

        return e;
    }
}
