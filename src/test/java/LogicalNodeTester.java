import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Structures.LogicalNode;
import org.w3c.dom.NodeList;
import utilities.XMLReader;

public class LogicalNodeTester {

    XMLReader xml = new XMLReader();
    static LogicalNode logicalNode;

    @Before
    public void setUp() throws Exception{
        NodeList nodeList = xml.getLogicalNodes();
         logicalNode =
                new LogicalNode(
                        XMLReader.getDataObjects(nodeList.item(0)),
                        XMLReader.getAttributeValue(nodeList.item(0),"lnType"),
                        XMLReader.getAttributeValue(nodeList.item(0),"lnClass"),
                        XMLReader.getAttributeValue(nodeList.item(0),"name"));
    }

    @Test
    public void assertAmountOfDataObjectsInLogicalNode(){
        System.out.println(logicalNode.getDataObjects().length);
        Assert.assertNotNull(logicalNode.getDataObjects().length);
    }

    @Test
    public void assertFirstDataAttributeAmount(){
        System.out.println(logicalNode.getDataObjects()[0].getAttributes().length);
        Assert.assertNotNull(logicalNode.getDataObjects()[0].getAttributes().length);
    }

    @Test
    public void assertThatDataObjectNamesAreRetrievable(){
        System.out.println(logicalNode.getDataObjects()[0].getName());
        Assert.assertNotNull(logicalNode.getDataObjects()[0].getName());
    }

    @Test
    public void assertThatAttributeNamesAreRetrievable(){
        System.out.println(logicalNode.getDataObjects()[0].getAttributes()[0].getName());
        Assert.assertNotNull(logicalNode.getDataObjects()[0].getAttributes()[0].getName());
    }
}
