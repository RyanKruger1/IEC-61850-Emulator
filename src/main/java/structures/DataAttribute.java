package structures;

public class DataAttribute {

    private String name="";
    private String value="";

    public DataAttribute(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName(){
        return name;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }
}
