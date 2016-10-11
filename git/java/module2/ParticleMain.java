public class ParticleMain{
	public static void main(String[] args){
        	FallingParticle tej = new FallingParticle(6.3,4.1);
                tej.setZ(8);
		tej.setV(0);
		tej.drop(0.5);
		tej.setZ(8);
		tej.setV(0);
		tej.drop(0.1);
		tej.setZ(8);
		tej.setV(0);
		tej.drop(0.01);
		tej.setZ(8);
		tej.setV(0);
		tej.drop(0.001);
		tej.setZ(8);
		tej.setV(0);
		tej.drop(0.0001);
		System.out.println("A smaller dt leads to a higher resolution, as such the time taken and final velocity tend towards particular values in the limit dt -> 0");
                                              }		



					      	

			 }
