package constants;

public final class FrameworkConstants {
    private static final int PAGE_LOAD_TIME=15;
    private static final int EXPLICIT_WAIT=10;
    private static final int IMPLICIT_WAIT=10;
    private static final int EXPLICIT_MILLI_SEC_WAIT=150;
    private static final String LOGGER_PATH=System.getProperty("user.dir")+"/src/main/resources/log4j.properties";
    private static final String CONFIG_PATH=System.getProperty("user.dir")+"/src/main/resources/config.properties";
    private static final  String OUTPUT_FILE="outputs/report.html";
    private static final String DATA_PATH=System.getProperty("user.dir")+"/src/main/resources/IteraQA.xlsx";


    public static int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
    public static int getImplicitWait() {
        return IMPLICIT_WAIT;
    }
    public static int getPageLoadTime() {
        return PAGE_LOAD_TIME;
    }

    public static int getExplicitMilliSecWait() {
        return EXPLICIT_MILLI_SEC_WAIT;
    }

    public static String getLoggerPath() {
        return LOGGER_PATH;
    }

    public static String getConfigPath() {
        return CONFIG_PATH;
    }

    public static String getOutputFile() {
        return OUTPUT_FILE;
    }

    public static String getDataPath() {
        return DATA_PATH;
    }
}
