import structures.DataAttribute;
import structures.DataObject;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import utilities.XMLReader;

public class XMLTester {

    public static XMLReader xml = new XMLReader();

    @Test
    public void uploadFile(){
        Assert.assertEquals(xml.readICD(), 200);
    }

    @Test()
    public void readAttribute(){
        Assert.assertEquals(xml.readICD(), 200);
    }

    @Test
    public void getLogicalNodes(){
        Assert.assertEquals(11,xml.getLogicalNodes().getLength());
    }

    @Test
    public void getDataObject(){
        NodeList lns = xml.getLogicalNodes();
        Element el = (Element) lns.item(0);
        DataObject object1 =  XMLReader.getDataObjects(el)[0];
        DataAttribute[] attr = object1.getAttributes();
        Assert.assertEquals(2,attr.length);
    }
}
