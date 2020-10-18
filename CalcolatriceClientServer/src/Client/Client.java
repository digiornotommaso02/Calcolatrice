/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;
/**
 *
 * @author tommaso di giorno
 */
public class Client {
    
    public static void main(String[] args) throws IOException
    {
        String op;
	Scanner scanner = new Scanner(System.in);	
	Socket cliente = new Socket("localhost",1235);
        
	DataOutputStream output = new DataOutputStream(cliente.getOutputStream());		
	BufferedReader input = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        
	System.out.println("Inserisci l'operazione (Esempio 3 + 3)");
	op = scanner.nextLine();		
	output.writeBytes(op + "\n");	
	System.out.println("Risultato: " + input.readLine());
	scanner.close();
	cliente.close();
    }
    
}
