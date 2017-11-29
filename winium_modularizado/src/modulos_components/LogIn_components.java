package modulos_components;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class LogIn_components {

	private static WebElement txt_username;
	private static WebElement txt_password;
	private static WebElement btn_Login;
	private static WebElement btn_LogOut;
	private static WiniumDriver driver;
	private static ExtentTest logger;
	private Robot robot;

	public LogIn_components(WiniumDriver driver, ExtentTest logger) {

		LogIn_components.driver = driver;
		LogIn_components.logger = logger;
		
		
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

	public WebElement TxtUsername() {
		
		try {
			txt_username = driver.findElementById("username");
			logger.log(LogStatus.PASS, "TxtUsername: Exito al utilizar el componente  ");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "TxtUsername: Fallo al intentar utilizar el  componente  ");
		}
		return txt_username;
	}

	
	public WebElement TxtPassword() {
		try {
			txt_password = driver.findElementById("passwordBox");
			logger.log(LogStatus.PASS, "TxtPassword: Exito al utilizar el componente  ");
		} catch (Exception e) {
			logger.log(LogStatus.FAIL, "TxtPassword: Fallo al intentar utilizar el  componente  ");
		}
		return txt_password ;
		
	}

	public WebElement BtnLogin() {

		try {
			
			btn_Login = driver.findElementById("login");
			logger.log(LogStatus.PASS, "BtnLogin: Exito al utilizar el componente  ");
		} catch (Exception e) {
			robot.keyPress(KeyEvent.VK_ESCAPE);
			logger.log(LogStatus.FAIL, "BtnLogin: Fallo al intentar utilizar el  componente  ");
			
		}
		return btn_Login;
	}

	
	public WebElement BtnLogOut() {
		try {
			btn_LogOut= driver.findElementById("exit");
			logger.log(LogStatus.PASS, "BtnExit: Exito al utilizar el componente  ");
		} catch (Exception e) {
			robot.keyPress(KeyEvent.VK_ESCAPE);
			logger.log(LogStatus.FAIL, "BtnExit: Fallo al intentar utilizar el  componente  ");
		}
		return btn_LogOut;

	}

}
