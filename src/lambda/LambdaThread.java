package lambda;

public class LambdaThread {

	public static void main(String[] args) {
		new Thread(()-> 
			System.out.println("Ran....")
		).start();
	}

}
