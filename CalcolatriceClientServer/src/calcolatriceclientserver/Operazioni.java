/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcolatriceclientserver;

/**
 *
 * @author tommaso di giorno
 */
public class Operazioni {
    public float numero1;
    public float numero2;
    
    Operazioni(float numero1, float numero2){
	this.numero1 = numero1;
	this.numero2 = numero2;
    }
    
    public float addizione(){
	float somma;		
	somma = this.numero1 + this.numero2;
	return somma;
    }
    
    public float sottrazione(){
	float differenza;	
	differenza = this.numero1 - this.numero2;
	return differenza;
    }
    
    public float moltiplicazione(){
	float prodotto;		
	prodotto = this.numero1 * this.numero2;
	return prodotto;
    }
    
    public float divisione(){
	float quoziente;		
	quoziente = this.numero1 / this.numero2;
	return quoziente;
    }
}
