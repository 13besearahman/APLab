package matrix;

public class class1 {
	
	int x = 2;
	
	int r1 = x;
	int c1 = x;
	
	int r2 = x;
	int c2 = x;
	
	int[][] m1 = new int[r1][c1];
	int[][] m2 = new int[r2][c2];
	
	int[][] ans_Normal = new int[r1][c2];
	int[][] ans_Stressen = new int[r1][c2];
	
	
	public class1() {
		/*for(int i=0 ; i<x ; i++){
			for(int j=0 ; j<x ; j++){
				m1[i][j] = (int) (Math.random()*5+1);
				m2[i][j] = (int) (Math.random()*5+1);	
			}
		}*/
	}
	
	public class1(int[][] A, int[][] B){
		m1 = A;
		m2 = B;
	}
	
	public int[][] custom_Method(){
		int sum = 0;
		for ( int c = 0 ; c < r1 ; c++ )
        {
           for ( int d = 0 ; d < c1 ; d++ )
           {   
              for ( int k = 0 ; k < c2 ; k++ )
              {
                 sum = sum + m1[c][k]*m2[k][d];
              }
              ans_Normal[c][d] = sum;
              sum = 0;
           }
        }
		//print();
		return ans_Normal;
	}
	
	public void stress_Method(){
		
		Strassen s = new Strassen();
		ans_Stressen = s.Stress_Method(x, m1, m2);
		
	}
	
	public void print(){
		for(int i=0 ; i<r1 ; i++){
			for(int j=0 ; j<c2 ; j++){
				System.out.println("Mat1: "+m1[i][j]);
			}
		}for(int i=0 ; i<r1 ; i++){
			for(int j=0 ; j<c2 ; j++){
				System.out.println("Mat2: "+m2[i][j]);
			}
		}
		for(int i=0 ; i<r1 ; i++){
			for(int j=0 ; j<c2 ; j++){
				System.out.println("Ans : "+ans_Normal[i][j]);
			}
		}
	}

	
	public static void main(String[] args) {
		
		
		
		class1 c = new class1();

		c.custom_Method();
		c.print();
		
		
	}

}
