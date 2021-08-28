package structures;

public class DataObject {

    private String name = "";
    private DataAttribute[] attributes;

    public DataObject(String name,DataAttribute[] da){
        this.name = name;
        this.attributes = da;
    }

    public String getName(){
        return name;
    }

    public DataAttribute[] getAttributes(){
        return attributes;
    }
}
