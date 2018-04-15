package NewTestNG;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Library.Utility;
import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


public class NewRegistrationCompleteScriptWithAssert {

	public WebDriver driver;
	@BeforeTest
	public void openApplication() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chrome driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	  String url = "http://newtours.demoaut.com/";
	 
	    driver.manage().window().maximize();
	    driver.get(url);
	    
	    Utility.captureScreenshot(driver, "page opened");
	}
	@Test(priority=0)
	  public void verifyRegisterLink() {
	  
		String sExpected = "Register: Mercury Tours";
	driver.findElement(By.linkText("REGISTER")).click();
	String actualresult = driver.getTitle();
	org.testng.Assert.assertEquals(actualresult, sExpected);
	  }
	@Test(priority=1)
	public void userRegistraion() throws InterruptedException, IOException
	{
				//Contact Information
				driver.findElement(By.name("firstName")).sendKeys("Moe");
				driver.findElement(By.name("lastName")).sendKeys("Munaz");
				driver.findElement(By.name("phone")).sendKeys("123456789");
				driver.findElement(By.id("userName")).sendKeys("moemunaz@email.com");
				Thread.sleep(2000);
				//Mailing Information
				driver.findElement(By.name("address1")).sendKeys("69 Damy Dr");
				driver.findElement(By.name("address2")).sendKeys("APT#69");
				driver.findElement(By.name("city")).sendKeys("Colombo");
				driver.findElement(By.name("state")).sendKeys("Colombo");
				driver.findElement(By.name("postalCode")).sendKeys("04210");
				 driver.findElement(By.name("country"));
				 Select Country = new Select(driver.findElement(By.name("country")));
			 	  //Country.selectByValue(192);
				 Country.selectByValue("192");
				Thread.sleep(2000);
				//  User Information 
				driver.findElement(By.id("email")).sendKeys("Moe1991");
			    driver.findElement(By.name("password")).sendKeys("123456");
				driver.findElement(By.name("confirmPassword")).sendKeys("123456");
				driver.findElement(By.name("register")).click();
				
			    Utility.captureScreenshot(driver, "register page");
		 
				String expectedresult = "Your user name is Moe1991.";
			 	  String  sActualValue=driver.findElement(By.tagName("Body")).getText();
			 	  org.testng.Assert.assertTrue(sActualValue.contains(expectedresult));
	}
			 	 @Test(priority=2)
			 	public void flightbooking() throws InterruptedException, IOException
			 	{
			 		driver.findElement(By.linkText("Flights")).click();
					driver.findElement(By.name("tripType")).click();
					
					Select pas = new Select(driver.findElement(By.name("passCount")));
				 	  pas.selectByVisibleText("1");
			
				 	  Select city = new Select(driver.findElement(By.name("fromPort")));
				 	  city.selectByVisibleText("New York");
				 	 	
				 	 Select mon = new Select(driver.findElement(By.name("fromMonth")));
				 	  mon.selectByVisibleText("November");
				 	  
				 	 Select day = new Select(driver.findElement(By.name("fromDay")));
				 	  day.selectByVisibleText("10");
				 	  
				 	 Select avvcity = new Select(driver.findElement(By.name("toPort")));
				 	  avvcity.selectByVisibleText("London");
				 	  
				 	 Select remon = new Select(driver.findElement(By.name("toMonth")));
				 	  remon.selectByVisibleText("November");
				 	  
				 	 Select reday = new Select(driver.findElement(By.name("toDay")));
				 	  reday.selectByVisibleText("15");
				 	  
				 	 driver.findElement(By.name("servClass")).click();
				 	 
				 	Select air = new Select(driver.findElement(By.name("airline")));
				 	  air.selectByVisibleText("Unified Airlines");
				 	
				 	  driver.findElement(By.name("findFlights")).click();
				 	  
				 	    Utility.captureScreenshot(driver, "flight page");
				 	  
				 	 String expectedresult = "SELECT FLIGHT";
				 	  String  sActualValue=driver.findElement(By.tagName("Body")).getText();
				 	  org.testng.Assert.assertTrue(sActualValue.contains(expectedresult));
			 	}
			 	 @Test(priority=3)
				 	public void selectflight() throws InterruptedException
				 	{
	 	 	
			 	 driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[7]/td[1]/input")).click();
			 	 driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")).click();
				driver.findElement(By.name("reserveFlights")).click();
				 	
				String sExpected = "Book a Flight: Mercury Tours";
				String actualresult = driver.getTitle();
				org.testng.Assert.assertEquals(actualresult, sExpected);
				 	}
			 	 @Test(priority=4)
						 	public void BookFlight() throws InterruptedException, IOException
						 	{
			 	
					 		driver.findElement(By.name("passFirst0")).sendKeys("Moe");
						 	driver.findElement(By.name("passLast0")).sendKeys("Munas");
						 	Select meal = new Select(driver.findElement(By.name("pass.0.meal")));
						 	  meal.selectByVisibleText("Muslim");
						 	  
						 	 Select card = new Select(driver.findElement(By.name("creditCard")));
						 	  card.selectByVisibleText("Visa");
						 	 driver.findElement(By.name("creditnumber")).sendKeys("1234567897897");
						 	  
						 	 Select exp = new Select(driver.findElement(By.name("cc_exp_dt_mn")));
						 	  exp.selectByVisibleText("10");
							 	 Select exp1 = new Select(driver.findElement(By.name("cc_exp_dt_yr")));
							 	  exp1.selectByVisibleText("2010");
							 	  
							 	 driver.findElement(By.name("cc_frst_name")).sendKeys("Moe");
								 driver.findElement(By.name("cc_mid_name")).sendKeys("Munazer");
								 driver.findElement(By.name("cc_last_name")).sendKeys("Munas");
								 driver.findElement(By.name("buyFlights")).click();
								 
								    Utility.captureScreenshot(driver, "successfully regitered");
						 	
							String expectedresult = "Your itinerary has been booked!";
							 String  sActualValue=driver.findElement(By.tagName("Body")).getText();
							 org.testng.Assert.assertTrue(sActualValue.contains(expectedresult));
							 {
							 }
							 }

								 
								 @AfterMethod
								 public void tearDown(ITestResult result)
								 {
								  
								 // Here will compare if test is failing then only it will enter into if condition
								 if(ITestResult.FAILURE==result.getStatus())
								 {
								 try 
								 {
								 // Create refernce of TakesScreenshot
								 TakesScreenshot ts=(TakesScreenshot)driver;
								  
								 // Call method to capture screenshot
								 File source=ts.getScreenshotAs(OutputType.FILE);
								  
								 // Copy files to specific location here it will save all screenshot in our project home directory and
								 // result.getName() will return name of test case so that screenshot name will be same
								 FileUtils.copyFile(source, new File("./FailScreenshots/"+result.getName()+".png"));
								  
								 System.out.println("Screenshot taken");
								 } 
								 catch (Exception e)
								 {
								  
								 System.out.println("Exception while taking screenshot "+e.getMessage());
								 } 
								  
								  
								  
								 }
									 	
						 	
						 	}



				
			}