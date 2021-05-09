package cowin;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkSchedule {

	public static String pinCode="445205";
	public static String[] pin;

	public static void main(String[] args) throws InterruptedException, FileNotFoundException {

		
		for(; ;) {
			System.out.println("here=========||||||||||||||||============");
		Thread.sleep(5000);
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cowin.gov.in/home");
		
		
	
        // fetch todays data		
		String filename = "D:\\cowin.txt";
		BufferedReader reader = new BufferedReader(new FileReader(filename));

				try{
				  String line;
				  //as long as there are lines in the file, print them
				  while((line = reader.readLine()) != null){ 
				    System.out.println(line);
				   pin=line.split(",");
				    int dd = pin.length;
				    System.out.println("Total rows "+ dd);
				    for(int row=0; row<pin.length; row++)
				    {
				    	
				    	pinCode = pin[row];
				    	//System.out.println(pinCode+"   dfdsfsdfsf");
				    }
				  }
				} catch (IOException e) {
				  e.printStackTrace();
				}
				    	
				  
				    	
		
		
			for(int row = 0; row<pin.length; row++) {
				//System.out.println(pin[row] + "mahesssssssss");
				
				pinCode= pin[row];
				System.out.println("this pinc code... "+pinCode);
				driver.findElement(By.xpath("//input[@id='mat-input-0']")).clear();
				driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys(pinCode);
				driver.findElement(By.xpath("//button[contains(text(),'Search')]")).click();
				Thread.sleep(3000);
						
			for(int i=1; i<10; i++) {	
			
			
				
				try {
					//System.out.println(pinCode + "current pin");
					// code to get center name and address
					String centerNameBeforExpath = "/html[1]/body[1]/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]"
							+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]"
							+ "/div[1]/div[1]/div[1]/div[";

					String centerNameAfterExpath = "]/div[1]/div[1]/div[1]/div[1]/h5[1]";
					String centerAddressAfterExpath = "]/div[1]/div[1]/div[1]/div[1]/p[1]";		
					String centerName = driver.findElement(By.xpath(centerNameBeforExpath+i+centerNameAfterExpath)).getText();
					String centerAddress = driver.findElement(By.xpath(centerNameBeforExpath+i+centerAddressAfterExpath)).getText();
					System.out.println(centerName);
					System.out.println(centerAddress);
					
					// code to read the slot status booked/available

					String statusBeforeXpath = "//body/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]/div[1]/div[1]/div[1]"
							+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[";
					String statusAfterXpath = "]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/a[1]";

					String status = driver.findElement(By.xpath(statusBeforeXpath+i+statusAfterXpath)).getText();
					System.out.println(status);

					// code to read the age criteria

					String ageBeforeXpath = "//body/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]/div[1]/div[1]/div[1]/"
							+ "div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[";
					String ageAfterXpath = "]/div[1]/div[1]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[2]/span[1]";

					String age = driver.findElement(By.xpath(ageBeforeXpath+i+ageAfterXpath)).getText();
					System.out.println(age);
					
					// code to get date
					String todayDate = "//body/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]/div[1]/div[1]/div[1]/div[1]"
							+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[1]/ul[1]/carousel[1]"
							+ "/div[1]/div[1]/slide[1]/div[1]/li[1]/a[1]/p[1]";
										
					String today = driver.findElement(By.xpath(todayDate)).getText();
					System.out.println(today);

				//	System.out.println("hiii do you stuff here... "+ i);
					if(status!= "Booked" && status != "NA") {
						System.out.println("slot available");
					}
					System.out.println("==================== "+ i +" =======================");
					
					}
					catch(Exception e) {}		
		}

			System.out.println("==================== XXXXXXXXXXXXXXXXXXXx  =======================");

        // fetch tomorrows data
		
		for(int i=1; i<10; i++) {			
				
				try {

					
					//System.out.println(pinCode + "current pin");
					// code to get center name and address
					String centerNameBeforExpath = "/html[1]/body[1]/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]"
							+ "/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]"
							+ "/div[1]/div[1]/div[1]/div[";

					String centerNameAfterExpath = "]/div[1]/div[1]/div[1]/div[1]/h5[1]";
					String centerAddressAfterExpath = "]/div[1]/div[1]/div[1]/div[1]/p[1]";		
					String centerName = driver.findElement(By.xpath(centerNameBeforExpath+i+centerNameAfterExpath)).getText();
					String centerAddress = driver.findElement(By.xpath(centerNameBeforExpath+i+centerAddressAfterExpath)).getText();
					System.out.println(centerName);
					System.out.println(centerAddress);
					
					// code to read the slot status booked/available

					String statusBeforeXpath = "//body/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[";
					String statusAfterXpath = "]/div[1]/div[1]/a[1]";

					String status = driver.findElement(By.xpath(statusBeforeXpath+i+statusAfterXpath)).getText();
					System.out.println(status);

					// code to read the age criteria

					String ageBeforeXpath = "//body/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[";
					String ageAfterXpath = "]/div[1]/div[1]/div[2]/span[1]";

					String age = driver.findElement(By.xpath(ageBeforeXpath+i+ageAfterXpath)).getText();
					System.out.println(age);
					
					// code to get date
					String tomorrowDate = "//body/app-root[1]/div[1]/app-home[1]/div[2]/div[1]/appointment-table[1]/div[1]/div[1]/div[1]/div"
							+ "[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[6]/div[1]/div[1]/ul[1]/carouse"
							+ "l[1]/div[1]/div[1]/slide[2]/div[1]/li[1]/a[1]/p[1]";
					
					String tomorrow = driver.findElement(By.xpath(tomorrowDate)).getText();
					System.out.println(tomorrow);

					//System.out.println("hiii do you stuff here... "+ i);
					if(status!= "Booked" && status != "NA") {
						System.out.println("slot available");
					}
					System.out.println("==================== "+ i +" =======================");
					
					}
					catch(Exception e) {}		
		}

// first loop ending
				   
			}
			driver.close();


		}
	}

}
