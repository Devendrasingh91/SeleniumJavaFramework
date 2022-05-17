package listeners;

import com.BaseClasses.Keywords;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import tech.grasshopper.reporter.ExtentPDFReporter;


public class ExtentManager extends Keywords {

	private static ExtentReports extent;
	
	
	

	    public static ExtentReports createInstance(String fileName) {
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
	       
	        ExtentPDFReporter pdf=new ExtentPDFReporter(fileName);
	        
	        htmlReporter.config().setTheme(Theme.STANDARD);
	        htmlReporter.config().setDocumentTitle(fileName);
	        htmlReporter.config().setEncoding("utf-8");
	        htmlReporter.config().setReportName(fileName);
	        
	        extent = new ExtentReports();
	        extent.attachReporter(htmlReporter);
	        extent.attachReporter(pdf);
	        
//	        try {
//				pdf.loadJSONConfig(new File(""));
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	        extent.setSystemInfo("Automation Tester", "Devendra Singh");
	        extent.setSystemInfo("Organization", "DAI");
	        extent.setSystemInfo("Build no", "DAI-1234");
	        
	        
	        return extent;
	    }

	 



	}
