package api.utils;

        import api.utils.listeners.Setup;
        import com.aventstack.extentreports.markuputils.ExtentColor;
        import com.aventstack.extentreports.markuputils.MarkupHelper;
        import com.aventstack.extentreports.reporter.ExtentSparkReporter;
        import com.aventstack.extentreports.reporter.configuration.Theme;
        import com.aventstack.extentreports.ExtentReports;
        import java.time.format.DateTimeFormatter;
        import java.time.LocalDateTime;
public class ExtentReportManager {
    public static ExtentReports extentReports;
    public static ExtentReports createInstance(String fileName,String reportName,String documentTitle){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(fileName);
        extentSparkReporter.config().setReportName(reportName);
        extentSparkReporter.config().setDocumentTitle(documentTitle);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("utf-8");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }
    public static String getReportNameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String formattedTime = now.format(dateTimeFormatter);
        String reportName = "TestReport"+formattedTime+".html";
        return reportName;
    }

    public static void logPassDetails(String log){
        Setup.extentTestThreadLocal.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }
    public static void logFailDetails(String log){
        Setup.extentTestThreadLocal.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }
    public static void logInfoDetails(String log){
        Setup.extentTestThreadLocal.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }
    public static void logWarningDetails(String log){
        Setup.extentTestThreadLocal.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }
}