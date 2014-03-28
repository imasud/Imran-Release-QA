
public class Arrays {

	public static void main(String[] args) {


		
		String username = "xxxx";
		String password = "yyyyy";
		String email = "asd@gmail.com";
		String zip = "123";
		String city = "London";
		
		// Arrays
		//Read the data from xl file and put inside the array
		
		String Str[]= new String[5];
		Str[0] = "xxxx";
		Str[1] = "xxxx";
		Str[2] = "asd@gmail.com";
		Str[3] = "123";
		Str[4] = "London";
		
	int i []=new int[4]; 
	i[0] = 300;
	i[1] = 400;
	i[2] = 500;
	i[3] = 600;
	char c[]=new char[4];
	
		
		// length of Array
	System.out.println(Str.length);
	System.out.println(i.length);
	
	for(int x=0;x<Str.length;x++){
		System.out.println(Str[x]);
		
	}
	
	for (int y=i.length-1;y>=0;y--) {
		System.out.println(i[y]);
	}
		
		
		
	}

}
