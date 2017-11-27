package modulos_actions;

import java.util.HashMap;

import org.openqa.selenium.winium.WiniumDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import modulos_components.LogIn_components;

public class Login_actions {

	private LogIn_components elements;
	private ExtentTest logger;
		
		 public Login_actions(WiniumDriver driver, ExtentTest logger) {
			// Iniciamos la clase que contiene los componentes de este modulo
			// y al mismo tiempo se añade el Winium Driver a la clase para la manipulación de dichos componentes 
			this.elements = new LogIn_components(driver);
			
			this.logger = logger;
			
		}
		
		public void ExecuteLogIn(HashMap<String, Object> rowMap) {
			
			try {
				this.elements.TxtUsername().sendKeys(rowMap.get("User").toString());
				this.elements.TxtPassword().sendKeys(rowMap.get("Password").toString());
				this.elements.BtnLogin().click();
				
				this.logger.log(LogStatus.PASS, "Test Case (Lanzar Navegador) se realizo correctamente");
			}catch (Exception e) {
				// TODO: handle exception
				logger.log(LogStatus.PASS, "Test Case (Lanzar Navegador) fallo");
			}
			
			
		}
		
		
		public void ExecuteLogOut() {
			this.elements.BtnLogOut().click();
		}

		

}
