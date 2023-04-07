public class NBody {
    public static String backGround = "./images/starfield.jpg";
    public static double readRadius (String path) {
        In in = new In (path);
        // Skip the first parameter in the file.
        in.readDouble();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets (String path) {
        In in = new In (path);
        // Read the first parameter as the planet number.
        int planetNum = in.readInt();
        in.readDouble();
        // Create an array of planet instances.
        Planet[] planets = new Planet[planetNum];
        for (int i = 0; i < planetNum; i ++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            planets [i] = new Planet (xxPos, yyPos, xxVel, yyVel, mass, img);
        }
        return planets;
    }
    public static void main (String[] args) {
        /* Read parameters from command line arguments*/
        double T = Double.parseDouble(args[0]);
        double dT = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);

        /* Read planets */
        Planet[] planets = readPlanets(filename);
        
        /* Draw the background */
        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);
        StdDraw.picture(0, 0, backGround);
        
        /* Draw planets */
        for (int i = 0; i < planets.length; i ++) {
            planets[i].draw();
        }
        StdDraw.show();

        /* Main loop of the simulator */
        double time = 0;
        while (time < T) {
            /* Initialize forces arrays for x and y axis. */
            double[] xForces = new double[planets.length];
            double[] yForces = new double[planets.length];
            /* Iteratively calculate x and y forces for every planet */
            for (int i = 0; i < planets.length; i ++) {
                /* Calculate forces between ith and jth planets and add them together for ith planets. */
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            /* Update all planets and redraw them all. */
            for (int i = 0; i < planets.length; i ++) {
                planets[i].update(dT, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, backGround);
            for (int i = 0; i < planets.length; i ++) {
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dT;
        }

        /* Printing the universe */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i ++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
}
