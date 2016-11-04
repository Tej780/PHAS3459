//package module5;

public class TestSquareMatrix {

	public static void main(String[] args) {
		SquareMatrix s1 = new SquareMatrix(2);
		for(int i=0;i<s1.length;i++){
			for(int j=0;j<s1.length;j++){
				s1.el[i][j] = 2*(i+1)*(j+1);
			}
		}
		SquareMatrix s2 = new SquareMatrix(2);
		for(int i=0;i<s2.length;i++){
			for(int j=0;j<s2.length;j++){
				s2.el[i][j] =3*(i+1)*(j+1);
			}
		}
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(SquareMatrix.subtract(s1, s2));
		System.out.println(SquareMatrix.multiply(s1, s2));
		System.out.println(SquareMatrix.equals(s1,s2));
		
		
		
		
	}

}
