public class Planet {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    final static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.pow(Math.pow(xxPos - p.xxPos, 2) + Math.pow(yyPos - p.yyPos, 2), 0.5);
    }

    public double calcForceExertedBy(Planet p) {
        return G * mass * p.mass / Math.pow(calcDistance(p), 2);
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * (p.xxPos - xxPos) / calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (p.yyPos - yyPos) / calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] ps) {
        double sum = 0;
        for (Planet p : ps) {
            if (this.equals(p)) {
                continue;
            }
            sum += calcForceExertedByX(p);
        }
        return sum;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
        double sum = 0;
        for (Planet p : ps) {
            if (this.equals(p)) {
                continue;
            }
            sum += calcForceExertedByY(p);
        }
        return sum;
    }

    public void update(double t, double xxF, double yyF)  {
        xxVel+=t*xxF/mass;
        yyVel+=t*yyF/mass;
        xxPos+=t*xxVel;
        yyPos+=t*yyVel;
    }

    public void draw()  {
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
