package Load.LoaderType;

import Load.AbstractClass.Loader;
import Parse.ParserType.ParseToXml;
import health_care_provider.errors.InvalidIdException;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.Stack;


public class XmlLoader extends Loader {

    //cTor
    public XmlLoader(String path, String target)
            throws IOException, ParserConfigurationException, TransformerException, InvalidIdException {
        setPath(path);
        setTarget(target);
        LoadToDir();
    }


    @Override
    public void LoadToDir() throws IOException, ParserConfigurationException, TransformerException, InvalidIdException {
        int index = 0;
        Stack<Document> newDoc = new ParseToXml(getPath()).getDocStack();

        for (Document d : newDoc) {
            FileOutputStream output = new FileOutputStream(createTarget(index));
            writeXml(d, output);
            index++;
        }
    }

    private String createTarget(int index){
        String fileName = "test_";
        return getTarget() + fileName + index + ".xml";
    }

    private static void writeXml(Document doc, OutputStream output) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();

        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);

        transformer.transform(source, result);
    }
}
