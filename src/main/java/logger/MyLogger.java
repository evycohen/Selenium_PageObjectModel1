package logger;

import constants.FrameworkConstants;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
    private MyLogger(){}

    private static boolean root=false;

    public static Logger getLogger(Class cls){
        if(!root){
            PropertyConfigurator.configure(FrameworkConstants.getLoggerPath());
            root=true;
        }return Logger.getLogger(cls);
    }
    public static void info(Class cls,String info){
        getLogger(cls
        ).info(info);
    }
    public static void error(Class cls,String error){
        getLogger(cls).error(error);
    }
    public static void startTestCase(Class cls,String methodName){
        getLogger(cls).info("\n\n*******************************  Starting "+methodName+"*************************************\n");
    }
    public static void endTestCase(Class cls,String methodName){
        getLogger(cls).info("\n********************************* End "+methodName+"*************************************************\n\n");
    }

}
