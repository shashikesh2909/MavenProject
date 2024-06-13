package testNgWorking;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import javax.management.loading.PrivateClassLoader;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class DemoWebShop 
{
	
	public static String fetchExcel(int row , int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyDataFile/Excel.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		return book.getSheet("Sheet1").getRow(row).getCell(cell).getStringCellValue();
	}
	
	static WebDriver driver ;
	
	
	public static void launchBrowser(String browser) throws EncryptedDocumentException, IOException
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver() ;
			driver.get(fetchExcel(1,1));	
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		else if (browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver() ;
			driver.get(fetchExcel(1,1));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		}
		
		else if (browser.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver() ;
			driver.get(fetchExcel(1,1));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		}
		else 
		{
			System.out.println("Invalid");
		}
	}
	
	@Test(priority = 1)
	public static void register () throws EncryptedDocumentException, IOException
	{
		launchBrowser(fetchExcel(0,1));
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("Mandeep",Keys.TAB,"Singh",Keys.TAB,"mandeep@gmail.com",Keys.TAB,"123456",Keys.TAB,"123456",Keys.TAB,Keys.ENTER);
	}
	
	@Test(priority = 2)
	public static void login () throws EncryptedDocumentException, IOException
	{
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		WebElement we = driver.findElement(By.xpath("//input[@name='Email']"));
		we.sendKeys("mandeep@gmail.com",Keys.TAB,"123456",Keys.TAB,	Keys.TAB,Keys.TAB,Keys.ENTER);
	}
	
	@Test(priority = 3)
	public static void AddTOCart () throws EncryptedDocumentException, IOException
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Laptop",Keys.ENTER);
		WebElement we = driver.findElement(By.xpath("//input[@value='Add to cart']"));
		we.click();
	}
	
	
	

	
	
}
