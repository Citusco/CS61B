public class NBody{
	public static double readRadius(String path){
		In in = new In(path);
		int number = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String path){
		In in = new In(path);
		int size = in.readInt();
		double radius = in.readDouble();
		Planet[] planet = new Planet[size];
		for(int i = 0; i < size; i++){
			planet[i] = new Planet(0,0,0,0,0,"");
			planet[i].xxPos = in.readDouble();
			planet[i].yyPos = in.readDouble();
			planet[i].xxVel = in.readDouble();
			planet[i].yyVel = in.readDouble();
			planet[i].mass = in.readDouble();
			planet[i].imgFileName = in.readString();
		}
		return planet;
	}
	public static void main (String[] args){
		//input t dt filename
		String sT = args[0];
		String sdT = args[1];
		String filename = args[2];
		double t = Double.parseDouble(sT);
		double dT = Double.parseDouble(sdT);
		//read radius and bodies
		double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);
		for (double tNow = 0; tNow < t; tNow = tNow + dT){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			//calculate
			for(int j = 0; j < planets.length; j++){
				xForces[j] = planets[j].calcNetForceExertedByX(planets);
				yForces[j] = planets[j].calcNetForceExertedByY(planets);
			}
			//update
			for(int k = 0; k < planets.length; k++){
				planets[k].update(dT, xForces[k], yForces[k]);
			}
			//draw background
			String imageToDraw = "./images/starfield.jpg";
			StdDraw.enableDoubleBuffering();	//to prevent flicering in the animation.
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);
			//draw bodies
			for(int i = 0; i < planets.length; i++){
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for(int i = 0; i < planets.length; i++){
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
						  planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
						  planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
		}

	}
}