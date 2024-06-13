package datadrivenframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Flib implements PathVariable
{
	public String fetch(String key) throws IOException
	{
		FileInputStream f = new FileInputStream(propertypath);
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key) ;
	}
	
	
	
}
