package infrastructure.data_readers;

import infrastructure.BaseTest;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DataReader {

    private static final String configFilePath = "./src/main/resources/dataConfig.xml";

    public static String getData (String nodeName)  {

        File fXmlFile = new File(configFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = createDocumentBuilder(dbFactory);
        Document doc = parseXmlFile(dBuilder,fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    private static DocumentBuilder createDocumentBuilder(DocumentBuilderFactory dbFactory) {
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            BaseTest.logger.error("failed to create document builder " + e);
        }
        return dBuilder;
    }

    private static Document parseXmlFile(DocumentBuilder dBuilder, File fXmlFile) {
        Document doc = null;
        try {
            doc = dBuilder.parse(fXmlFile);
        } catch (SAXException e) {
            BaseTest.logger.error("failed to parse xml config file" + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }
}
