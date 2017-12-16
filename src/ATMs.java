
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class ATMs 

{
    private Account[] acctArray = new Account[3];
    
     private void saveAccount()throws IOException
    {
        try
        {
            FileOutputStream outStream = new FileOutputStream("File1.out");
            ObjectOutputStream os = new ObjectOutputStream(outStream);
            os.writeObject(acctArray);
            os.flush();
            os.close();
        }
        catch (Exception e)
        {
            
            System.err.println(e);
        }
    }
    
    private void loadAccount() throws IOException
    {
//                ATMs testobj = null;
	try
        {
            FileInputStream fis = new FileInputStream("File1.out");
            ObjectInputStream ois = new ObjectInputStream(fis);
//			testobj = (ATMs)ois.readObject();
            acctArray = (Account[])ois.readObject();
            ois.close();
        }
            catch (Throwable e)
	{
			System.err.println(e);
        }
            
              
    }
    public static void main(String []args) throws IOException
    {
        
        System.out.print("Do you have an account with our bank? ");
        Scanner sc = new Scanner(System.in);
        //String choice = null;
        String choice = sc.next();
        ATMs myATM = new ATMs();


        if(choice.equalsIgnoreCase("no"))
        {
            myATM.populateAccts();
            //Account.acctMenu();
            
        }
        else if(choice.equalsIgnoreCase("yes"))
        {
            myATM.loadAccount();
        }
        else
        {
            System.out.print("Please enter Yes or No: ");
        }
        myATM.pickAccts();
        myATM.saveAccount();
    }
    

    private void nameAccts()throws IOException
    {
        System.out.println("Thank you for choosing Make It Rain, Inc. ");
        System.out.println("Let's get you started by creating three unique accounts.");
        Scanner sc = new Scanner(System.in);
        String input;
        
        for(int i = 0; i < acctArray.length; i++)
        {
                System.out.print("Please enter a name for your account " + i +": ");
                input = sc.next();
                acctArray[i].setName(input);
        }
        
    }

    private void populateAccts() throws IOException
    {
        for(int i=0; i<acctArray.length; i++)
        {
            acctArray[i] = new Account(); 
        }
        nameAccts();
    }
   
    
    private void pickAccts()throws IOException
    {
       String input;//int option = 0;
        do
        {
            System.out.print("Please choose an account name or exit to leave: ");
            Scanner sc = new Scanner(System.in);
            input = sc.next();
 
            //option = sc.nextInt();
            if(!input.equalsIgnoreCase("exit"))
            {
                for(int i = 0; i < acctArray.length; i++)
                {
                    if(acctArray[i].getName().equalsIgnoreCase(input))
                    {
                        acctArray[i].acctMenu();
                    }

                }
            }
        }while(!input.equalsIgnoreCase("exit"));
    }
    

}

