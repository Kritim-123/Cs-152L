/** @Jagat subedi
 *
 * In this program, the author will create a circle, rectangle and fancy shape.
 *
 */
public class PointTracer {
    /**
     * The method is true if it creates circle, rectangle and a butterfly.
     *
     * @param args This is main method.
     */
    public static void main(String[] args) {
        Display window = new Display(2000, 6);

        window.drawNextPoint(0, 0);
        int centerX = window.getWidth() / 2;
        // gets the Circle radius on X axis.
        int centerY = window.getHeight() / 4;
        double degAng = 300;
        // holds the value of angle in degree.
        double radius = 120;
        int i = 1;
        while (true) {
            double radAng = Math.toRadians(degAng);
            // convert degree to radians.
            radius = 70 + 120 * Math.sin(radAng);
            double x = centerX + radius * Math.cos(radAng);
            double y = centerY + radius * Math.sin(radAng);
            window.drawNextPoint((int) x, (int) y);
            degAng += .4;
            if (i < 2000) {
                i = i + 1;
            } else {
                break;
            }
        }
        // Display Window= new Display(2000, 6);
        window.drawNextPoint(5, 3);
        int width = window.getWidth();
        int height = window.getHeight();
        int j = 1 ;
        if (j <= 5) {
            int A = 80;
            int B = 60;
            while (B <= (height - 60)) {
                window.drawNextPoint(A, B);
                B = B + 4;
            }
            while (A <= (height - 80)) {
                window.drawNextPoint(A, B);
                A = A + 4;
            }
            while (B >= 60) {
                window.drawNextPoint(A, B);
                B = B - 4;
            }
            while (A >=80) {
                window.drawNextPoint(A, B);
                A = A - 4;
            }
            j = j + 1;
        }

        window.drawNextPoint(0,0);
        int centerA = window.getWidth() / 2;
        int centerB = window.getHeight() / 4;
        double Ang = 360;
        // holds the value of angle in degree.
        double radi = 160;
        while(true) {
            double radAng = Math.toRadians(Ang);
            // convert degree into radians.
            radi = 70 + 160 * Math.cos(4 * radAng);
            double x = centerA + radi * Math.cos(radAng);
            double y = centerB + radi * Math.sin(radAng);
            window.drawNextPoint( (int) x, (int) y);
            Ang += .4;
        }
    }
}

