
public class Function_PassinValues {

	public static void main(String[] args) {		
	 int s =sumALL(3,4,5);
	 if(s>100) {
		 System.out.println("greater than 100--"+ s);
	 }
	 else{
		 System.out.println("less than 100--"+ s);
	 }
     sumALL(33,433,555);
     sumALL(23,43,53);
     
     
     int x= findsum(100);
     System.out.println("sum of 100 is  " +x);
     x= findsum(200);
     System.out.println("sum of 200 is  "+x);
	}
	
	public static int sumALL (int a , int b, int c) {
		int sum=a+b+c;
		System.out.println(sum);
		
		int temp=100; //local
		return sum;
	}
	
	public static void sumAll(String a, int b, int c) {
		
	
	}
	
	public static int findsum(int n) {
		int sum = 0;
		for(int x=0; x<=n; x++) {
			sum=sum+x;
		}
		return sum;
	}

}
