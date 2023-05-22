package actividad2;

import exceptions.ExceptionIsEmpty;

public class Test {

	public static void main(String[] args) {
		Queue<Character> q1 = new QueueLink<Character>();
		try {
			q1.enqueue('d');
			System.out.println(q1 + "\tFront: " + q1.front() + "\tBack: " + q1.back());
			q1.enqueue('e');
			System.out.println(q1 + "\tFront: " + q1.front() + "\tBack: " + q1.back());
			q1.enqueue('f');
			System.out.println(q1 + "\tFront: " + q1.front() + "\tBack: " + q1.back());
			q1.enqueue('g');
			System.out.println(q1 + "\tFront: " + q1.front() + "\tBack: " + q1.back());
			q1.enqueue('h');
			System.out.println(q1 + "\tFront: " + q1.front() + "\tBack: " + q1.back());
			q1.enqueue('j');
			System.out.println(q1 + "\tFront: " + q1.front() + "\tBack: " + q1.back());
		}
		catch (ExceptionIsEmpty e) {
			System.out.println(e.getMessage());
		}
	}

}
