// Арбалетчик
package units;

public class XBowman extends Archer {

    public XBowman(String name, int x, int y) {
        // super(name, 6, 3, 2, 3, 10, 10, 4, x, y, 16); // исходные данные
        super(name, 10, 8, 6, 8, 15, 15, 8, x, y, 32);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getInfo() {
        String info = String.format("Арбалетчик %s hp = %d speed = %d", name, hp, speed);
        return info;
    }

    // добавление 1-го символа названия персонажа из getInfo
    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }
    
}
