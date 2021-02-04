public class NBody {
    public static double readRadius(String dataFileName) {
        In in = new In(dataFileName);
        int N = in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String dataFileName) {
        In in = new In(dataFileName);
        int N = in.readInt();
        Planet[] ps = new Planet[N];
        in.readDouble();
        for (int i = 0; i < N; i++) {
            Planet p = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
            ps[i] = p;
        }
        return ps;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("You should input 3 arguments instead: ");
            System.out.println("T, dt, filename");
            return;
        }
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        double radius = readRadius(args[2]);
        Planet[] ps = readPlanets(args[2]);

        StdDraw.enableDoubleBuffering();
        StdDraw.setScale(-radius, radius);

        for (int t = 0; t < T; t += dt) {
            Double[] xForce = new Double[ps.length];
            Double[] yForce = new Double[ps.length];

            for (int i = 0; i < ps.length; i++) {
                xForce[i] = ps[i].calcNetForceExertedByX(ps);
                yForce[i] = ps[i].calcNetForceExertedByY(ps);
            }

            StdDraw.clear();
            for (int i = 0; i < ps.length; i++) {
                ps[i].update(dt, xForce[i], yForce[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for (int i = 0; i < ps.length; i++) {
                ps[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", ps.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < ps.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    ps[i].xxPos, ps[i].yyPos, ps[i].xxVel,
                    ps[i].yyVel, ps[i].mass, ps[i].imgFileName);
        }

        return;
    }
}
