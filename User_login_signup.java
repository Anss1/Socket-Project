package Project1;

import java.io.*; 
import java.text.*; 
import java.util.*;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;
import com.sun.org.apache.xerces.internal.impl.xs.identity.Selector.Matcher;

import java.net.*; 


public class User_login_signup {
	static Scanner reader = new Scanner(System.in);
	public static void Register() throws IOException {
		
	    File file = new File("E:\\desktop\\project of java\\src\\Project1\\DK.txt");
	    if(file.exists())
	    {
	    	System.out.println("The File already exists");
	    }
	    else
	    {
	    	file.createNewFile();
	    }
	    boolean flag = false;
    	Scanner scan = new Scanner(new File("E:\\desktop\\project of java\\src\\Project1\\DK.txt"));
    	String endl = System.getProperty("line.separator");

	    FileWriter file_write = new FileWriter(file,true);
	    BufferedWriter buffer_to_write = new BufferedWriter(file_write);
	    
	    
		String UserName;
	    String password;
    	System.out.println("--------Registeration Menu--------");
	    System.out.println("Enter the Username: ");
	    UserName = reader.nextLine();
	    String merge = UserName.concat("-");
	    BufferedReader bf = new BufferedReader(new FileReader("E:\\desktop\\project of java\\src\\Project1\\DK.txt"));
	    String temp;
        while((temp = bf.readLine()) != null){
            String starr[] = temp.split(" ");
            for (String string2 : starr) {
                if(string2.matches(merge)){
                    System.out.println("Sorry, Username already token please try again");
                    flag = true;
                    System.exit(0);
                }
            }
        }
	    if(flag == false)
	    {
	    buffer_to_write.write(UserName);
	    System.out.println("Password: ");
	    password = reader.nextLine();
	    buffer_to_write.write("-"+password+endl);
	    buffer_to_write.close();
	    System.out.println("Done creating the user");
	    }
	}
	public static void Login() throws IOException
	{
		
	    File file = new File("E:\\desktop\\project of java\\src\\Project1\\Ds.txt");
	    boolean flag = false;
    	Scanner scan = new Scanner(new File("E:\\desktop\\project of java\\src\\Project1\\DK.txt"));
    	String endl = System.getProperty("line.separator");
	    if(!file.exists())
	    {
	    	file.createNewFile();
	    }
	    FileWriter file_write = new FileWriter(file,true);
		String UserName;
	    String password;
		System.out.println("--------Login Menu--------");
    	System.out.println("Enter the Username: ");
    	UserName = reader.nextLine();
    	System.out.println("Enter the password: ");
    	password = reader.nextLine();
    	BufferedReader bf = new BufferedReader(new FileReader("E:\\desktop\\project of java\\src\\Project1\\DK.txt"));
        String temp;
        String merge = UserName.concat("-"); //Merging two words in one word
        String merge1 = merge.concat(password); //Merging two words in one word
        System.out.println(merge1);
        while((temp = bf.readLine()) != null){
            String starr[] = temp.split(" ");
             
            for (String string2 : starr) {
                if(string2.matches(merge1)){
                    System.out.println("--------Login Succeed--------");
                    flag = true;
                    System.exit(0);
                }
            }
        }
        
    	if(flag == false)
	    {
	    	System.out.println("Error please check the Username and password");
	    	System.exit(0);
	    }
	}
	public static void main(String[] args) throws IOException
	{
	    System.out.println("What do you want? [Login - Register]");
	    Register();
	    Login();
	}
}