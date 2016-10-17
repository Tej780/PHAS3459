package module3;

public class FallingParticle{

	//acceleration due to gravity is constant and has the same value for all FallingParticle objects
	private static final double g=9.81;
	private double m,d;
	//I have chosen to assign an initial value of 0 to t and v as in most cases the Particle will begin moving from rest at time zero.
	// If the user wishes to use a different value of either t or v, they may use the set() functions.
	private double t = 0;
	private double v = 0;
	private double z;

	//I have omitted an empty constructor as I want to avoid an issue with 0 mass

	public FallingParticle(double mass, double drag) throws IllegalArgumentException{

			if(mass <=0){//avoids unphysical systems with negative masses
				throw new IllegalArgumentException();
			}
			m=mass;
			d=drag;
	}


	/**
	 *Sets the initial height of the Particle
	 *@param Z initial height
	 */
	public void setZ(double Z) throws Exception{
		
			if(Z<=0){//prevents the particle from starting 'beneath the ground'
				throw new Exception();
			}
			z=Z;
	}

	/**
	 *Returns the current position of the Particle
	 *@return position
	 */
	public double getZ(){
		return z;
	}

	/**
	 *Sets the velocity of the Particle
	 *@param V velocity
	 */
	public void setV(double V){
		v=V;
	}
	/**
	 *Returns the current velocity of the Particle
	 *@return velocity
	 */
	public double getV(){
		return v;
	}

	/**
	 *Returns the current time
	 */
	public double getT(){
		return t;
	}

	/**
	 *Recalculates the new acceleration, position and velocity of the particle after a time step dt
	 *@param deltaT
	 *
	 */
	public void doTimeStep(double deltaT){
		double a = 0;
		if(v<=0){//this ensures that the acceleration due to drag always opposes the direction of motion
			a = (d*v*v)/m - g;
		}else if(v>0){
			a = -(d*v*v)/m - g;
		}
		v = v + a*deltaT;
		z = z + v*deltaT;

	}
	/**
	 *Simulates the motion of the particle once it is dropped.
	 *Runs while the particle is 'above the ground' and calls doTimeStep to recalculate and update the position, velocity and acceleration of the particle. Prints out the final velocity and time.
	 *@param deltaT
	 */
	public void drop(double deltaT){
		while (z>0){
			this.doTimeStep(deltaT);
			t+=deltaT;
		}
		System.out.println("Time interval dt: " + deltaT + "s" );
		System.out.println("Time Taken to fall: " + t + "s");
		System.out.println("Velocity at the bottom: " + v + "m/s" );
		//resets the value of t and v so the same object can be re-dropped
		v=0;
		t=0;
	}

	// simply prints out the mass and drag of the particular Particle object
	public String toString(){
		return "An object of mass "+this.m+"kg falling in a drag coefficient of "+this.d+"kg/m";
	}

	/*	
		public static void main(String[] args){
		FallingParticle n = new FallingParticle(5,5);
		n.setZ(8);
		n.drop(0.01);
		n.setZ(-20);
		FallingParticle g = new FallingParticle(-5,5);
		System.out.println(g.d);
						}
	 */
}

