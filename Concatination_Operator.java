import javax.print.DocFlavor.STRING;


public class Concatination_Operator {

	public static void main(String[] args) {

		
	String x= "Hello ";	
	String y= "world ";
	int a=100;
	int b=200;
	System.out.println(x+y);
	System.out.println(a+b);
	System.out.println(a+b+x+y);
	System.out.println(x+y+(a+b));
	}

}
