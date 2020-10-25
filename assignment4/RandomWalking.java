/**
 * 栗林健太郎
 * 2030006
 * 2020年9月19日
 */

public final class RandomWalking {
    private final Point goal;
    private final int maxSteps;
    private Point walker;

    public RandomWalking(double gx, double gy, double wx, double wy, int max) {
        goal = new Point(gx, gy);
        walker = new Point(wx, wy);
        maxSteps = max;
    }

    public void startWalking() {
        int steps = 0;

        while (true) {
            System.out.println("walker: " + walker);
            if (goal.distance(walker) < 1.0) {
                System.out.println("Got to goal in `maxSteps`");
                break;
            }
            if (steps > maxSteps) {
                System.out.println("Didn't got to goal in `maxSteps`");
                break;
            }
            double dx = Math.random();
            double dy = Math.random();
            dx = Math.random() > 0.2 ? -dx : dx;
            dy = Math.random() > 0.2 ? -dy : dy;
            walker.move(dx, dy);
            steps++;
        }
    }
}
