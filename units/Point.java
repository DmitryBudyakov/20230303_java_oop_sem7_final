package units;

/**
 * Point
 */
public class Point {

    protected int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Рассчет расстояния до противника
     * @param opposit
     * @return
     */
    protected double getDistance(Point opposit) {
        return Math.sqrt(Math.pow(x - opposit.x, 2) + Math.pow(y - opposit.y, 2));
    }

    protected Point chooseWay(Point opposit) {
        return new Point(x - opposit.x, y - opposit.y);
    }

}