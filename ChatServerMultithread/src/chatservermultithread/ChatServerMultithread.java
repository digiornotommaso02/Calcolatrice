/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservermultithread;
import java.io.*; 
import java.util.*; 
import java.net.*;

/**
 *
 * @author tommaso di giorno
 */
public class ChatServerMultithread {
    static Vector<GestioneRichieste> gr = new Vector<>(); 
    static int var = 0; 
  
    public static void main(String[] args) throws IOException  
    { 
        ServerSocket server = new ServerSocket(1234);  
        Socket s;  
        while (true) {  
            s = server.accept(); 
            System.out.println("Client connesso" + s); 
            DataInputStream in = new DataInputStream(s.getInputStream()); 
            DataOutputStream ou = new DataOutputStream(s.getOutputStream());  
            GestioneRichieste gestione = new GestioneRichieste(s,"client " + var, in, ou); 
            Thread t = new Thread(gestione);
            System.out.println("Client aggiunto"); 
            gr.add(gestione); 
            t.start(); 
            var++; 
        } 
    } 
}
