
import java.io.IOException;
import java.util.Arrays;
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
//public class ATM 
//{


import java.util.Date;
 
public class ATM 
{
public static Accounts[] acctArray = new Accounts[3];
     
 public static void main(String[] args) throws IOException
{
  Scanner sc = new Scanner (System.in);
  System.out.println("Is this your first time opening the account?");
  String input;
  input = sc.next();

  while (input.equalsIgnoreCase("yes"))
  {
      ATM.populateAccount();
  
  }

}
    public static void populateAccount() throws IOException
 {
     for(int i=0; i<acctArray.length; i++)
     {
     acctArray[i] = new Accounts(100.00);
     }
 }   
public static void startMenu()
{
    System.out.println("Select an Account");
    
}
// public void populateAccount
// {
//     for(int i=0; i<acctArray.length; i++)
//     {
//      acctArray[i] = new Accounts(100.00);
//     }
//  }
//private Account[] acctArray = new Account[3];

//
//public static void main(String[] args)
//{
//    Scanner sc = new Scanner(System.in);
//    System.out.println("Is this your first time opening the account?");
//    String input;
//    input = sc.next();
//    
//            
//    while (input == "yes")
//    {
//        populateAccount;
//    }
//    else if 
//    {
//      //do nothing      
//    }
         
  
  //public void populateAccount
  //{
     // for(int i=0; i<acctArray.length; i++)
      //{
        //  acctArray[i] = new Account(100.00);
      //}
          
  //
 
  
//}

//main method
    //prompt, if yes populate, if no load
    
//methods
// -populate accts, for loop
//populate accts, for loop set default to 100
//startMenu
//  - while, what account do you want, if !=99 input.menu
//save accts-writing out a file
}

