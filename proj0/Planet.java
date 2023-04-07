public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet (double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet (Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance (Planet p){
        double distance = 0;
        double dX = this.xxPos - p.xxPos;
        double dY = this.yyPos - p.yyPos;
        distance = Math.sqrt(dX * dX + dY * dY);
        return distance;
    }

    public double calcForceExertedBy (Planet p) {
        double force = 0;
        double dis = this.calcDistance(p);
        force = G * this.mass * p.mass / (dis * dis);
        return force;
    }

    public double calcForceExertedByX (Planet p) {
        double forceX = 0;
        double dX = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double f = this.calcForceExertedBy(p);
        forceX = f * dX / r;
        return forceX;
    }

    public double calcForceExertedByY (Planet p) {
        double forceY = 0;
        double dY = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double f = this.calcForceExertedBy(p);
        forceY = f * dY / r;
        return forceY;
    }

    public double calcNetForceExertedByX (Planet[] p) {
        double forceX = 0;
        for (int i = 0; i < p.length; i ++) {
            if (!this.equals(p[i])) {
                forceX += this.calcForceExertedByX(p[i]);
            }
        }
        return forceX;
    }

    public double calcNetForceExertedByY (Planet[] p) {
        double forceY = 0;
        for (int i = 0; i < p.length; i ++) {
            if (!this.equals(p[i])) {
                forceY += this.calcForceExertedByY(p[i]);
            }
        }
        return forceY;
    }

    public void update (double dt, double fX, double fY) {
        double aX = fX / mass;
        double aY = fY / mass;
        xxVel = xxVel + dt * aX;
        yyVel = yyVel + dt * aY;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw () {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }
}