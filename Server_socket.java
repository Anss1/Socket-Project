package Project1;

import java.io.*;
import java.util.*; 
//import java.net.Socket;
import java.net.*;
  
// Server class 
public class Server_socket  
{ 
	//@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException   
    { 
        // server is listening on port 5056
		ServerSocket serv = new ServerSocket(5056);
          
        // running infinite loop for getting 
        // client request 
        System.out.println("Server starts...");
        while (true)  
        { 
            Socket s = null; 
              
            try 
            { 
                // socket object to receive incoming client requests 
                s = serv.accept(); 
                  
                System.out.println("A new client is connected : " + s); 
                  
                // obtaining input and out streams 
                DataInputStream dis = new DataInputStream(s.getInputStream()); 
                DataOutputStream dos = new DataOutputStream(s.getOutputStream()); 
                  
                System.out.println("Assigning new thread for this client"); 
  
                // create a new thread object 
                Thread t = new ClientHandler(s, dis, dos); 
  
                // Invoking the start() method 
                t.start(); 
                  
            } 
            catch (Exception e){ 
                s.close(); 
                e.printStackTrace(); 
            } 
        } 
    } 
} 
  
// ClientHandler class 
class ClientHandler extends Thread  
{ 
    
    final DataInputStream dis; 
    final DataOutputStream dos; 
    final Socket s; 
      
  
    // Constructor 
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos)  
    { 
        this.s = s; 
        this.dis = dis; 
        this.dos = dos; 
    } 
  
    @Override
    public void run()  
    { 
        String receivedto;
        String receivedsubject;
        String receivedbody;
        String toreturn;
        while (true)  
        { 
            try { 
  
                // Ask user what he wants 
                dos.writeUTF("To : ");  
                // receive the answer from client 
                receivedto = dis.readUTF();
                /*
                dos.writeUTF("Subject : ");
                receivedsubject = dis.readUTF();

                dos.writeUTF("Body : ");
                receivedbody = dis.readUTF();*/
                
                if(receivedto.equals("Exit")) 
                {  
                    System.out.println("Client " + this.s + " sends exit..."); 
                    System.out.println("Closing this connection."); 
                    this.s.close(); 
                    System.out.println("Connection closed...!"); 
                    break; 
                } 
                  
                // creating Date object 
                Date date = new Date(); 
                  
                // write on output stream based on the 
                // answer from the client 
                switch (receivedto) { 
                  
                    case "Date" : 
//                        toreturn = fordate.format(date); 
//                        dos.writeUTF(toreturn); 
                        break; 
                          
                    case "Time" : 
//                        toreturn = fortime.format(date); 
//                        dos.writeUTF(toreturn); 
                        break; 
                          
                    default: 
                        dos.writeUTF("Invalid input...!"); 
                        break; 
                } 
            } catch (IOException e) { 
                e.printStackTrace(); 
            } 
        } 
          
        try
        { 
            // closing resources 
            this.dis.close(); 
            this.dos.close(); 
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
} 