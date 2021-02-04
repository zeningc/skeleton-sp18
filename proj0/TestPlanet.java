
/**
 *  Tests Planet
 */
public class TestPlanet {

    /**
     *  Tests Planet.
     */
    public static void main(String[] args) {
        checkPlanet();
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Checks the Planet class to make sure calcDistance works.
     */
    private static void checkPlanet() {
        System.out.println("Checking calcDistance...");

        Planet p1 = new Planet(1e12, 2e11, 3.0, 4.0, 2e30, "jupiter.gif");
        Planet p2 = new Planet(2.3e12, 9.5e11, 3.0, 4.0, 6e26, "jupiter.gif");

        checkEquals(p1.calcForceExertedBy(p2), 3.55e22, "calcForceExertedBy()", 0.01);
    }
}
