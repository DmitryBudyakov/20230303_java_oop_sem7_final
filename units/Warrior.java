package units;

import java.util.ArrayList;

public class Warrior extends Man {

    public Warrior(String name, int attack, int defence, int minDamage, int maxDamage, int hp, int maxHp, int speed,
            int x, int y) {
        super(name, attack, defence, minDamage, maxDamage, hp, maxHp, speed, x, y);
    }

    @Override
    public String getInfo() {
        return "";
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public void step(ArrayList<Man> team1, ArrayList<Man> team2) {
        if (state.equals("Die"))
            return;
        Man victim = team2.get(findNearest(team2));
        if (victim.coords.getDistance(coords) < 2) {
            float damage = (victim.defence - attack) > 0 ? minDamage
                    : (victim.defence - attack) < 0 ? maxDamage : (minDamage + maxDamage) / 2;
            victim.getDamage(damage);
        } else {
            Point tempPoint = coords.chooseWay(victim.coords);
            if (Math.abs(tempPoint.x) < Math.abs(tempPoint.y)) {
                if (tempPoint.y > 0) {coords.y--;}
                else {coords.y++;}
            } else {
                if (tempPoint.x > 0) {coords.x--;}
                else {coords.x++;} 
            }
        }

    }

}
