package module2;

public class ThreeVector{
	
	double x,y,z;//represents the three components of the vector
        public ThreeVector(){}
        public ThreeVector(double a, double b, double c){
                x=a;
                y=b;
                z=c;

							}	
	static ThreeVector Null = new ThreeVector();
        /**
    	 * Produces a unit vector object in the same direction as the original vector
    	 * @return Unit Vector
    	 */
        public ThreeVector unitVector(){
		
                double ux = this.x/this.mag();
                double uy = this.y/this.mag();
                double uz = this.z/this.mag();
                ThreeVector u = new ThreeVector(ux, uy, uz);
                return u;
	
			               }

        /**
    	 * Facilitates the printing of the vector object
    	 * @return Vector as text string
    	 */
        public String toString(){
	        String vector = ("("+this.x+","+this.y+","+this.z+")");
		return vector;
				}

        /**
    	 * Returns the magnitude of the given vector
    	 * @return magnitude
    	 */
        public double mag(){
                double magnitude = Math.sqrt(x*x + y*y + z*z);
                return magnitude;
			   }

        /**
    	 * Calculates the scalar (dot) product of two given vectors
    	 * 
    	 * @param v vector 1
         * @param w vector 2
         * @return Product
    	 */
        public static double Dot(ThreeVector v, ThreeVector w){
        	double vDotw = v.x*w.x + v.y*w.y + v.z*w.z;
        	return vDotw;
							      }
        public double dot(ThreeVector w){
            double aDotb = ThreeVector.Dot(this,w);
            return aDotb;
					                    }

        /**
         * Calculates the angle between two vectors
         * @param v vector 1
         * @param w vector 2
         * @return Angle
         */
        public static double Angle(ThreeVector v, ThreeVector w){
	    		
	    
            double magA = v.mag();
            double magB = w.mag();
            double aDotb = v.dot(w);
            double cosTheta = aDotb/(magA*magB);
            double theta = Math.toDegrees(Math.acos(cosTheta));
            return theta;
		}

								
        public double angle(ThreeVector w){
                double theta = ThreeVector.Angle(this,w);
                return theta;
					  }

        /**
         * Calculates the vector (cross) product of two given vectors
         * @param v vector 1
         * @param w vector 2
         * @return Vector
         */
        public static ThreeVector Cross(ThreeVector v, ThreeVector w){
        	double a = v.y*w.z - w.y*v.z;
            double b = v.z*w.x - w.z*v.x;
            double c = v.x*w.y - w.x*v.y;
            ThreeVector x = new ThreeVector(a,b,c);
            return x;
								     } 
        public ThreeVector cross(ThreeVector w){
        	ThreeVector x = ThreeVector.Cross(this,w);
        	return x; 
					       }

        /**
         * Adds two vectors together
         * @param v vector 1
         * @param w vector 2
         * @return Vector
         */
        public static ThreeVector Add(ThreeVector v, ThreeVector w){
        	double x = v.x + w.x;
            double y = v.y + w.y;
            double z = v.z + w.z;
            ThreeVector add = new ThreeVector(x,y,z);
            return add;

								   }
        public ThreeVector add(ThreeVector w){
        	ThreeVector add = ThreeVector.Add(this,w);
        	return add;
					     } 


        public static void main(String[] args){
        	ThreeVector w  = new ThreeVector(6,3,1);
        	ThreeVector v = new ThreeVector(2,4,2);
		ThreeVector Null2 = new ThreeVector();
        	System.out.println(w.dot(v));
        	System.out.println(v.toString());
        	System.out.println(v.mag());
        	System.out.println(v.angle(w));
        	System.out.println(v.unitVector());
        	System.out.println(v.cross(w));
        	System.out.println(v.add(w));
        	System.out.println(ThreeVector.Cross(v,w));
        	System.out.println(ThreeVector.Add(v,w));
		System.out.println(Null2.unitVector());
					      }
			 }
