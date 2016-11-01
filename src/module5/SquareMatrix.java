
package module5;

public class SquareMatrix{
	
	public SquareMatrix[][](double[][] elements) throws IllegalArgumentException{
		if(elements.length != elements[0].length){
			throw new IllegalArgumentException();
		}
				}

	public static SquareMatrix empty(SquareMatrix sm){
		for(int i=0;i<sm.length;i++){
			for(int j=0;j<sm[0].length;j++){
				this[i][j]=0;
						}
			}
					}

	public String toString(){
		String matrix = "";
		for(int i=0;i<this.length;i++){
			for(int j=0;j<this.length;j++){
				matrix = matrix + this[i][j]+"\t";
			}
			matrix = matrix + "\n";
			}
					}




	public static SquareMatrix add(SquareMatrix sm1, SquareMatrix sm2){
		if(sm1.length == sm2.length && sm1[0].length==sm2[0].length){
			SquareMatrix sm = sm1.empty;
			for (int i=0;i<elements.length;i++){					
				for(int j=0;j<elements.length;j++){
					sm[i][j]=sm1[i][j]+sm2[i][j];	
									}
								}
					}
									}
	public static SquareMatrix subtract(SquareMatrix sm1, SquareMatrix sm2){
		if(sm1.length == sm2.length && sm1[0].length==sm2[0].length){
                        SquareMatrix sm = sm1.empty;
                        for (int i=0;i<elements.length;i++){
                        	for(int j=0;j<elements.length;j++){
                                        sm[i][j]=sm1[i][j]-sm2[i][j];

								}
							}
									}
										}
	public static SquareMatrix multiply(SquareMatrix sm1, SquareMatrix sm2){
		if(sm1.length == sm2.length && sm1[0].length==sm2[0].length){
                        SquareMatrix sm = sm1.empty;
                        for (int i=0;i<elements.length;i++){                        
                                for(int j=0;j<elements.length;j++){
                                        sm[i][j]=sm1[i][j]+sm2[i][j];
		


					}
							}
									}
										}
}

