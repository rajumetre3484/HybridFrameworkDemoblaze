package com.genericlib.demoblaze;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class EventList  implements ITestListener 
{

	//Taking the screenshot
	public void onTestFailure(ITestResult result)
	{	
		File src = ((TakesScreenshot)(Base.driver)).getScreenshotAs(OutputType.FILE);//to take sc
		File dest=new File("/Screenshots/"+System.currentTimeMillis()+".png");//+System.currentTimeMillis()+".png"--To save the sc everytime with different name system time with sc name
		String path = dest.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dest);
		    } 
		catch (IOException e) 
		  {
			
			e.printStackTrace();
			
		  }
		Base.test.fail("Test Script failed "+result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
	}
	
}
