package Parse.ParserType;

import Parse.Enum.FieldsOfStageA;
import health_care_provider.HealthCareInfoProvider;
import health_care_provider.errors.InvalidIdException;
import health_care_provider.models.PersonInsured;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import Extract.Types.CsvExtract;
import Parse.Interface.Parser;
import java.io.IOException;
import java.util.Objects;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class ParseToXml implements Parser {
    private final Stack<Document> docStack = new Stack<>();
    private int limit = 50000;
    private int id;
    private int idNum;

    //cTor
    public ParseToXml(String path) throws IOException, ParserConfigurationException, TransformerException, InvalidIdException {
        parseData(new CsvExtract(path));
    }

    //getters & setters
    public Stack<Document> getDocStack() {
        return docStack;
    }
    public int getIdNum() {
        return idNum;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }
    public int getLimit() {
        return limit;
    }

    @Override
    public void parseData(CsvExtract csvStack) throws ParserConfigurationException, TransformerException, InvalidIdException {
        while (csvStack.getLines().size() != 1) {
            Document d = getNewDoc();
            Element labTests = d.createElement("labTests");
            Element temp;
            d.appendChild(labTests);

            for (int i = 0; i < getLimit() && (csvStack.getLines().size() != 1); i++) {
                temp = getXmlElement(d, csvStack.getLines().pop());
                temp.appendChild(getFromApi(d,"JOIN_DATE"));
                temp.appendChild(getFromApi(d,"HEALTH_CARE_ID"));
                temp.appendChild(getFromApi(d,"HEALTH_CARE_NAME"));
                labTests.appendChild(temp);

            }
            getDocStack().push(d);
        }
    }

    private Document getNewDoc() throws ParserConfigurationException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        return docBuilder.newDocument();
    }

    private Element getFromApi(Document d, String finder) throws InvalidIdException {
        Element element = d.createElement(finder);

        HealthCareInfoProvider healthCareInfoProvider = new HealthCareInfoProvider();
        PersonInsured p = healthCareInfoProvider.fetchInfo(getIdNum(), getId());
        if(Objects.equals(finder, "JOIN_DATE")){
            element.setTextContent(String.valueOf(p.getJoinDate()));
        } else if (Objects.equals(finder, "HEALTH_CARE_ID")) {
            element.setTextContent(String.valueOf(p.getHealthCareId()));

        } else if(Objects.equals(finder, "HEALTH_CARE_NAME")){
            element.setTextContent(String.valueOf(p.getHealthCareName()));
        }
        return element;
    }

    private Element getXmlElement(Document d, String[] line) {
        Element e = d.createElement("labTest");
        if(line[0].length() == 9){
            setIdNum(Integer.parseInt(line[0]));
        }
        if(line[1].length() == 9){
            setId(Integer.parseInt(line[1]));
        }

        for (int i = 0; i < line.length; i++) {
            Element newTest = d.createElement(FieldsOfStageA.values()[i].getField());
            newTest.setTextContent(line[i]);
            e.appendChild(newTest);
        }
        return e;
    }
}

















