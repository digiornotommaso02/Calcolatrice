/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatriceclientserver;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author tommaso di giorno
 */
public class CalcolatriceClientServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        float numero1;
        float numero2;
        char simbolo;
	Operazioni operazioni;
	ServerSocket server = new ServerSocket(1235);
        while(true){
            System.out.println("Aspettando che il cliente si connetta");
            Socket client = server.accept();
            System.out.println("Il cliente si è connesso");
            
            BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream output = new DataOutputStream(client.getOutputStream());
            String[] nums = input.readLine().split(" ");
            numero1 = Float.parseFloat(nums[0]);
            numero2 = Float.parseFloat(nums[2]);
            simbolo = nums[1].charAt(0);
            operazioni = new Operazioni(numero1, numero2);
            
            switch(simbolo) {
		case '+' :{
                    output.writeBytes(String.valueOf(operazioni.addizione()) + "\n");
                    break;
		}
		case '-' :{
                    output.writeBytes(String.valueOf(operazioni.sottrazione()) + "\n");
                    break;
                }
                case '/' :{
                    output.writeBytes(String.valueOf(operazioni.divisione()) + "\n");
                    break;
		}
		case '*' :{
                    output.writeBytes(String.valueOf(operazioni.moltiplicazione()) + "\n");
                    break;
		}
		default : {
                    output.writeBytes("Errore" + "\n");
                    break;
		}
            }			
        }	
    }  
}
