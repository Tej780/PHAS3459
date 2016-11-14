package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		double[][] s1 = {{2,0,-1},{0,2,0},{3,0,1}};
		double[][] s2 = {{-1,0,1},{0,1,0},{-3,0,1}};
		double[][] s3 = {{2,3},{3,4}};
		double[][] s4 = {{-4,3},{3,-2}};
		try{
			SquareMatrix A = new SquareMatrix(s1);
			SquareMatrix B = new SquareMatrix(s2);
			SquareMatrix C = new SquareMatrix(s3);
			SquareMatrix D = new SquareMatrix(s4);

			System.out.println(SquareMatrix.subtract(A, B));
			System.out.println(SquareMatrix.add(A, B));
			System.out.println(SquareMatrix.multiply(A, B));
			System.out.println(B.multiply(A));
			System.out.println(A.commute(B));

			SquareMatrix CD = C.multiply(D);
			System.out.println(CD.equals(SquareMatrix.identity(2)));;
		}catch(IllegalArgumentException e){
			System.out.println(e);
		}
	}
}
