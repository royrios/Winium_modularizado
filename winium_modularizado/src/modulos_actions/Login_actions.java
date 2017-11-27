package modulos_actions;

import java.util.HashMap;

import org.openqa.selenium.winium.WiniumDriver;

import modulos_components.LogIn_components;

public class Login_actions {

	private LogIn_components elements;
		
		 public Login_actions(WiniumDriver driver) {
			// TODO Auto-generated constructor stub
			this.elements = new LogIn_components(driver);
			 	
			
		}
		
		public void ExecuteLogIn(HashMap<String, Object> rowMap) {
			
			this.elements.TxtUsername().sendKeys(rowMap.get("User").toString());
			this.elements.TxtPassword().sendKeys(rowMap.get("Password").toString());
			this.elements.BtnLogin().click();
			
		}
		
		
		public void ExecuteLogOut() {
			this.elements.BtnLogOut().click();
		}

		

}
