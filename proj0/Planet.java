public class Planet{
	//current x position
	public double xxPos;
	//current y positon
	public double yyPos;
	//current velocity in the x direct
	public double xxVel;
	//current velocity in the y direct
	public double yyVel;
	//its mass
	public double mass;
	//image that depicts the body
	public String imgFileName;
	//gravitational constant
	private static final double G = 6.67e-11;
	//parameter type
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	//copy type
	public Planet(Planet b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;
	}
	//non-parameter type
/*	public Planet(){
		this.xxPos = 0;
		this.yyPos = 0;
		this.xxVel = 0;
		this.yyVel = 0;
		this.mass = 0;
		this.imgFileName = "";
	}*/
	//calcDistance
	public double calcDistance(Planet rocinante){
		double distanceSq = (this.xxPos - rocinante.xxPos) * (this.xxPos - rocinante.xxPos) + (this.yyPos - rocinante.yyPos) * (this.yyPos - rocinante.yyPos);
		double distance = Math.sqrt(distanceSq);
		return distance;
	}
	public double calcForceExertedBy(Planet rocinante){
		double distance = calcDistance(rocinante);
		double force = G * this.mass * rocinante.mass / (distance * distance);
		return force;
	}
	public double calcForceExertedByX(Planet rocinante){
		double force = calcForceExertedBy(rocinante);
		double dx = rocinante.xxPos - this.xxPos;
		double distance = calcDistance(rocinante);
		double fx = force * dx / distance;
		return fx;
	}
	public double calcForceExertedByY(Planet rocinante){
		double force = calcForceExertedBy(rocinante);
		double dy = rocinante.yyPos - this.yyPos;
		double distance = calcDistance(rocinante);
		double fy = force * dy / distance;
		return fy;
	}
	public double calcNetForceExertedByX(Planet[] allBodys){
		double fSum = 0;
		double fTemp = 0;
		for (int i = 0 ; i < allBodys.length; i += 1){
			if (this.xxPos == allBodys[i].xxPos && this.yyPos == allBodys[i].yyPos && this.mass == allBodys[i].mass){
				continue;
			}else{
				fTemp = calcForceExertedByX(allBodys[i]);
				fSum = fSum + fTemp;
			}
			
		}
		return fSum;
	}
	public double calcNetForceExertedByY(Planet[] allBodys){
		double fSum = 0;
		double fTemp = 0;
		for (int i = 0 ; i < allBodys.length; i += 1){
			if (this.xxPos == allBodys[i].xxPos && this.yyPos == allBodys[i].yyPos && this.mass == allBodys[i].mass){
				continue;
			}else{
				fTemp = calcForceExertedByY(allBodys[i]);
				fSum = fSum + fTemp;
			}
			
		}
		return fSum;
	}
	public void update(double dt, double fX, double fY){
		double aX = fX / this.mass;
		double aY = fY / this.mass;
		double vNewX = this.xxVel + (dt * aX);
		double vNewY = this.yyVel + (dt * aY);
		double pNewX = this.xxPos + (dt * vNewX);
		double pNewY = this.yyPos + (dt * vNewY);
		this.xxPos = pNewX;
		this.yyPos = pNewY;
		this.xxVel = vNewX;
		this.yyVel = vNewY;
	}
	public void draw(){
		StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
	}
}