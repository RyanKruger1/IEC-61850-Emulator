package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;


public class XMLReader {

    public static NodeList commsNode;
    public static NodeList dataSets;
    public static NodeList logicalNodes;

    public int readICD(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File("C:\\mm\\IEC 61850 Emulator\\example SCL.icd"));

            commsNode = doc.getElementsByTagName("Communication");
            dataSets = doc.getElementsByTagName("DataSet");
            logicalNodes = doc.getElementsByTagName("LN");

            returnAttributes(logicalNodes.item(1));

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

    public static HashMap<String,String> returnAttributes(Node node){

        HashMap<String,String> attributes = new HashMap<>();
        for(int i = 0 ; i < node.getAttributes().getLength();i++ ){
            attributes.put(node.getAttributes().item(i).toString().split("=")[0],node.getAttributes().item(i).toString().split("=")[1]);
        }
        System.out.println(attributes.get("prefix"));
        return attributes;

    }
}
