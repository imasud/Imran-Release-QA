import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class FPT_OAT_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String EID_Value = " ";
		//String EID_Value = " ";
		String EID_Text = " ";
		
		// Set which Browsers to use
		String whichBrowser = "Firefox";
		   //String whichBrowser = "Chrome";
				
					
		// Environment 1 = QA and 2 = Production
			String whichEnvironment = "1"; 
		
		
		
		String expectedTitle = "OAT Practice Test";
		String sec1Title = "SECTION 1 - BIOLOGY";
		String sec2Title = "SECTION 2 - GENERAL CHEMISTRY";
		String sec3Title = "SECTION 3 - ORGANIC CHEMISTRY";
	//	String sec4Title = "SECTION 4 - PERCEPTUAL ABILITY TEST";
		String sec4Title = "SECTION 4 - READING COMPREHENSION";
		String sec5Title = "SECTION 5 - PHYSICS";
		String sec6Title = "SECTION 6 - QUANTITATIVE REASONING"; 
		
		String enterKeywordTitle = "ENTER KEYWORD";
		
		String scoreTitle = "SCORE TEST";
		String scoresTitle = "SCORES";
		
		String perceptualAbilityScore = "Perceptual Ability : 30";
		String academicAverageScore = "Academic Average : 29";
		
		
		
		String startingQID = "1";
		String sec1StartQID = "1";
		String sec2StartQID = "41";
		String sec3StartQID = "71";
	//	String sec4StartQID = "1"
						
		int [] secOne =   {3,5,4,3,4,4,2,2,4,2,1,2,3,1,2,2,1,1,4,4,1,1,5,3,4,1,1,3,2,2,4,3,1,4,3,4,2,2,1,4};
		int [] secTwo =   {5,2,4,3,1,3,4,4,4,3,5,1,1,4,4,2,5,3,5,1,3,2,2,5,3,3,4,1,5,2};
		int [] secThree = {1,1,4,1,5,2,1,4,1,4,1,1,5,4,5,5,1,1,3,3,2,3,2,1,2,2,4,3,3,1};
		int [] secFour =  {1,5,3,1,2,2,1,3,3,1,4,1,4,2,3,2,4,1,5,3,5,4,4,4,1,1,3,2,2,4,2,1,3,2};
		int [] secFive =  {4,2,5,1,2,3,2,1,5,4,2,2,1,3,5,3,4,2,5,4};
		int [] secSix =   {4,3,2,5,4,1,5,1,1,2,4,5,3,3,2,5,2,1,4,4};
		
		
		// Web Drivers ==================================================================================
		   
			WebDriver dr;
	    
			if (whichBrowser.equals("Firefox")) {
				dr = new FirefoxDriver();
			}
			else { 
				System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver.exe");
				dr = new ChromeDriver();
			}	
	    
	
		// FPT Production and QA URL's =================================================================   
			if (whichEnvironment.equals("1")) { 
				dr.get("http://qwjasweb02.kaplaninc.com/npt.htm");
			}   		  
			else {
				dr.get("http://jasper.kaptest.com/npt.htm");
			}
	
		
		  
		// Enter Enrollment ID or without Enrollment ID Page =======================================================================
		// Test without EID
			if (EID_Value.equals(" "))  {
							
				// click on Select Don't Know My Enrollment ID button
				dr.findElement(By.xpath("//*[@id='nptRegForm']/form/fieldset/ul/li[4]/a")).click();

				//entering first name
				dr.findElement(By.xpath("//*[@id='nptEnroll']/form/fieldset/ul/li[1]/input")).sendKeys("imran");
				dr.findElement(By.name("lastName")).sendKeys("masud");
				dr.findElement(By.xpath("//*[@id='nptEnroll']/form/fieldset/ul/li[3]/input")).clear();
				dr.findElement(By.xpath("//*[@id='nptEnroll']/form/fieldset/ul/li[3]/input")).sendKeys("im@kaptest.com");
				dr.findElement(By.xpath("//*[@id='productListDropDown']")).sendKeys("OAT Practice Test");
		
				dr.findElement(By.xpath("//*[@id='nptEnroll']/form/fieldset/ul/li[6]/a[2]")).click();
			}
			else {
				// Test with EID
				dr.findElement(By.xpath("//*[@id='nptRegForm']/form/fieldset/ul/li[1]/input")).sendKeys( EID_Value );
				EID_Text = " with EID " + EID_Value;
				
				// Click on the Enter button
				System.out.println( EID_Text );
				dr.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
				dr.findElement(By.xpath("//*[@id='nptRegForm']/form/fieldset/ul/li[3]/a")).click();
			}
			
			
		try {
			Thread.sleep(3500L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dr.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		
		//Check for "DAT Practice Test"
		if (dr.getTitle().equals(expectedTitle))	{
			System.out.println("Running NPT " + expectedTitle + EID_Text);
		}
		else{
			System.out.println("Wrong Page");

		}
		
		
	// Check Section 1 - Biology =================================================================
	// Get Section 1 Title   
	    String a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
		  // System.out.println(a);
		 		  
		if  (a.equals (sec1Title))     {
			System.out.println("On " + sec1Title);
		}
		else {
			System.out.println("    *** Section 1 has wrong title " + "'" + a + "'" );
		}
		
		
		// Finding starting QID
			dr.switchTo().activeElement();
		    String b = dr.findElement(By.xpath("//*[@id='grid1']/table/tbody/tr[1]/td[1]/span")).getText();
				
			if (b.equals(startingQID))  {
			   System.out.println("    - Starting QID = " + b + " is correct"); 
			}
			else {  
			   System.out.println("    *** incorrect Starting QID = " + b + " should be " + startingQID);
			}
					
			// Fill in the Section 1 Bubble		
				for (int x = 0; x < 40; x=x+1)  { 
					dr.findElement(By.xpath("//*[@id='grid1']/table/tbody/tr[" + (x+1) + "]/td[2]/fieldset/p[" + secOne[x]  + " ]/label/span")).click();
				}
				System.out.println("    - Bubble has been filled in." );		
		

      
	// Check Section 2 - General Chemistry ==============================================================================			
	// Click Next button for Section 2
		dr.findElement(By.xpath("//*[@id='navigation-next']"  )).click();
		a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
		
		System.out.println(" ");
		  
			if  (a.equals (sec2Title))     {
				System.out.println("On " + sec2Title);
			}
			else {
				System.out.println("    **** Section 2 has wrong title " + "'" + a + "'" );
			}
				
		//* Get QID   
		  dr.switchTo().activeElement();
		  
		   b = dr.findElement(By.xpath("//*[@id='grid2']/table/tbody/tr[1]/td[1]/span")).getText();
		  // System.out.println("    Section 1 - Starting QID = " + b);
		 		  
	  if (b.equals(sec2StartQID))  {
		  System.out.println("    - Starting QID = " + b + " is correct"); 
	  }   
	  else {	  
		    
		  System.out.println("    *** Incorrect Starting QID = " + b + " should be " + sec2StartQID);
	  }
					
	 //* Fill-in the Section 2 Bubble 
		 for (int x = 0; x < 30; x=x+1)  { 
			dr.findElement(By.xpath("//*[@id='grid2']/table/tbody/tr[" + (x+1) + "]/td[2]/fieldset/p[" + secTwo[x]  + " ]/label/span")).click();
	     }
		 System.out.println("    - Bubble has been filled in." );
		 
		 
	// Section 3 - Organic ChemistryY ======================================================================  

	// Click Next button for Section 3
		  dr.findElement(By.xpath("//*[@id='navigation-next']"  )).click();
			  	
	
	//*  Get Section 3 Title   */
		 a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
		 
		 System.out.println(" ");
		 		  
		if  (a.equals (sec3Title))     {
			System.out.println("On " + sec3Title);
		}
		else {
			System.out.println("    **** Section 3 has wrong title " + "'" + a + "'" );
		}
		
		
    //* Finding starting QID */
		 dr.switchTo().activeElement();
		 b  = dr.findElement(By.xpath("//*[@id='grid3']/table/tbody/tr[1]/td[1]/span")).getText();
		 dr.switchTo().defaultContent();
		
		  if (b.equals(sec3StartQID))  {
			  System.out.println("    - Starting QID = " + b + " is correct");
		  }	  
		  else {  
			  System.out.println("    *** incorrect Starting QID = " + b + " should be " + sec3StartQID);
		  }
	
		 dr.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		 dr.switchTo().defaultContent();
		 
	// Fill in the Section 3 bubble	  
		 for (int x = 0; x < 30; x=x+1)  { 
			dr.findElement(By.xpath("//*[@id='grid3']/table/tbody/tr[" + (x+1) + "]/td[2]/fieldset/p[" + secThree[x]  + " ]/label/span")).click();
	     }
		 System.out.println("    - Bubble has been filled in." );
		 
		 
	/*//  Verify Check Previous button from Section 3 to Section 2
		dr.findElement(By.xpath("//*[@id='navigation-prev']"  )).click();
		System.out.println("    - Previous Button Validation");
		
		//* Get QID   
		  
		  dr.switchTo().activeElement();
		  dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		  
		  b = dr.findElement(By.xpath("//*[@id='grid2']/table/tbody/tr[1]/td[1]/span")).getText();
		  System.out.println("       - Back on Section 2- Starting QID = " + b);
		 
		  if (b.equals(sec2StartQID)) {
	     	  System.out.println("       - Previous button from Section 3 is working");
	      } 	  
		  else {     
			  System.out.println("       *** Section 2 Starting QID = " + b + " should be " + sec2StartQID );
	      }
		  
	    // Click on Next Button to go back to Section 3
		  	 
		  dr.findElement(By.xpath("//*[@id='navigation-next']"  )).click();
		  System.out.println("       - Navigated back to Section 3");*/
	
		  dr.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		  dr.switchTo().defaultContent();
		  
    		  
	// Section 4 - Reading Comprehension =======================================================================
	// Click on Next Button for Section 4	 
		  dr.findElement(By.xpath("//*[@id='navigation-next']"  )).click();
			  
	// Get Section 4 Title 
		System.out.println(" ");
		  
	    a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
							  
		if  (a.equals (sec4Title))     {
			System.out.println("On " + sec4Title);
		}
		else {
			System.out.println("    *** Section 4 has wrong title " + "'" + a + "'" );
		}	
		
	// Finding starting QID
		dr.switchTo().activeElement();
     	b = dr.findElement(By.xpath("//*[@id='grid4']/table/tbody/tr[1]/td[1]/span")).getText();
     	dr.switchTo().defaultContent();
		
		if (b.equals(startingQID))  {
		   System.out.println("    - Starting QID = " + b + " is correct"); 
		}
	    else {  
	       System.out.println("    *** incorrect Starting QID = " + b + " should be " + startingQID);
		}
		
		dr.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		dr.switchTo().defaultContent();
		
	// Fill in the Section 4 Bubble		
		for (int x = 0; x < 30; x=x+1)  { 
			dr.findElement(By.xpath("//*[@id='grid4']/table/tbody/tr[" + (x+1) + "]/td[2]/fieldset/p[" + secFour[x]  + " ]/label/span")).click();
		}
		System.out.println("    - Bubble has been filled in." );		
			
		
	// Section 5 - Physics. ================================================================
	// Click on Next Button for Section 5	 
		  dr.findElement(By.xpath("//*[@id='navigation-next']"  )).click();
		  dr.switchTo().defaultContent();
					  
	// Get Section 5 Title 
		System.out.println(" ");
			  
	    a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
	    dr.switchTo().defaultContent();
							  
		if  (a.equals (sec5Title))     {
			System.out.println("On " + sec5Title);
		}
		else {
			System.out.println("    *** Section 5 has wrong title " + "'" + a + "'" );
		}	
			
		// Finding starting QID
			dr.switchTo().activeElement();
	     	b = dr.findElement(By.xpath("//*[@id='grid5']/table/tbody/tr[1]/td[1]/span")).getText();
	     	dr.switchTo().defaultContent();			
	     	
			if (b.equals(startingQID))  {
			   System.out.println("    - Starting QID = " + b + " is correct"); 
			}
		    else {  
		       System.out.println("    *** incorrect Starting QID = " + b + " should be " + startingQID);
		    }
				
		// Fill in the Section 5 Bubble		
			for (int x = 0; x < 20; x=x+1)  { 
				dr.findElement(By.xpath("//*[@id='grid5']/table/tbody/tr[" + (x+1) + "]/td[2]/fieldset/p[" + secFive[x]  + " ]/label/span")).click();
			}
			System.out.println("    - Bubble has been filled in." );
			
			
	// Section 6 - Quantitative Reasoning  ======================================================================= 
	// Click on Next Button for Section 6	 
			  dr.findElement(By.xpath("//*[@id='navigation-next']"  )).click();
			  dr.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			  
			// Get Section 6 Title 
				System.out.println(" ");
					  
			    a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
									  
				if  (a.equals (sec6Title))     {
					System.out.println("On " + sec6Title);
				}
				else {
					System.out.println("    *** Section 6 has wrong title " + "'" + a + "'" );
				}	
					
			// Finding starting QID
				dr.switchTo().activeElement();
			   	b = dr.findElement(By.xpath("//*[@id='grid6']/table/tbody/tr[1]/td[1]/span")).getText();
					
					
				if (b.equals(startingQID))  {
				   System.out.println("    - Starting QID = " + b + " is correct"); 
				}
			    else {  
			       System.out.println("    *** incorrect Starting QID = " + b + " should be " + startingQID);
			    }
						
			// Fill in the Section 6 Bubble		
				for (int x = 0; x < 20; x=x+1)  { 
					dr.findElement(By.xpath("//*[@id='grid6']/table/tbody/tr[" + (x+1) + "]/td[2]/fieldset/p[" + secSix[x]  + " ]/label/span")).click();
				}
				System.out.println("    - Bubble has been filled in." );				
				
		
		
     // Click Score My Test button
			dr.findElement(By.xpath("//*[@id='lnkDialog']"  )).click();
			System.out.println("    - SCORE MY TEST button was selected." );
				
			dr.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
			dr.switchTo().defaultContent();
		
		
	 // Submit Score Test Page
		 a = dr.findElement(By.xpath("html/body/div[1]/h3")).getText();
		 System.out.println(" ");
				  
		if  (a.equals (scoreTitle))     {
			System.out.println("On " + scoreTitle + ". Are your ready to submit it for scoring?");
			
		}
		else {
			System.out.println("    *** Score Page wrong title " + "'" + a + "'" );
		}		
		
	// Click Yes button to Submit for scoring
		dr.findElement(By.xpath("html/body/div[1]/div/div/a[1]"  )).click();	
		System.out.println("    - 'YES' button was selected to Submnit for scoring");
		dr.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		  
	// Enter keycode practice smarter	
		System.out.println(" ");
		System.out.println("On Enter Keyword Page ");
		
		 a = dr.findElement(By.xpath("html/body/div[2]/div[1]/h3")).getText();
		  
		if  (a.equals (enterKeywordTitle))     {
			dr.findElement(By.xpath("html/body/div[2]/div[2]/input")).sendKeys("practice smarter");
			System.out.println("    - Keyword been entered");
			
		 // click on the GO! button
			dr.findElement(By.xpath("html/body/div[2]/div[2]/a"  )).click();
		}
		else {
			System.out.println("    *** Enter Keyword page has wrong title " + "'" + a + "'" );
		}	
		
			 
		
	// Scores Page
		//dr.switchTo().activeElement();
		dr.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
		dr.switchTo().defaultContent();
		
		a = dr.findElement(By.xpath("html/body/div[4]/div[1]/h3")).getText();
		System.out.println(" ");
		
		if  (a.equals (scoresTitle))     {
			System.out.println("On " + scoresTitle + " Percent Correct and My Answers page.");
		}
		else {
			System.out.println("    *** Scores Page wrong title " + "'" + a + "'" );
		}				 
		
		
		
		// Get Scores
		    dr.manage().timeouts().pageLoadTimeout(600, TimeUnit.SECONDS);
		    dr.switchTo().defaultContent();
		    
	  /* // Get Perceptual Ability score   
		    a = dr.findElement(By.xpath("//*[@id='lblperAbilityPerc']")).getText();
				    
			if  (a.equals (perceptualAbilityScore))     {
				System.out.println("    - " + a + " is correct");
			}
			else {
				System.out.println("    *** " + a + " is incorrect, should be " + perceptualAbilityScore);
			}  */
			
		
		// Get Academic Average  
		    a = dr.findElement(By.xpath("//*[@id='lblacademicAvgPerc']")).getText();
				    
			if  (a.equals (academicAverageScore))     {
				System.out.println("    - " + a + " is correct");
			}
			else {
				System.out.println("    *** " + a + " is incorrect, should be " + academicAverageScore);
			}
		
	    
			
	}
	}
