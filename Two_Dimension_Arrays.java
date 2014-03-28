
public class Two_Dimension_Arrays {

	public static void main(String[] args) {

		
		                     //Rows & Columns
		String x[] [] = new String[3][4];
		//first row
		x[0][0] = "A";
		x[0][0] = "B";
		x[0][0] = "C";
		x[0][0] = "D";
		
		//second row
		x[1][0] = "A1";
		x[1][1] = "B1";
		x[1][2] = "C1";
		x[1][3] = "D1";
		
		//third row
		
		x[2][0] = "A2";
		x[2][1] = "B2";
		x[2][2] = "C2";
		x[2][3] = "D2";
		
		
		// rows
		System.out.println("Rows are "+ x.length);
		//columns
		System.out.println("Cols are " + x[0].length);
		int rows=x.length;
		int cols=x[0].length;
		
		for(int rownum=0;rownum<rows; rownum++) {
			for (int colnum=0;colnum<cols;colnum++) {
			System.out.print(x[rownum][colnum] + "--");
		}
			
			Object ar[] =new Object[4];
			ar[0] = "Hello";
			ar[1] = "10293";
			ar[2] = "333";
			ar[3] = true;
			ar[4] = "22.34";
					
		
		}
		
	}

	}
