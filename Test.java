import java.util.Scanner;

public class Test {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		while(true){
			System.out.println("enter b:");
			int in = Integer.parseInt(keyboard.nextLine());
			System.out.println("enter x:");
			int in2 = Integer.parseInt(keyboard.nextLine());
			long start = System.nanoTime();
			System.out.println("result is " + Engine.partition(in, in2));
			long end = System.nanoTime();
			System.out.println("Time " + (end - start)/(double)1000000 + " ms");
		}
	}
}
