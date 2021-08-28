package utilities;

import Structures.DataAttribute;
import Structures.DataObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.text.AsyncBoxView;
import javax.xml.XMLConstants;
import javax.xml.crypto.Data;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.events.Attribute;
import java.io.File;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;


public class XMLReader {

    public static NodeList commsNode;
    public static NodeList dataSets;
    public static NodeList logicalNodes;
    public String XMLFilePath = "C:\\mm\\IEC 61850 Emulator\\example SCL.icd";

    public int readICD(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{

            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(XMLFilePath));

            commsNode = doc.getElementsByTagName("Communication");
            dataSets = doc.getElementsByTagName("DataSet");
            logicalNodes = doc.getElementsByTagName("LN");

            NodeList lns = logicalNodes;
            for (int i = 0; i < lns.getLength();i++){
                Node node = lns.item(i);
                Element element = (Element) node;

                NodeList children = element.getElementsByTagName("DOI");

                System.out.println(children.getLength());

            }

        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage() );
            return 404;
        }
        return 200;
    }

    public NodeList getLogicalNodes(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try{
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(XMLFilePath));

            logicalNodes = doc.getElementsByTagName("LN");

        }catch(Exception ex){
            System.out.println("Error" + ex.getMessage() );
        }
        return logicalNodes;
    };

    public static HashMap<String,String> returnAttributes(Node node){

        HashMap<String,String> attributes = new HashMap<>();
        for(int i = 0 ; i < node.getAttributes().getLength();i++ ){
            attributes.put(node.getAttributes().item(i).toString().split("=")[0],node.getAttributes().item(i).toString().split("=")[1]);
        }
        System.out.println(attributes.get("prefix"));
        return attributes;
    }

    public static String getAttributeValue(Node node, String attribute){
        String value = "";
        for(int i = 0 ; i < node.getAttributes().getLength();i++ ){
          if(node.getAttributes().item(i).toString().contains(attribute)) {value = node.getAttributes().item(i).toString().split("=")[1];}
        }
        return value;
    }

    public static DataObject[] getDataObjects(Node node) {
        Element element = (Element) node;
        NodeList children = element.getElementsByTagName("DOI");

        DataObject[] objects = new DataObject[children.getLength()];

        for (int i= 0 ; i < children.getLength();i++){
            Element e = (Element) children.item(i) ;
            objects[i] = new DataObject(XMLReader.getAttributeValue(children.item(i),"name"),getDataAttributes(children.item(i)));
        }

        return objects;
    }

    public static DataAttribute[] getDataAttributes(Node node){//this has to be a DataObject node

        Element element = (Element) node;
        NodeList children = element.getElementsByTagName("DAI");
        DataAttribute[] attrs = new DataAttribute[children.getLength()];

        for (int i= 0 ; i < children.getLength() ;i++){
            Element e = (Element) children.item(i);
            attrs[i] = new DataAttribute( XMLReader.getAttributeValue(children.item(i),"name"),"This is a value");
        }

        return attrs;
    }
}
