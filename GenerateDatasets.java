package datasets;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateDatasets {
	private static String [] names={"Abhinav Singh","Neenad Jadhav","Kavita Baradur","Tina Aguiar","Madhushree Kulkarni","Ankit Mehra","Rakesh Nair","Nihir Shah","Priyanka Poojary","Abhisekh Kamath","Anish Pillai","Wayne Rooney","Cristiano Ronaldo","Sachin Tendulkar","Allan Donald","Deeksha Chadda","Aparna Sihag","Raveesh Tonse","Nikhil Hate","Sunny Wadte","Joyveer Ghosh","Sachin Ghadi","Sneha Shetty","Ekta Kulkarni","Samar Nayak","Rohan Kathait","Siddhart Dave","Daljeet Kaur","Bhushan Kawale","Kirit Gupta","Abhishek Gaonkar","Aditya Murdeshwar"};
	private static int [] countryCodes={1,2,3,5,6,7,8,9,10};
	private static float [] salary={1000,2000,3000,40000,45000,9000,10000,45000,55000,66000,50000,1001};
	private static int [] age={28,26,27,29,28,30,22,50,24,30,66,70,54,59};
	private static float [] transTotal={10,11,12,13,14,15,16,17,18,19,100,200,300,400,500,600,900,800,1000,999,111,333,444,332,189,201,401,501,601,901,405,566,666,789};
	public static void main(String [] args){
		generateCustomer("Customers.csv");
		generateTransactions("Transaction.csv");
	}
	
	public static void generateCustomer(String filename){
		PrintWriter pr=null;
		pr=writeFile(filename);
		if(pr==null){
			System.out.println("Exception ");
			return;
		}
		for(int i=1;i<=50000;i++){
			pr.println(i+","+names[new Random().nextInt(names.length)]+","+age[new Random().nextInt(age.length)]+","+countryCodes[new Random().nextInt(countryCodes.length)]+","+salary[new Random().nextInt(salary.length)]);
			pr.flush();
		}
		pr.close();
	}
	public static void generateTransactions(String filename){
		PrintWriter pr=null;
		pr=writeFile(filename);
		if(pr==null){
			System.out.println("Exception transactions ");
			return;
		}
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    
		for(int i=1;i<=5000000;i++){
			pr.println(i+","+getRandomNumberInRange(1,50000)+","+transTotal[new Random().nextInt(transTotal.length)]+","+countryCodes[new Random().nextInt(countryCodes.length)]+","+RandomStringUtils.random(length, useLetters, useNumbers));
			pr.flush();
		}
		pr.close();
	}
	public static PrintWriter writeFile(String filename){
		String pwd=System.getProperty("user.dir");
		PrintWriter pr=null;
		try{
			pr=new PrintWriter(new FileWriter(new File(pwd+File.separator+filename),true));
		}catch(IOException e){
			pr=null;
		}
		return pr;
	}
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
