// Разбойник
package units;

public class Robber extends Warrior {

    public Robber(String name, int x, int y) {
        // super(name, 8, 3, 2, 4, 10, 10, 6, x, y); // исходные данные
        super(name, 8, 3, 2, 4, 10, 10, 6, x, y);
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String getInfo() {
        String info = String.format("Разбойник %s hp = %d speed = %d", name, hp, speed);
        return info;
    }

    // добавление 1-й буквы от названия персонажа из getInfo
    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }


}
