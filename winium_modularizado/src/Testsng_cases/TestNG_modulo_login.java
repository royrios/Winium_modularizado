package Testsng_cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.apache.xalan.xsltc.compiler.sym;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import configuration.Init_winiumDriver;
import configuration.DataProviderClass;
import modulos_actions.Login_actions;

public class TestNG_modulo_login {

	public static ExtentReports reports;
	public static ExtentTest logger;
	private WiniumDriver driver;
	long id;
	
	
	
	
	
	@BeforeClass
	public void SetupEnviroment() {
		
		/*Clase Init_winiumDriver  ejecuta winiumDriver(intermediaro entre TestNg y aplicacion a automatizar)
		tambien solicita URL de  la aplicación que se va a automatizar*/
		Init_winiumDriver setup = new Init_winiumDriver("C:\\Users\\Roy\\Documents\\proyectos visual EXE\\LogIn\\setup.exe");
		this.driver= setup.GetDriver();
		
		id = Thread.currentThread().getId();
		 System.out.println(id);
	}
	
	
	@BeforeTest
	public void ConfigReport() throws IOException{
		reports = new ExtentReports("C:\\Extentreports\\ExtentReportF_" + id + ".html", true);
		reports.addSystemInfo("Host Name", "Lisyx").addSystemInfo("Environment", "Login ejemplo")
				.addSystemInfo("User Name", "Lisyx");
		reports.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}
	
	
	@Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	public void ExecuteTest(HashMap<String, Object> rowMap) throws IOException, InterruptedException, AWTException   {
		
		logger=reports.startTest("Ejemplo login " + id + "");
		
		//Login_actions contiene las acciones que se pueden ejecutar el el modulo LogIn
		
		
		Login_actions objLogIn = new Login_actions(this.driver,logger);
			
			
			objLogIn.ExecuteLogIn(rowMap);
			objLogIn.ExecuteLogOut();
			
			
			
						
		
	}
	
	
	@AfterTest
	public void CloseTest() throws IOException {
		//driver.close();
		System.out.println(reports.toString());
		reports.endTest(logger);
		reports.flush();
	}
	
	
}
