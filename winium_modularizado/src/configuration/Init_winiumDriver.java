package configuration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Init_winiumDriver {
	
	private DesktopOptions options;
	private WiniumDriver driver;

	public Init_winiumDriver( String appURL) {
		
		this.options = new DesktopOptions();
		this.options.setApplicationPath(appURL);
		
		
	}
	
	
	
	public WiniumDriver GetDriver()  {
		
		try {
			
			executeWiniumDriver();
			Thread.sleep(500);
			this.driver = new WiniumDriver(new URL("http://localhost:9999"),this.options);
		}catch(MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.driver;
		
	}
	
	private void executeWiniumDriver() throws IOException {
		Runtime obj = Runtime.getRuntime(); 
		  obj.exec(".\\Winium_Driver\\Winium.Desktop.Driver.exe"); 
	}
	
	
}
