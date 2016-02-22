package matrix;

import junit.framework.TestCase;

public class Normal_Method_Test extends TestCase {

	
	public void test()
	{
		int a = 2;
		
		int[][] A = new int[a][a];
		int[][] B = new int[a][a];
		
		int[][] exp = new int[2][2];
		int[][] ret = new int[2][2];
		
		A[0][0] = 1;
		A[0][1] = 2;
		A[1][0] = 3;
		A[1][1] = 4;
		
		B[0][0] = 3;
		B[0][1] = 4;
		B[1][0] = 1;
		B[1][1] = 2;
		
		exp[0][0] = 5;
		exp[0][1] = 8;
		exp[1][0] = 13;
		exp[1][1] = 20;
		
		
		class1 c = new class1(A,B);
		c.custom_Method();
		ret = c.ans_Normal;
		
		for(int i=0 ; i<2 ; i++){
			for(int j=0 ; j<2 ; j++){
				assertEquals(ret[i][j], exp[i][j]);
			}
		}
		
	}
	
}
