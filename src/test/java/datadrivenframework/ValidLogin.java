package datadrivenframework;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ValidLogin extends Browser{

	public static void main(String[] args) throws IOException
	{
		Browser b = new Browser() ;
		Flib f = new Flib() ;
		WebDriver driver = b.webDriverPropertiesFile();
		b.launchBrowser(driver);
		driver.findElement(By.name("username")).sendKeys(f.fetch("username"),Keys.TAB,f.fetch("password"),Keys.ENTER);
	//	b.CloseBrowser(driver);
	}

}
