import java.util.StringJoiner;

public class Pair {
	int a, b;

	public Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Pair.class.getSimpleName() + "[", "]").add("a=" + a).add("b=" + b).toString();
	}
}
