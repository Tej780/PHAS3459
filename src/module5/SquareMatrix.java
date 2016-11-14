package module5;

public class SquareMatrix{
	//useful for methods
	int length;
	//elements within the matrix
	double[][] el;

	//make matrix with given array of doubles
	public SquareMatrix(double[][] elements) throws IllegalArgumentException{
		if(elements.length != elements[0].length){//insures array has correct dimension
			throw new IllegalArgumentException("The matrix must be square!");
		}
		length = elements.length;
		el = new double[length][length];
		for(int i=0;i<length;i++){
			for(int j=0;j<length;j++){
				el[i][j] = elements [i][j];
			}
		}
	}

	//create empty matrix with dimensions specified. Elements must be inserted manually
	public SquareMatrix(int i) throws IllegalArgumentException{
		if (i>0){
			this.length= i;
			el = new double[i][i];	
		}else{
			throw new IllegalArgumentException("Matrix dimensions must be positive integer value");
		}
	}

	public String toString(){
		String matrix = "\n";
		for(int i=0;i<this.length;i++){
			for(int j=0;j<this.length;j++){
				matrix = matrix + el[i][j]+"\t";
			}
			matrix = matrix + "\n";//just to add some padding
		}
		return matrix;
	}


	/**
	 * Add matrix A to matrix B (A+B=C)
	 * @param A, matrix A
	 * @param B, matrix B
	 * @return C, matrix C
	 * @throws IllegalArgumentException
	 */
	public static SquareMatrix add(SquareMatrix A, SquareMatrix B) throws IllegalArgumentException{
		SquareMatrix C = new SquareMatrix(A.length);
		if(A.length == B.length ){//ensures matrices have same dimensions, else throw exception
			for (int i=0;i<A.length;i++){					
				for(int j=0;j<A.length;j++){
					C.el[i][j] = A.el[i][j] + B.el[i][j];//add matching elements
				}
			}
		}else{
			throw new IllegalArgumentException("Matrices must have same dimensions!");

		}
		return C;
	}

	public SquareMatrix add(SquareMatrix B) throws IllegalArgumentException{
		return SquareMatrix.add(this, B);
	} 

	/**
	 * subtract matrix B from matrix A (A-B=C)
	 * @param A, matrix A
	 * @param B, matrix B
	 * @return C, matrix C
	 * @throws IllegalArgumentException
	 */
	public static SquareMatrix subtract(SquareMatrix A, SquareMatrix B) throws IllegalArgumentException{
		SquareMatrix C = new SquareMatrix(A.length);
		if(A.length == B.length ){//ensures matrices have same dimensions, else throw exception
			for (int i=0;i<A.length;i++){					
				for(int j=0;j<A.length;j++){
					C.el[i][j] = A.el[i][j] - B.el[i][j];//subtract matching elements
				}
			}
		}else{
			throw new IllegalArgumentException("Matrices must have same dimensions!");

		}
		return C;
	}

	public SquareMatrix subtract(SquareMatrix B) throws IllegalArgumentException{
		return SquareMatrix.subtract(this, B);
	} 

	/**
	 * multiply matrix A with matrix B (AB=C)
	 * @param A, matrix A
	 * @param B, matrix B
	 * @return C, matrix C
	 * @throws IllegalArgumentException
	 */
	public static SquareMatrix multiply(SquareMatrix A, SquareMatrix B) throws IllegalArgumentException{
		SquareMatrix C = new SquareMatrix(A.length);
		if(A.length == B.length ){//ensures matrices have same dimensions, else throw exception
			for (int i=0;i<A.length;i++){					
				for(int j=0;j<A.length;j++){
					for(int k=0;k<A.length;k++){
						C.el[i][j] += A.el[i][k] * B.el[k][j];
					}
				}
			}
		}else{
			throw new IllegalArgumentException("The square matrices must have same dimensions!");

		}
		return C;
	}

	public SquareMatrix multiply(SquareMatrix B){
		return SquareMatrix.multiply(this, B);
	} 


	/**
	 * Checks if two matrices are equal
	 * @param A
	 * @param B
	 * @return boolean
	 * @throws IllegalArgumentException
	 */
	public static boolean equals(SquareMatrix A,SquareMatrix B) throws IllegalArgumentException {
		if (A.length != B.length){//ensures matrices have same dimensions, else throw exception
			throw new IllegalArgumentException("Matricies have different dimensions.");
		}
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j < A.length; j++){
				if (A.el[i][j] != B.el[i][j]){
					return false;//only runs if ANY corresponding elements are not equal
				}
			}	
		}
		return true;
	}

	public boolean equals(SquareMatrix B){
		return SquareMatrix.equals(this, B);
	}

	//produce identity matrix with specified dimensions
	public static SquareMatrix identity(int n){
		SquareMatrix I = new SquareMatrix(n);
		for(int i = 0;i<n;i++){
			I.el[i][i]=1;
		}
		return I;
	}

	/**
	 * Finds the commutator for two given matrices
	 * @param A
	 * @param B
	 * @return AB-BA
	 * @throws IllegalArgumentException
	 */
	public static SquareMatrix commute(SquareMatrix A, SquareMatrix B) throws IllegalArgumentException{
		if (A.length != B.length){//ensures matrices have same dimensions, else throw exception
			throw new IllegalArgumentException("Matricies have different dimensions.");
		}
		SquareMatrix C = SquareMatrix.subtract(A.multiply(B),B.multiply(A));
		return C;
	}

	public SquareMatrix commute(SquareMatrix B){
		return SquareMatrix.commute(this, B);
	}
}

