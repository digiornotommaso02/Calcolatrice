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
public class GestioneRichieste implements Runnable{
    Scanner scanner = new Scanner(System.in); 
    private String nome; 
    DataInputStream in; 
    DataOutputStream ou; 
    Socket s; 
    boolean log; 
    
    public GestioneRichieste(Socket s, String nome, DataInputStream in, DataOutputStream ou) { 
        this.in = in; 
        this.ou = ou; 
        this.nome = nome; 
        this.s = s; 
        this.log = true; 
    } 
  
    public void run() { 
        String received;
        while (true) { 
            try { 
                received = in.readUTF(); 
                System.out.println(received); 
                if(received.equals("logout")){ 
                    this.log = false; 
                    this.s.close(); 
                    break; 
                } 
                StringTokenizer st = new StringTokenizer(received, "#"); 
                String MsgToSend = st.nextToken(); 
                String recipient = st.nextToken(); 
                
            } catch (IOException e) {    
                e.printStackTrace(); 
            }     
        } 
        try { 
            this.in.close(); 
            this.ou.close();   
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
}
