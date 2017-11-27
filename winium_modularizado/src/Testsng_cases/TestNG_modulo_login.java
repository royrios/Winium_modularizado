package Testsng_cases;

import java.util.HashMap;

import org.openqa.selenium.winium.WiniumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import configuration.Init_winiumDriver;
import configuration.DataProviderClass;
import modulos_actions.Login_actions;

public class TestNG_modulo_login {

	private WiniumDriver driver;
	
	@BeforeClass
	public void SetupEnviroment() {
		Init_winiumDriver setup = new Init_winiumDriver("C:\\Users\\Roy\\Documents\\proyectos visual EXE\\LogIn\\setup.exe");
		this.driver= setup.GetDriver();
	}
	
	@Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
	public void ExecuteTest(HashMap<String, Object> rowMap) {
		
		
		Login_actions objLogIn = new Login_actions(this.driver);
		
		objLogIn.ExecuteLogIn(rowMap);
		objLogIn.ExecuteLogOut();
	}
	
	
	@AfterSuite
	public void CloseTest() {
		driver.close();
	}
	
	
}
