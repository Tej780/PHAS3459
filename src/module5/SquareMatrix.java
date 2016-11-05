package module5;

public class SquareMatrix{

	int length;
	double[][] el;

	public SquareMatrix(double[][] elements) throws IllegalArgumentException{
		if(elements.length != elements[0].length){
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

	public SquareMatrix(int i) throws IllegalArgumentException{
		this.length= i;
		el = new double[i][i];	
	}


	public String toString(){
		String matrix = "";
		for(int i=0;i<this.length;i++){
			for(int j=0;j<this.length;j++){
				matrix = matrix + el[i][j]+"\t";
			}
			matrix = matrix + "\n";
		}
		return matrix;
	}




	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2) throws IllegalArgumentException{
		SquareMatrix sm = new SquareMatrix(sm1.length);
		if(sm1.length == sm2.length ){	
			for (int i=0;i<sm1.length;i++){					
				for(int j=0;j<sm1.length;j++){
					sm.el[i][j] = sm1.el[i][j] + sm2.el[i][j];	
				}
			}
		}else{
			throw new IllegalArgumentException();

		}
		return sm;
	}

	public SquareMatrix add(SquareMatrix sm2) throws IllegalArgumentException{
		SquareMatrix sm3 = new SquareMatrix(this.length);
		if(this.length == sm2.length ){
			sm3 = SquareMatrix.add(this, sm2);
		}else{
			throw new IllegalArgumentException();
		}
		return sm3;
	} 

	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2) throws IllegalArgumentException{
		SquareMatrix sm = new SquareMatrix(sm1.length);
		if(sm1.length == sm2.length ){	
			for (int i=0;i<sm1.length;i++){					
				for(int j=0;j<sm1.length;j++){
					sm.el[i][j] = sm1.el[i][j] - sm2.el[i][j];	
				}
			}
		}else{
			throw new IllegalArgumentException();

		}
		return sm;
	}

	public SquareMatrix subtract(SquareMatrix sm2) throws IllegalArgumentException{
		SquareMatrix sm3 = new SquareMatrix(this.length);
		if(this.length == sm2.length ){
			sm3 = SquareMatrix.subtract(this, sm2);
		}else{
			throw new IllegalArgumentException();
		}
		return sm3;
	} 

	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2) throws IllegalArgumentException{
		SquareMatrix sm = new SquareMatrix(sm1.length);
		if(sm1.length == sm2.length ){	
			for (int i=0;i<sm1.length;i++){					
				for(int j=0;j<sm1.length;j++){
					for(int k=0;k<sm1.length;k++){
						sm.el[i][j] += sm1.el[i][k] * sm2.el[k][j];
					}
				}
			}
		}else{
			throw new IllegalArgumentException();

		}
		return sm;
	}

	public SquareMatrix multiply(SquareMatrix sm2){
		SquareMatrix sm3 = new SquareMatrix(this.length);
		if(this.length == sm2.length ){
			for (int i=0;i<this.length;i++){					
				for(int j=0;j<this.length;j++){
					for(int k=0;k<this.length;k++){
						sm3.el[i][j] += this.el[i][k] * sm2.el[k][j];
					}
				}
			}
		}else{
			throw new IllegalArgumentException();
		}
		return sm3;
	} 


	public static boolean equals(SquareMatrix A,SquareMatrix B) {
		if (A.length != B.length){
			throw new RuntimeException("Matricies have different dimensions.");
		}
		for (int i = 0; i < A.length; i++){
			for (int j = 0; j < A.length; j++){
				if (A.el[i][j] != B.el[i][j]){
					return false;
				}
			}	
		}
		return true;
	}

	public boolean equals(SquareMatrix s2){
		return SquareMatrix.equals(this, s2);
	}

	public static SquareMatrix identity(int n){
		SquareMatrix I = new SquareMatrix(n);
		for(int i = 0;i<n;i++){
			I.el[i][i]=1;
		}
		return I;
	}

	public static SquareMatrix commute(SquareMatrix s1, SquareMatrix s2){
		SquareMatrix s3 = SquareMatrix.subtract(s1.multiply(s2),s2.multiply(s1));
		return s3;
	}

	public SquareMatrix commute(SquareMatrix s2){
		SquareMatrix s3 = SquareMatrix.commute(this, s2);
		return s3;
	}

}

