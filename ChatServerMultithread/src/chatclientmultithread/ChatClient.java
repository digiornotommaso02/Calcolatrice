/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatclientmultithread;
import java.io.*; 
import java.util.*; 
import java.net.*;  

/**
 *
 * @author tommaso di giorno
 */
public class ChatClient {
    final static int ServerPort = 1234; 
  
    public static void main(String args[]) throws UnknownHostException, IOException  
    { 
        Scanner scn = new Scanner(System.in); 
        InetAddress ip = InetAddress.getByName("localhost"); 
        Socket s = new Socket(ip, ServerPort); 
        DataInputStream in = new DataInputStream(s.getInputStream()); 
        DataOutputStream ou = new DataOutputStream(s.getOutputStream());
        
        /*public void run() { 
            while (true) { 
                String msg = scn.nextLine(); 
                try { 
                    ou.writeUTF(msg); 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }*/

        /*public void run() {
            while (true) { 
                try { 
                    String msg = in.readUTF(); 
                    System.out.println(msg); 
                } catch (IOException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }*/
    } 
}
