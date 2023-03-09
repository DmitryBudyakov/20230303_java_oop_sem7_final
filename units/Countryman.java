// Крестьянин
package units;

import java.util.ArrayList;

public class Countryman extends Man {

    // private String name;
    private int delivery;

    public Countryman(String name, int x, int y) {
        super(name, 1, 1, 1, 1, 3, 3, 3, x, y);
        this.name = name;
        this.delivery = 1;
    }

    public String getName() {
        return name;
    }

    public int getDelivery() {
        return delivery;
    }

    // добавляем к super.toString 1-ю букву персонажа из getInfo
    @Override
    public String toString() {
        return this.getInfo().charAt(0) + ":" + super.toString();
    }

    @Override
    public String getInfo() {
        String info = String.format("Фермер %s hp = %d speed = %d", name, hp, speed);
        return info;
    }

    // степ крестьян - если не труп то state = "Stand"
    @Override
    public void step(ArrayList<Man> team1, ArrayList<Man> team2) {
        if (!state.equals("Die"))
            state = "Stand";
    }

}
