// Колдун (Чародей)
package units;

public class Magicman extends Healer {

    public Magicman(String name, int x, int y) {
        // super(name, 17, 12, -5, -5, 30, 30, 9, x, y, 1); // исходные данные
        super(name, 17, 12, -5, -5, 30, 30, 9, x, y, 1);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    
    @Override
    public String getInfo() {
        String info = String.format("Чародей %s hp = %d speed = %d", name, hp, speed);
        return info;
    }


    // добавление 1-ой буквы от названия персонажа из getInfo
    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }


}
