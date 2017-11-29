package modulos_actions;


import java.util.HashMap;

import org.openqa.selenium.winium.WiniumDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import modulos_components.LogIn_components;

public class Login_actions {

	private static  LogIn_components elements;
	private static  ExtentTest logger;
	
	
		
		 public Login_actions(WiniumDriver driver, ExtentTest logger) {
			// Iniciamos la clase que contiene los componentes de este modulo
			// y al mismo tiempo se añade el Winium Driver a la clase para la manipulación de dichos componentes 
			elements = new LogIn_components(driver,logger);
			
			Login_actions.logger = logger;
			
		}
		
		public  void ExecuteLogIn(HashMap<String, Object> rowMap)     {
			
				elements.TxtUsername().sendKeys(rowMap.get("User").toString());
				elements.TxtPassword().sendKeys(rowMap.get("Password").toString());
				elements.BtnLogin().click();
				logger.log(LogStatus.PASS, "Test Case (Login) Entro");
			
			
		}
		
		
		public void ExecuteLogOut()  {
			
			
			elements.BtnLogOut().click();
			logger.log(LogStatus.PASS, "Test Case (Salir) Completado");
		
		}

		

}
