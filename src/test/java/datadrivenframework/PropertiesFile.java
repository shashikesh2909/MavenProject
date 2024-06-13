package datadrivenframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/PropertyDataFile/PropertiesFileData.properties");
		Properties p = new Properties();
		p.load(fis);
		System.out.println(p.getProperty("url"));
	}

}
