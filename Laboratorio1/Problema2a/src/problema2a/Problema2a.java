/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2a;

/**
 *
 * @author HP-PC
 */

import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vaio
 */
public class Problema2a {
    
	public static void main(String[] args) {
    	Lotery();
	}
    
    
	public static void Lotery(){
    	int[] random = new int[3];
    	random[0] = (int)Math.floor((Math.random()*10));
    	random[1] = (int)Math.floor((Math.random()*10));
    	random[2] = (int)Math.floor((Math.random()*10));
   	 
    	System.out.println("Juego de Loteria -- Tres cifras");
    	System.out.println("Digita los numeros de acuerdo a las instrucciones en pantalla");
    	int[] guess = new int[3];
    	System.out.print("Digita el numero de la posicion 1: ");
    	Scanner l = new Scanner(System.in);
    	guess[0] = l.nextInt();
    	System.out.print("Digita el numero de la posicion 2: ");
    	guess[1] = l.nextInt();
    	System.out.print("Digita el numero de la posicion 3: ");
    	guess[2] = l.nextInt();
   	 
    	System.out.println("Los numeros que ingresaste en orden son: " + Arrays.toString(guess));
    	System.out.println("Los numeros ganadores en orden son:" + Arrays.toString(random));	 
   	 
    	int match=0;
    	if(guess[0] == random[0] || guess[0] == random[1] || guess[0] == random[2]){
        	match=match+1;
    	}
   	 
    	int match1=0;
    	if(guess[1] == random[0] || guess[1] == random[1] || guess[1] == random[2]){
        	match1=match1+1;
    	}
   	 
    	int match2=0;
    	if(guess[2] == random[0] || guess[2] == random[1] || guess[2] == random[2]){
        	match2=match2+1;
    	}
   	 
    	int matchcount=match+match1+match2;
    	int reward;
    	if(matchcount==1){
        	reward=10;
        	System.out.println("Tuviste un acierto");
        	System.out.println("Ganaste: " + reward);
    	}else if(matchcount==2){
        	reward=100;
        	System.out.println("Tuviste dos aciertos");
        	System.out.println("Ganaste: " + reward);
    	}else if(matchcount==3){
        	if(guess[0]==random[0] && guess[1]==random[1] && guess[2]==random[2]){
            	reward=1000000;
            	System.out.println("Tuviste tres aciertos en orden exacto");
            	System.out.println("Ganaste: " + reward);
        	}else{
            	reward=1000;
            	System.out.println("Tuviste tres aciertos");
            	System.out.println("Ganaste: " + reward);
        	}
    	}else{
        	reward=0;
        	System.out.println("No tuviste aciertos");
        	System.out.println("No ganaste");
    	}
   	 
   	 
	}
}





