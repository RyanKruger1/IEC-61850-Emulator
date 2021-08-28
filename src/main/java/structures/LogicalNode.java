package structures;

public class LogicalNode {

    private String lnName = "" ;
    private String lnClass ="" ;
    private String lnType = "" ;
    private DataObject[] dataObjects ;

    public LogicalNode( DataObject[] dataObject,String type, String lnClass,  String name){
        super();
        this.lnName = name;
        this.lnClass =lnClass;
        this.lnType = type ;
        this.dataObjects = dataObject;
     }

    public String getLnClass(){
        return lnClass;
    }

    public String getLnType(){
        return lnType;
    }

    public String getLnName(){
        return lnName;
    }

    public DataObject[] getDataObjects(){
        return dataObjects;
    }
}
