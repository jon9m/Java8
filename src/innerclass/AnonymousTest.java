package innerclass;

public class AnonymousTest {

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Running ...");
			}

		}).start();
	}

}
