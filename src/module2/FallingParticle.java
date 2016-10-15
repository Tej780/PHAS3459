//package module2;

public class FallingParticle{
	//acceleration due to gravity is constant and has the same value for all
	//FallingParticle objects
	static final double g=9.81;
	double m,d;
	//I have chosen to assign an initial value of 0 to t and v as in most cases the Particle will begin moving from rest at time zero. If the user wishes to use a different value of either t or v, they may use the set() functions.
	double t = 0;
	double v = 0;
	double z;
	//I have omited an empty constructor as I want to avoid an issue with 0 mass
	public FallingParticle(double mass, double drag){
		m=mass;
		d=drag;
					 }
	public void setZ(double Z){
		z=Z;
			  }
	public double getZ(){
		return z;
			    }

	public void setV(double V){
		v=V;
			  }
	public double getV(){
		return v;
			    }

	public double getT(){
		return t;
			    }

	/**Recalculates the new acceleration, position and velocity of the particle after each step dt
	*@param deltaT
	*
	*/
	public void doTimeStep(double deltaT){
		double a = (d*v*v)/m - g;
		v = v + a*deltaT;
		z = z + v*deltaT;
					     }
	/**Simulates the motion of the particle once it is dropped. Runs while the particle is 'above the ground' and calls doTimeStep to recalculate and update the position, velocity and acceleration of the particle. Prints out the final velocity and time.
	*@param deltaT
	*/
	public void drop(double deltaT){
		while (z>0){
			this.doTimeStep(deltaT);
			t+=deltaT;
			   }
		System.out.println("The time interval is: " + deltaT + "s");
		System.out.println("Time Taken to fall: " + t + "s");
		System.out.println("Velocity at the bottom: " + v + "m/s" );
		t=0;
				       }
	// simply prints out the mass and drag of the particular Particle object
	public String toString(){
		return "An object of mass "+this.m+"kg falling in a drag coefficient of "+this.d+"kg/m";
				}

			    }

