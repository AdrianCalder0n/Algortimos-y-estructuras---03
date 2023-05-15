package actividad1;

import exceptions.ExceptionIsEmpty;

public class Test {

	public static void main(String[] args) {
		Stack<Character> s1 = new StackArray<Character>(5);
		System.out.println("Esta vacía? " + s1.isEmpty());
		try {
			s1.push('w');
			System.out.println(s1 + "\tTope : " + s1.top());
			s1.push('k');
			System.out.println(s1 + "\tTope : " + s1.top());
			s1.push('l');
			System.out.println(s1 + "\tTope : " + s1.top());
			s1.push('p');
			System.out.println(s1 + "\tTope : " + s1.top());
			s1.push('o');
			System.out.println(s1 + "\tTope : " + s1.top());
			s1.push('r');
			System.out.println(s1);
			System.out.println("Esta vacía? " + s1.isEmpty());
			s1.push('s');
			System.out.println(s1);
			System.out.println("Esta vacía? " + s1.isEmpty());
			System.out.println(s1 + "\tTope : " + s1.top());
			System.out.println("Eliminado: " + s1.pop());
			System.out.println(s1 + "\tTope : " + s1.top());
			System.out.println("Eliminado: " + s1.pop());
			System.out.println(s1 + "\tTope : " + s1.top());
			System.out.println("Eliminado: " + s1.pop());
			System.out.println(s1 + "\tTope : " + s1.top());
			
			
		}
		catch (ExceptionIsEmpty e) {
			System.out.println(e.getMessage());
		}
	}

}
