package GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFiles {

	public String toReadDatafromPropFile(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		
	}

}
