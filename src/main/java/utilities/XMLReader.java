package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;


public class XMLReader {

    public static NodeList commsNode;

    public int readICD(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("C:\\mm\\IEC 61850 Emulator\\example SCL.icd"));
            commsNode = doc.getElementsByTagName("Communication");

            System.out.println(commsNode.item(0));

        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage() );
            return 404;
        }
        return 200;
    }

    public static void createCID(){
        System.out.println("This is where the CID File wil be created from the ICD file");
        System.out.println("There should be a new file output from this.");
    }
}
