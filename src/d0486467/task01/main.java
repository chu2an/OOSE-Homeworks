package d0486467.task01;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NNEntity[] xListA = { new NNInteger(2), new NNInteger(3), new NNInteger(5), new NNInteger(6), new NNInteger(10) };
		NNEntity[] yListA = { new NNInteger(7), new NNInteger(2), 	new NNInteger(3), new NNInteger(4), new NNInteger(8) };
		TableDisplayer.multiplyAndShow(xListA, yListA);
				
		NNEntity[] xListB = { new NNString("Q"), new NNString("D"), new NNString("T"), new NNString("H"), new NNString("Z") };
		NNEntity[] yListB = { new NNString("Y"), new NNString("D"), new NNString("Z"), new NNString("V"), new NNString("B") };
		TableDisplayer.multiplyAndShow(xListB, yListB);
				
		NNEntity[] xListC = { new NNColor("Red"), new NNColor("Red"), new NNColor("Red"), new NNColor("Green"), new NNColor("Blue") };
		NNEntity[] yListC = { new NNColor("Green"), new NNColor("Blue"), new NNColor("Red"), new NNColor("Blue"), new NNColor("Green") };
		TableDisplayer.multiplyAndShow(xListC, yListC);
	}
}
interface NNEntity {
	public abstract NNEntity multiply(NNEntity otherone);
}
class TableDisplayer { // *** To print as a table ***
	public static void multiplyAndShow(NNEntity[] xList, NNEntity[] yList) {
		NNEntity[][] table = new NNEntity[yList.length][xList.length];
		for (int i = 0; i < yList.length; i++) {
			for (int j = 0; j < xList.length; j++) {
				table[i][j] = xList[j].multiply(yList[i]);
			}
		}
		// *** Ready to print ***
		System.out.printf("%7s", "");
		for (int i = 0; i < xList.length; i++) {
			System.out.printf("%7s", xList[i]);
		}
		System.out.println();
		for (int i = 0; i < yList.length; i++) {
			System.out.printf("%7s", yList[i]);
			for (int j = 0; j < xList.length; j++) {
				System.out.printf("%7s", table[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}//class TableDisplayer

class NNInteger implements NNEntity {
	private int number;
	public NNInteger(int number) {
		this.number = number;
	}
	public NNInteger(NNInteger copy) {
		this(copy.number);
	}
	// *** mult numbers ***
	public NNEntity multiply(NNEntity another) {
		if (another == null) {
			return null;
		} else if (getClass() != another.getClass()) {
			return null;
		} else {
			NNInteger another2 = (NNInteger) another;
			return new NNInteger(this.number * another2.number);
		}
	}
	public String toString() {
		return Integer.toString(number);
	}
}//class NNInteger

class NNString implements NNEntity {
	private String words;
	public NNString(String words) {
		this.words = words;
	}
	public NNString(NNString copy) {
		this(copy.words);
	}
	public NNEntity multiply(NNEntity otherone) {
		if (otherone == null) {
			return null;
		} else if (getClass() != otherone.getClass()) {
			return null;
		} else {
			NNString otherone2 = (NNString) otherone;
			return new NNString(this.words + otherone2.words);
		}
	}
	public String toString() {
		return words;
	}
}//class NNString

class NNColor implements NNEntity {
	private String colors;
	String result;
	public NNColor(String colors) {
		this.colors = colors;
	}
	public NNColor(NNColor copy) {
		this(copy.colors);
	}
	public NNEntity multiply(NNEntity otherone) {
		if (otherone == null) {
			return null;
		} else if (getClass() != otherone.getClass()) {
			return null;
		} else {
			NNColor otherone2 = (NNColor) otherone;
			this.result = mixColor(this.colors,otherone2.colors);
			return new NNColor(result + "");
		}
	}
	public String toString() {
		return colors;
	}
	private String mixColor(String a, String b) {
		String color="NULL";
		switch(a) {
			case "Red":
				if(b=="Green") {
					color="Yellow";
				}
				else if(b=="Blue"){
					color="Purple";
				}
				else {
					color="Red";
				}
				break;
			case "Blue":
				if(b=="Red") {
					color="Purple";
				}
				else if(b=="Green"){
					color="Cyan";
				}
				else {
					color="Blue";
				}
				break;
			case "Green":
				if(b=="Red") {
					color="Yellow";
				}
				else if(b=="Blue"){
					color="Cyan";
				}
				else {
					color="Green";
				}
				break;
		}
		return color;
	}
}

