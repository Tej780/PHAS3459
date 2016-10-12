package module2;

public class FallingParticle{

	static final double g=9.81;
	double m,d;
	double t = 0;
	double v = 0;
	double z;

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

	public void doTimeStep(double deltaT){
		double a = (d*v*v)/m - g;
		v = v + a*deltaT;
		z = z + v*deltaT;
					     }

	public void drop(double deltaT){
		while (z>0){
			this.doTimeStep(deltaT);
			t+=deltaT;
			   }
		System.out.println("Time Taken to fall: " + t + "seconds");
		System.out.println("Velocity at the bottom: " + v + "m/s" );
		t=0;
				       }

			    }

