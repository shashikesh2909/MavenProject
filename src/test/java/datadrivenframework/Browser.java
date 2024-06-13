package datadrivenframework;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser extends Flib
{
	public WebDriver driver ; 
	Properties p = new Properties() ;
	

	public WebDriver webDriverPropertiesFile() throws IOException
	{
		
		String b = fetch("browser");
		if(b.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(b.equalsIgnoreCase("firefox"))
		{
			 driver = new FirefoxDriver();
		}
		else if(b.equalsIgnoreCase("edge"))
		{
			 driver = new EdgeDriver();
		}
		else
		{
			System.out.println("invlaid browser");
		}
		
		return driver ;
	}

public void launchBrowser(WebDriver driver) throws IOException
{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(fetch("url"));
}

public void CloseBrowser(WebDriver driver) throws IOException
{
	driver.close();
}
	
}
