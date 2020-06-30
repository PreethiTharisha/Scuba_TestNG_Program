package calculator.cal;

import java.lang.Math;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import org.testng.annotations.Test;

/**
 * The Calculator class provides static methods for
 *  arithmetic operations on two integers.
 */
@SuppressWarnings("restriction")
public class CalculatorTest {
	
	
	@DataProvider(name="inputs")
	public Object[][] getData() {
		
		return new Object[][] {
			{20, 5}
			
		};
	}
	
	@DataProvider(name="realNumbers")
	public Object[][] getReal() {
		
		return new Object[][] {
			{2, 3}
			
		};
	}
	
   @Test(dataProvider="inputs",groups= {"include_Addgrouping"})
   public void add(int number1, int number2) {
		int result=Calculator.add(number1, number2);
		Assert.assertEquals(result, 25);
		Assert.assertTrue(result==25,"True");
		Assert.assertFalse(result==0, "False");
		Assert.assertNotEquals(result, 30);
	    Reporter.log("TestNG_ReportsAndLogs -> Add",true);
    }
 
	@Test(enabled=true,dataProvider="inputs",groups= {"include_Subgrouping"})
    public void sub(int number1, int number2) {
		int result=Calculator.sub(number1, number2);
		Assert.assertEquals(result, 15);
		Assert.assertTrue(result==15,"True");
		Assert.assertFalse(result==0, "False");
		Assert.assertNotEquals(result, 30);
	    Reporter.log("TestNG_ReportsAndLogs -> Sub",true);
     }
   
	@Test(enabled=true,dataProvider="inputs",groups= {"include_Mulgrouping"}) 
    public void mul(int number1, int number2) {
		double result=Calculator.mul(number1, number2);
		Assert.assertEquals(result, 100);
		Assert.assertTrue(result==100,"True");
		Assert.assertFalse(result<0, "False");
		Assert.assertNotEquals(result, 150);
	   Reporter.log("TestNG_ReportsAndLogs -> mul",true);
    }
 
   
   // Integer divide. Return a truncated int.
	@Test(enabled=true,dataProvider="inputs",groups= {"inlude_Divgrouping"})
   public void divInt(int number1, int number2) {
		double result=Calculator.divInt(number1, number2);
		Assert.assertEquals(result, 4);
		Assert.assertTrue(result==4,"True");
		Assert.assertFalse(result<=0, "False");
		Assert.assertNotEquals(result, 5);
        Reporter.log("TestNG_ReportsAndLogs -> divInt",true);
   }
 
   
   // Real number divide. Return a double.
	@Test(enabled=true,dataProvider="realNumbers",groups= {"exclude_divRealgrouping"})
   public void divReal(int number1, int number2) {
      
		double result=Calculator.divInt(number1, number2);
		Assert.assertEquals(result, 0);
		Assert.assertTrue(result==0,"True");
		Assert.assertFalse(result<0, "False");
		Assert.assertNotEquals(result, -1);
        Reporter.log("TestNG_ReportsAndLogs -> divReal",true);
   }
   
   
   // Exponent
	@Test(enabled=true,dataProvider="realNumbers",groups= {"exclude_Expgrouping"})
   public void exp(double number1, double number2) {
		
		double result=Calculator.exp(number1, number2);
		Assert.assertEquals(result, 8);
		Assert.assertTrue(result==8,"True");
		Assert.assertFalse(result<0, "False");
		Assert.assertNotEquals(result, 0);
        Reporter.log("TestNG_ReportsAndLogs -> Exp ",true);
   }
   
   
   // Modulus
	@Test(enabled=true,dataProvider="inputs",groups= {"include_Modgrouping"})
   public void mod(int number1, int number2) {
		double result=Calculator.mod(number1, number2);
		Assert.assertEquals(result, 0);
		Assert.assertTrue(result==0,"True");
		Assert.assertFalse(result>0, "False");
		Assert.assertNotEquals(result, 0);
        Reporter.log("TestNG_ReportsAndLogs -> Mod",true);
   }

   // Inverse
	@Parameters("inverse")
	@Test(enabled=true,groups= {"include_Inversegrouping"})
   public void inverse(@Optional("5") String inverse) {
		double result=Calculator.inverse(Integer.parseInt(inverse));
		Assert.assertEquals(result, 0.2);
		Assert.assertTrue(result==0.2,"True");
		Assert.assertFalse(result<0, "False");
		Assert.assertNotEquals(result, -1);
        Reporter.log("TestNG_ReportsAndLogs -> Inverse",true);
   }
         
   
   // Negate
	@Parameters("negate")
	@Test(enabled=true,groups= {"include_Negategrouping"})
   public void negate(@Optional("-1") String negate) {
		double result=Calculator.inverse(Integer.parseInt(negate));
		Assert.assertEquals(result, -1);
		Assert.assertTrue(result==-1,"True");
		Assert.assertFalse(result>0, "False");
		Assert.assertNotEquals(result, -1);
        Reporter.log("TestNG_ReportsAndLogs -> negate",true);
   }   
   
}