package com.ardublock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

import processing.app.Preferences;

public class Configuration
{
	private Context context;
	private File configFile;
	public Configuration(Context context)
	{
		this.context = context;
		File configPath = loadConfigFile();
		configFile = new File(configPath.getAbsolutePath(), "ardublock.properties");
		if (!configFile.isFile())
	    {
			try
			{
				configFile.createNewFile();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
	    }
		
	}
	
	private File loadConfigFile()
	{
		if (context.isInArduino())
		{
                    JOptionPane.showMessageDialog(null,"sketchbook.path ------ ");
			return new File(Preferences.get("sketchbook.path"));
		}
		else
		{
                   // JOptionPane.showMessageDialog(null,"------ hamad.path ------ ");
			return new File("F:\\Degree Project\\Java Lib\\AkhreeOqaat\\ardublock-master\\src\\main\\resources\\com\\ardublock\\block");
		}
	}
	
	public String getValue(String key, String defaultValue)
	{
		try
		{
			Properties props = new Properties();
			FileReader reader = new FileReader(configFile);
			// load the properties file:
			props.load(reader);
			String value = props.getProperty(key, defaultValue);
			reader.close();
			return value;
		}
		catch (IOException e)
		{
			return null;
		}
	}
	
	public void setValue(String key, String value)
	{
		try
		{
			Properties props = new Properties();
			FileWriter writer = new FileWriter(configFile);
			// load the properties file:
			props.setProperty(key, value);
			props.store(writer, null);
			writer.close();
		}
		catch (IOException e)
		{
		}
	}

}
