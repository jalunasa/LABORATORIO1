/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratori1_1;

/**
 *
 * @author HP-PC
 */

class Algoritmo1 {
	void func1(){
        	System.out.println("Segunda funcion");
	}
    
	void func2(){
        	System.out.println("Tercera funcion");
	}
}

class Testalgoritmo1{
	public static void main(String[] args) {
    	System.out.println("Primera funcion en Main");
    	Algoritmo1 p = new Algoritmo1();
    	p.func1();
    	p.func2();
    	System.out.println("Se termina Main");
	}
}


