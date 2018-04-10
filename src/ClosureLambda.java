public class ClosureLambda {
	public static void main(String[] args) {
		int x = 30;
		//int y = 30;

		doOperate(x, new Operate() {
			@Override
			public void operate(int a) {
				final int y = 40; //COMPILE ERROR - Local variable y defined in an
				// enclosing scope must be final or effectively final
				System.out.println(a * y);
			}
		});

		//call again
		doOperate(40, (a) -> {System.out.println(a * a);});
	}

	static void doOperate(int z, Operate op) {
		op.operate(z);
	}
}

interface Operate {
	public void operate(int a);
}
