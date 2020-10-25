/**
 * 栗林健太郎
 * 2030006
 * 2020年9月19日
 */

import java.io.*;

public class DistanceBetweenTwoPoints {
    public static void main(String[] args) throws IOException {
        int i = 0;
        String line;
        double[] r = new double[2];
        double[] theta = new double[2];
        AbstractPoint[] p = new AbstractPoint[2];
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        System.out.println("Input two points in polar coordinate system");

        while (i < 2) {
            try {
                System.out.print("r" + i + ": ");
                line = br.readLine().trim();
                r[i] = Double.parseDouble(line);
                System.out.print("theta" + i + ": ");
                line = br.readLine().trim();
                theta[i] = Double.parseDouble(line);
                p[i] = new PointPolarCoordinatesRadian(r[i], theta[i]);
                i++;
            } catch (PointException e) {
                System.err.println(e);
            } catch (NumberFormatException e) {
                System.err.println(e);
            }
        }

        double dis = p[0].distance(p[1]);
        AbstractPoint[] q = new AbstractPoint[2];

        for (int j = 0; j < 2; j++) {
            AbstractPointPolarCoordinates tmp = (AbstractPointPolarCoordinates)p[j];
            q[j] = tmp.convertToRectangularCoordinates();
        }

        System.out.println(p[0] + "->" + p[1] + ": " + dis);
        System.out.println(p[0] + ": " + q[0]);
        System.out.println(p[1] + ": " + q[1]);
    }
}
