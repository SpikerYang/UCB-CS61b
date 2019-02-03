public class Planet {
	public double xxPos; /* Its current x position */
	public double yyPos; /* Its current y position */
	public double xxVel; /* Its current velocity in the x direction */
	public double yyVel; /* Its current velocity in the y direction */
	public double mass; /* Its mass */
	public String imgFileName; /* The name of an image in the images directory that depicts the planet */
        
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	
	public Planet(Planet p){
		xxPos = p.xxPos;
                yyPos = p.yyPos;
                xxVel = p.xxVel;
                yyVel = p.yyVel;
                mass = p.mass;
                imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt(Math.pow((xxPos-p.xxPos),2) + Math.pow((yyPos-p.yyPos),2));
	}
	public double calcForceExertedBy(Planet p){
		double d = calcDistance(p);
		return 6.67e-11 * mass * p.mass /d /d;
	}
	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
	}
	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
	}
	public double calcNetForceExertedByX(Planet[] p){
		double F = 0;
		for(int i = 0; i < p.length; i += 1){
			if (!this.equals(p[i])) F += calcForceExertedByX(p[i]);
		}
                return F;
	}
        public double calcNetForceExertedByY(Planet[] p){
                double F = 0;
                for(int i = 0; i < p.length; i += 1){
                        if (!this.equals(p[i])) F += calcForceExertedByY(p[i]);
                }
                return F;
        }
	public void update(double dt, double fX, double fY){
		double aX = fX / mass;
		double aY = fY / mass;
		xxVel += aX * dt;
		yyVel += aY * dt;
		xxPos += xxVel * dt;
		yyPos += yyVel * dt;
	}
	public void draw(){
		StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
	}

}
