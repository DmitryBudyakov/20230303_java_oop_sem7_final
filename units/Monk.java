// Монах
package units;

public class Monk extends Healer {

    public Monk(String name, int x, int y) {
        // super(name, 12, 7, -4, -4, 30, 30, 5, x, y, 1); // исходные данные
        super(name, 17, 12, -5, -5, 30, 30, 9, x, y, 1);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // длбавление 1-го символа названия персонажа из getInfo
    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }

    @Override
    public String getInfo() {
        String info = String.format("Монах %s hp = %d speed = %d", name, hp, speed);
        return info;
    }

}
