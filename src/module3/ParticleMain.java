package module3;

public class ParticleMain{
	public static void main(String[] args){
        	FallingParticle tej = new FallingParticle(6.3,4.1);
		System.out.println(tej);
		//Each time the particle is 'dropped', the position must be reset before the object can be dropped again.
                tej.setZ(8);
		tej.drop(0.5);
		tej.setZ(8);
		tej.drop(0.1);
		tej.setZ(8);
		tej.drop(0.01);
		tej.setZ(8);
		tej.drop(0.001);
		tej.setZ(8);
		tej.drop(0.0001);
		System.out.println("A smaller dt leads to a higher resolution, as such the time taken and final velocity tend towards particular values in the limit dt -> 0");
                System.out.println("\nSomething else I noticed is that, if dt is too great(i.e. the resolution is too low) then the velocity can actually become 'too negative' and the object essentially ends up 'faster than terminal velocity'. When this happens, the acceleration actually becomes positive in an attempt to compensate. This explains why dt = 0.5 results in such a wildly inaccurate number, the resolution is far too low. I don't expect this observation to warrent any extra marks, and I doubt anyone else cares much, but I found it nifty :D");         
		                  }
			 }
