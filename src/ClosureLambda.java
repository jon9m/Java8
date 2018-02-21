public class ClosureLambda {
	public static void main(String[] args) {
		int x = 20;
		int y = 30;

		doOperate(x, new Operate() {
			@Override
			public void operate(int a) {
				// y = 40; //COMPILE ERROR - Local variable y defined in an
				// enclosing scope must be final or effectively final
				System.out.println(a * y);
			}
		});

		doOperate(x, (a) -> System.out.println(a * y));
	}

	static void doOperate(int z, Operate op) {
		op.operate(z);
	}
}

interface Operate {
	public void operate(int a);
}
