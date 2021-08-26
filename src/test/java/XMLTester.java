import org.junit.Assert;
import org.junit.Test;
import utilities.XMLReader;

public class XMLTester {

    public static XMLReader xml = new XMLReader();

    @Test()
    public void uploadFile(){
        Assert.assertEquals(xml.readICD(), 200);
    }
}
