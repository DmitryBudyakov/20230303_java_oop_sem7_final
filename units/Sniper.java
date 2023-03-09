package units;

public class Sniper extends Archer {

    public Sniper(String name, int x, int y) {
        // super(name, 12, 10, 8, 10, 15, 15, 9, x, y, 32); // исходные данные
        super(name, 12, 10, 8, 10, 15, 15, 9, x, y, 32);
        this.name = name;
    }


    public String getName() {
        return name;
    }


    @Override
    public String getInfo() {
        String info = String.format("Снайпер %s hp = %d speed = %d", name, hp, speed);
        return info;
    }


    // добавление 1-го символа названия персонажа из getInfo
    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }

}
