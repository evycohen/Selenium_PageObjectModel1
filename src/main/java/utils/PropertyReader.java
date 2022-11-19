package utils;

import constants.FrameworkConstants;
import enums.ConfigProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {
    private PropertyReader(){}
    private  final static FileInputStream fis;
    private static Properties pro;
    private static final Map<String,String> CONFIGMAP;

    static {
        try {
            fis=new FileInputStream(FrameworkConstants.getConfigPath());
            pro=new Properties();
            pro.load(fis);
            CONFIGMAP=new HashMap<>();
            for(Object object: pro.keySet()){
                CONFIGMAP.put(String.valueOf(object),String.valueOf(pro.get(object)));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getValue(ConfigProperties key){
        try{
            if(Objects.isNull(key) ||Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
                throw new Exception("Property name: "+key+" Is not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } return CONFIGMAP.get(key.name().toLowerCase());
    }



}
