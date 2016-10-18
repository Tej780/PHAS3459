//package module3;

public class TestExceptions{

	public static void main(String[] args){
		ThreeVector v1 = new ThreeVector(5,2,3);
                ThreeVector v2 = new ThreeVector(4,5,1);
                ThreeVector v3 = new ThreeVector();

		Complex c1 = new Complex(2,-1);
                Complex c2 = new Complex(-1,2);
		Complex c3 = new Complex(0,0);
               

		try{
                        //Find their unit vectors
                        System.out.println("Unit Vector 1: "+v1.unitVector().toString());
                        System.out.println("Unit Vector 2: "+v2.unitVector());
                        System.out.println("Unit Vector 3: "+v3.unitVector());
                }catch(Exception e){
                        System.out.println("Vector (0,0,0) has no defined direction, cannot create unit vector"); 
                }
                
                try{
                        System.out.println("The angle between V1 and V2 is: "+v1.angle(v2)+" rad");               
                        System.out.println(v1.angle(v3));
                }catch(Exception e){
                        System.out.println("Cannot calculate angle with vector (0,0,0)");
                }   

		try{
                        System.out.println("C1/C2 = "+Complex.divide(c1,c2));
                        System.out.println("C2/0 = "+Complex.divide(c1,Complex.ZERO));
                }catch(Exception e){
                        System.out.println("Cannot divide by 0!");
				}
                try{
                        System.out.println(c3.normalise());

                }catch(ArithmeticException e){
                        System.out.println("Cannot normalise 0!");


						}
		
		FallingParticle tej = null;
                try{
                        tej = new FallingParticle(-4,4.1);
                }catch(Exception e){
                        System.out.println("Mass and drag must be positive!");
                }
                System.out.println(tej);
                try{
                        tej = new FallingParticle(6.3,-4.1);
                }catch(Exception e){
                        System.out.println("Mass and drag must be positive!");
                }
                System.out.println(tej);

		 try{
                        tej.setZ(8);
                        tej.drop(-0.001);
                }catch(Exception e){
                        System.out.println("Time-step must be positive!");
                }

		 try{
                        tej.setZ(-8);
                        tej.drop(0.0001);
                }catch(Exception e){
                        System.out.println("Initial height must be positive!");
                }


						}
				}




