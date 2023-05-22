package Ejercicio04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Polaca {
	 public static void readFile(String ruta) throws ExceptionIsEmpty, ExceptionIsFull {
	        try (Scanner scanner = new Scanner(new File(ruta))) {
	            while (scanner.hasNextLine()) {
	                String expresion = scanner.nextLine().trim();
	                String r1 = inToPos(expresion);
	                int r2 = resultExpresion(r1);
	                System.out.println("1. "+expresion+"->(postFija): "+r1);
	                System.out.println("2. "+expresion+"(resultado): "+r2);
	                System.out.println();
	                
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("No se pudo encontrar el archivo: " + ruta);
	        }
	 }
	 
	 public static String inToPos (String expresion) throws ExceptionIsEmpty, ExceptionIsFull {
		 StackArray<Character> stack = new StackArray<>(expresion.length()-1);
		 String resultado = "";
		 for(char caracter : expresion.toCharArray()) {
			 if(caracter == '(') {
				 stack.push(caracter);
			 }
			 else if(caracter == '$') {
				 continue;
			 }
			 else if(caracter == ')') {
					 while(!stack.isEmpty() && stack.top() != '(') {
						 resultado += stack.pop();
					 }
					 if(!stack.isEmpty() && stack.top() == '(') {
						 stack.pop();
					 }
			 }
			 else if(Character.isDigit(caracter)) {
				 resultado += caracter;
			 }
			 else {
				 
					 while(!stack.isEmpty() && getPrioridad(stack.top()) >= getPrioridad(caracter)) {
						 resultado += stack.pop();
					 }
				
				 stack.push(caracter);
			 }
		 }
		 
		 while (!stack.isEmpty()) {
	            resultado += stack.pop();
	     }
		 
		 return resultado;
	 }
	 
	 public static int resultExpresion(String expresion) throws ExceptionIsEmpty, ExceptionIsFull {
		 StackList<Integer> stackPost = new StackList<>(expresion.length()-1);
		 
		 for(char caracter : expresion.toCharArray()) {
			 if (Character.isDigit(caracter)) {
				 int cara =Character.getNumericValue(caracter);
				 stackPost.push(cara);
				 
			 }
			 else {
				 	int op2 = stackPost.pop();
	                int op1 = stackPost.pop();
	                int respuesta = 0;
	                switch (caracter) {
	                    case '+':
	                    	respuesta = op1 + op2;
	                        break;
	                    case '-':
	                    	respuesta = op1 - op2;
	                        break;
	                    case '*':
	                    	respuesta = op1 * op2;
	                        break;
	                    case '/':
	                    	respuesta = op1 / op2;
	                        break;
	                    case 'S':
	                    	respuesta = (int) Math.pow(op1, op2);
	                        break;
	                }
	                stackPost.push(respuesta);
			 }
		 }
		 
		 return stackPost.pop();
		 
	 }
	 
	 public static int getPrioridad(char operador) {
	        switch (operador) {
	            case '(':
	                return 0;
	                
	            case '+':
	            case '-':
	                return 1;
	                
	            case '*':
	            case '/':
	                return 2;
	                
	            case 'S':
	                return 3;
	        }
	        return -1;
	   }
}
