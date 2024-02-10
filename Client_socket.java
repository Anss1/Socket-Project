package Project1;



import java.io.*; 
import java.net.*; 
import java.util.Scanner; 
  
// Client class 
public class Client_socket  
{ 
	static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) throws IOException  
    { 
    	User_login_signup user = new User_login_signup();
    	System.out.println("What do you want? [1-Login - 2-Register]");
    	String choice;
    	choice = reader.nextLine();
    	switch(choice)
    	{
    	case "1":
    		User_login_signup.Login();
    	        try
    	        { 
    	            Scanner scn = new Scanner(System.in); 
    	              
    	            // getting localhost ip 
    	            InetAddress ip = InetAddress.getByName("localhost"); 
    	      
    	            // establish the connection with server port 5056 
    	            Socket s = new Socket(ip, 5056); 
    	      
    	            // obtaining input and out streams 
    	            DataInputStream dis = new DataInputStream(s.getInputStream()); 
    	            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
    	      
    	            // the following loop performs the exchange of 
    	            // information between client and client handler 
    	            while (true)  
    	            { 
    	                System.out.println(dis.readUTF()); 
    	                String tosend = scn.nextLine(); 
    	                dos.writeUTF(tosend); 
    	                  
    	                // If client sends exit,close this connection  
    	                // and then break from the while loop 
    	                if(tosend.equals("Exit")) 
    	                { 
    	                    System.out.println("Closing this connection : " + s); 
    	                    s.close(); 
    	                    System.out.println("Connection closed"); 
    	                    break; 
    	                } 
    	                  
    	                // printing date or time as requested by client 
    	                String received = dis.readUTF(); 
    	                System.out.println(received); 
    	            } 
    	              
    	            // closing resources 
    	            scn.close(); 
    	            dis.close(); 
    	            dos.close(); 
    	        }catch(Exception e){ 
    	            e.printStackTrace(); 
    	        } 
    	    break;
    	case "2":
    		user.Register();
            try
            { 
                Scanner scn = new Scanner(System.in); 
                  
                // getting localhost ip 
                InetAddress ip = InetAddress.getByName("localhost"); 
          
                // establish the connection with server port 5056 
                Socket s = new Socket(ip, 8888); 
                
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
          
                // the following loop performs the exchange of 
                // information between client and client handler 
//                while(true)
//                { 
                    System.out.println(dis.readUTF()); 
                    String tosend = scn.nextLine(); 
                    dos.writeUTF(tosend); 
                    System.out.println(dis.readUTF()); 
                    String Subjectsend = scn.nextLine();
                    dos.writeUTF(Subjectsend); 
                    System.out.println(dis.readUTF()); 
                    String Bodysend = scn.nextLine();  
                    dos.writeUTF(Bodysend); 
                      
                    // If client sends exit,close this connection  
                    // and then break from the while loop 
                    if(tosend.equals("Exit")) 
                    { 
                        System.out.println("Closing this connection : " + s); 
                        s.close(); 
                        System.out.println("Connection closed"); 
                        //break; 
                    } 
                      
                    // printing date or time as requested by client 
                    String received = dis.readUTF(); 
                    System.out.println(received); 
                //} 
                // closing resources 
                scn.close(); 
                dis.close(); 
                dos.close(); 
            }catch(Exception e){ 
                e.printStackTrace(); 
            } 
    	}
 /*       try
        { 
            Scanner scn = new Scanner(System.in); 
              
            // getting localhost ip 
            InetAddress ip = InetAddress.getByName("localhost"); 
      
            // establish the connection with server port 5056 
            Socket s = new Socket(ip, 5056); 
            
            // obtaining input and out streams 
            DataInputStream dis = new DataInputStream(s.getInputStream()); 
            DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
      
            // the following loop performs the exchange of 
            // information between client and client handler 
//            while(true)
//            { 
                System.out.println(dis.readUTF()); 
                String tosend = scn.nextLine(); 
                dos.writeUTF(tosend); 
                System.out.println(dis.readUTF()); 
                String Subjectsend = scn.nextLine();
                dos.writeUTF(Subjectsend); 
                System.out.println(dis.readUTF()); 
                String Bodysend = scn.nextLine();  
                dos.writeUTF(Bodysend); 
                  
                // If client sends exit,close this connection  
                // and then break from the while loop 
                if(tosend.equals("Exit")) 
                { 
                    System.out.println("Closing this connection : " + s); 
                    s.close(); 
                    System.out.println("Connection closed"); 
                    //break; 
                } 
                  
                // printing date or time as requested by client 
                String received = dis.readUTF(); 
                System.out.println(received); 
            //} 
            // closing resources 
            scn.close(); 
            dis.close(); 
            dos.close(); 
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
    }*/ 
} 
}
