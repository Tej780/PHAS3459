package module5;

public class SquareMatrix {
	public SquareMatrix(double[][] elements) throws IllegalArgumentException{
		if (elements.length != elements[0].length){
			throw new IllegalArgumentException();
		}
	}
	
	public String toString(){
		for (int i = 0; i < this.length; i++) {
		    for (int j = 0; j < cols; j++) {
		        System.out.println(matrix[i][j] + " ");
		    }
		    System.out.println();
		}
		
	
		
	}
}
