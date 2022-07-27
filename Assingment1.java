package ineuronJava;

public class Assingment1 {

	public static void main(String[] args) {
		//1 To print INEURON using pattern
		System.out.println("Problem 1");
		int n=7;
		int i,j;
		
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {     // FOR I
				if(i==0 || i==n-1 || j==(n-1)/2 ) {
					System.out.print(" *");
				}
				else
					System.out.print("  ");
				
			}
			System.out.print(" ");
			
			for(j=0;j<n;j++) {     // FOR N
                if(j==0 || j==n-1 || i==j ) {
                    System.out.print(" *");
                }
                else
                    System.out.print("  ");

            }
            System.out.print(" ");
            for(j=0;j<n;j++) {     // FOR E
                if(i==0 || i==n-1 || i==(n-1)/2 || j==0 ) {
                    System.out.print(" *");
                }
                else
                    System.out.print("  ");

            }
            System.out.print(" ");
            for(j=0;j<n;j++) {     // FOR U
                if(  j==0||j==n-1||i==n-1 )  {  //  ||i==n-1   ||  || i>3*(n-1)/4&&( j<(n-1)/4 || j==0||j==n-1)&&i<=3*(n-1)/4
                    System.out.print(" *");
                }
                else
                    System.out.print("  ");

            }
            System.out.print(" ");
            for(j=0;j<n;j++) {     // FOR R
                if(j==0||i==(n-1)/2||i==0 || i<=(n-1)/2&&j==(n-1) || i>(n-1)/2&&i-j==(n-1)/4) {  // j==0||j==n-1)&&i<=3*(n-1)/4
                    System.out.print(" *");
                }
                else
                    System.out.print("  ");

            }
            System.out.print(" ");
            for(j=0;j<n;j++) {     // FOR O
                if( (j==0||j==n-1)||(i==0||i==n-1))  {  //  ||i==n-1   ||  || i>3*(n-1)/4&&( j<(n-1)/4
                    System.out.print(" *");
                }
                else
                    System.out.print("  ");

            }
            System.out.print(" ");
            for(j=0;j<n;j++) {     // FOR N
                if(j==0 || j==n-1 || i==j ) {
                    System.out.print(" *");
                }
                else
                    System.out.print("  ");

            }
			
			System.out.println(" ");
		}
		
		System.out.println("\nProblem 2");
		
		for(i=1;i<5;i++) {
			for(j=1;j<5;j++) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		System.out.println("\nProblem 3");
		
		int p=15;
		for(i=0;i<p;i++) {
			for(j=0;j<p;j++) {
				if( i==0 || i+j<=(p-1)/2 || j==0||j==p-1 || i==p-1 || j-i>=(p-1)/2)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		System.out.println("\nProblem 4");
		
		for(i=0;i<p;i++) {
			for(j=0;j<p;j++) {
				if(i-j>=(p-1)/2 || i+j>=3*(p-1)/2)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
		System.out.println("\nProblem 5");
		
		for(i=0;i<p;i++) {
			for(j=0;j<p;j++) {
				if(i==0||i==p-1|| i+j<=(p-1)/2 || i-j>=(p-1)/2)
					System.out.print(" *");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
		
	}
	
}
