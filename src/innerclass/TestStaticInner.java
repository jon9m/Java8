package innerclass;

public class TestStaticInner {

	private int outerMember = 100;
	private static int staticOuterMember = 200;

	public static void main(String[] args) {
		// new InnerClass().invoke();

		TestStaticInner.InnerClass inner = new TestStaticInner.InnerClass();
		inner.invoke();

		System.out.println(inner.innerData);
	}

	private static void staticOuterMethod() {
		System.out.println("Static outer method");
	}

	// Can invoke without instantiating outer class
	static class InnerClass {
		private int innerData = 1000;

		private void invoke() {
			System.out.println("Inner data " + ++innerData);
			// System.out.println("outerMember data " + outerMember);
			System.out.println("staticOuterMember data " + ++staticOuterMember);

			staticOuterMethod();
		}
	}

}
