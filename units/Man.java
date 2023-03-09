// Обобщенный абстрактный класс
package units;

import java.util.ArrayList;

public abstract class Man implements GameInterface, Comparable<Man> {

    protected String name;
    protected int attack, defence, minDamage, maxDamage, hp, maxHp, speed;
    protected Point coords;
    protected String state;
    protected float damage;

    public Man(String name, int attack, int defence, int minDamage, int maxDamage, int hp, int maxHp,
            int speed, int x, int y) {
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.damage = Math.round(Math.abs((maxDamage + minDamage)/2));
        this.hp = hp;
        this.maxHp = maxHp;
        this.speed = speed;
        this.coords = new Point(x, y);
        this.state = "Stand";
        
    }

    public String getName(){
        return this.name;
    }

    public String getState() {
        return state;
    }


    @Override
    public void step(ArrayList<Man> team1, ArrayList<Man> team2) {
    }

    protected int findNearest(ArrayList<Man> team) {
        double min = Double.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < team.size(); i++) {
            if (min > coords.getDistance(team.get(i).coords) && !team.get(i).state.equals("Die")) {
                index = i;
                min = coords.getDistance(team.get(i).coords);
            }
        }
        return index;
    }

    protected void getDamage(float damage) {
        this.hp -= damage;
        if (hp <= 0) {
            hp = 0;
            state = "Die";
        }
        if (hp > maxHp)
            hp = maxHp;
    }


    @Override
    public int compareTo(Man o) {
        if (this.getSpeed() == o.getSpeed()) {
            return o.getHp() - this.getHp();
        }
        return o.getSpeed() - this.getSpeed();
    }

    public int getHp() {
        return hp;
    }

    private int getSpeed() {
        return speed;
    }

    public int[] getCoords() {
        return new int[] { coords.x, coords.y };
    }

    @Override
    public String toString() {
        String output = String.format("%s H:%d X:%d Y:%d Dmg:%.0f S:%d %s",
                name, hp, coords.x, coords.y, damage, speed, state);
        return output;
    }

}