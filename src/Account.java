
import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhswf4
 */
public class Account implements Serializable
{
        public double balance;
	private int firstDate;
	private int secondDate;
	private  Calendar date1 = new GregorianCalendar();
	private  Calendar date2 = new GregorianCalendar();
	private  boolean dateflag = false;
	private double rate;
        private String name;
    
public Account()throws IOException
    {
        balance = 100;
    }
    
public void acctMenu()throws IOException
    {

    //public void acctMenu()
        {
            Scanner sc = new Scanner(System.in);
            String choice = null;
        
        
        
            do
            {
            
            System.out.println("D) Deposit");
            System.out.println("W) Withdraw");
            System.out.println("C) Check Balance");
//            System.out.println("A) Account Selection");
            System.out.println("E) Exit");
            //System.out.println("S) Save");
            System.out.print("Please choose an option: ");
            
//            ATMs myATM = new ATMs();
            
            choice = sc.next();
            
            if(choice.equalsIgnoreCase("d"))
            {
                acctDeposit();
            }
            else if(choice.equalsIgnoreCase("w"))
            {
                acctWithdraw();
            }
            else if(choice.equalsIgnoreCase("c"))
            {
                checkBalance();
            }
//            else if(choice.equalsIgnoreCase("a"))
//            {
//                myATM.pickAccts();
//            }
//            else if(choice.equalsIgnoreCase("s"))
//            {
//                myATM.saveAccount();
//            }
           
            }while(!choice.equalsIgnoreCase("e"));
        }
    }


    /**
     * @return the name
     */
public String getName() 
    {
        return name;
    }

    /**
     * @param name the name to set
     */
public void setName(String name) 
    {
        this.name = name;
    }
    
private void acctDeposit()throws IOException
    {
        System.out.println("How much would you like to deposit?");
        Scanner sc = new Scanner(System.in);
        double input = sc.nextInt();
        getDate1();  
        balance = (balance + input);        //System.out.println("Your balance is: " + acctGetBalance());
    }
private void acctWithdraw()throws IOException
    {
        System.out.println("How much would you like to withdraw?");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if(input > balance)
        {
            System.out.println("Insufficient funds.");
            //System.out.println("How much would you like to withdraw?");
        }
    else
        {
            double amount = input;
            balance = balance - amount;
            //System.out.println("Your balance is: " + acctGetBalance());
        }    
        getDate1();
    }
    
private void getDate1()throws IOException
    {
       
       System.out.println("Enter Todays Date(mm/dd/yyyy: ");
       Scanner sc = new Scanner(System.in);
       String input = sc.next();
       SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
       ParsePosition pos = new ParsePosition(0);
       Date date= new Date();
       date = formatter.parse(input, pos);
       date1.setTime(date);

        firstDate = date1.get(Calendar.DAY_OF_YEAR);
        dateflag = true;
    }
   
private void getDate2() throws IOException
    {
        System.out.print("Enter todays date(mm/dd/yyyy): ");
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        ParsePosition pos = new ParsePosition(0);
        Date date= new Date();
        date = formatter.parse(input, pos);

        date2.setTime(date);
        secondDate = date2.get(Calendar.DAY_OF_YEAR);
        getInterest();

        if (firstDate > secondDate) 
        {
            System.out.println("You must enter a future date.");
            getDate2();
        }
    }    
    
private void getInterest()throws IOException
    { 
        int dateDiff = secondDate-firstDate;
        rate = .05/365;
        double rateTime;
        rateTime = Math.pow(1 + rate, dateDiff);
        balance = (balance * rateTime);
        firstDate = secondDate;   
        System.out.println("Your Balance is: " + getBalance());     
    }
    
private void checkBalance()throws IOException
    {
        getDate2();
    }
private String getBalance()throws IOException
    {        
        NumberFormat currencyFormatter;
        String currencyOut;        
        currencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        currencyOut = currencyFormatter.format(balance);
        return currencyOut;
    }

    
}
