package pages.dynamicXpath;

public class DynamicXpath {
    private DynamicXpath(){}

    public static String getXpath(String xpath,String value){
        return xpath.replace("%value%",value);
    }

}
