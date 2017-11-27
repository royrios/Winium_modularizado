package modulos_components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.WiniumDriver;

public class LogIn_components {
	
private static WebElement txt_username;
private static WebElement txt_password;
private static WebElement btn_Login;
private static WebElement btn_LogOut;
private static WiniumDriver driver;



public LogIn_components(WiniumDriver driver) {
	
	LogIn_components.driver = driver;
	
}

public WebElement TxtUsername() {
	
	return LogIn_components.txt_username = driver.findElementById("username");
}

public WebElement TxtPassword() {
	
	return LogIn_components.txt_password = driver.findElementById("passwordBox");
}

public WebElement BtnLogin() {
	
	return LogIn_components.btn_Login = driver.findElementById("login");
}

public WebElement BtnLogOut() {
	
	return LogIn_components.btn_Login = driver.findElementById("exit");
}

}
