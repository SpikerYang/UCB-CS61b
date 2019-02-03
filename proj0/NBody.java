public class NBody {
	public static double readRadius(String file){
		In i = new In(file);
		i.readDouble();
		return i.readDouble();
	}

	public static Planet[] readPlanets(String file){
		In i = new In(file);
		i.readDouble();
		i.readDouble();
		Planet[] p = new Planet[5];
		for (int k = 0; k < 5; k += 1){
			p[k] = new Planet(i.readDouble(), i.readDouble(), i.readDouble(), i.readDouble(), i.readDouble(), i.readString());
		}
		return p;
	}

	public static void main(String args[]){
		double T = Double.valueOf(args[0]);
		double dt = Double.valueOf(args[1]);
		String filename = args[2];
		double Radius = readRadius(filename);
		Planet p[] = readPlanets(filename);   /* Collecting all needed input */
                
		StdAudio.play("./audio/2001.mid");
		StdDraw.setScale(-Radius, Radius);
                        StdDraw.clear();
                        StdDraw.picture(0, 0, "./images/starfield.jpg", 2*Radius, 2*Radius);
                        for (int k = 0; k < p.length; k += 1){
                                p[k].draw();
                        }
                        StdDraw.show(10);


		for (double time = 0; time < T; time += dt){
			double[] xForces = new double[p.length];
			double[] yForces = new double[p.length];
			for (int k = 0; k < p.length; k += 1){
				xForces[k] = p[k].calcNetForceExertedByX(p);
				yForces[k] = p[k].calcNetForceExertedByY(p);
			}
			for (int k = 0; k <p.length; k += 1){
				p[k].update(dt, xForces[k], yForces[k]);
			}
			StdDraw.setScale(-Radius, Radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, "./images/starfield.jpg", 2*Radius, 2*Radius);
               		for (int k = 0; k < p.length; k += 1){
				p[k].draw();
			}
			StdDraw.show(10);
		}
	}
}
