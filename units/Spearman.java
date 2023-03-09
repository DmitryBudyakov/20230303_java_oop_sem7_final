// Копейщик
package units;

public class Spearman extends Warrior {

    public Spearman(String name, int x, int y) {
        // super(name, 4, 5, 1, 3, 10, 10, 4, x, y); // исходные данные
        super(name, 8, 5, 2, 4, 10, 10, 4, x, y);
        this.name = name;
    }

    
    public String getName() {
        return name;
    }


    @Override
    public String getInfo() {
        String info = String.format("Копейщик %s hp = %d speed = %d", name, hp, speed);
        return info;
    }


    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }
}
