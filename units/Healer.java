package units;

import java.util.ArrayList;

public class Healer extends Man {

    protected int magic;

    public Healer(String name, int attack, int defence, int minDamage, int maxDamage, int hp, int maxHp, int speed,
            int x, int y, int magic) {
        super(name, attack, defence, minDamage, maxDamage, hp, maxHp, speed, x, y);
        this.magic = magic;
    }

    public int getMagic() {
        return magic;
    }



    @Override
    public String getInfo() {
        return "";
    }

    @Override
    public void step(ArrayList<Man> team1, ArrayList<Man> team2) {
        if (state.equals("Die")) return;
        for (Man man : team1) {
            if (man.hp < man.maxHp && !man.state.equals("Die")) {
                man.getDamage(maxDamage);
                return;
            }
        }
        // Man illed = findIll(team1);
        // illed.getDamage(minDamage);
        // magic -= 1;
    }

    // protected Man findIll(ArrayList<Man> team) {
    //     double minHp = Double.MAX_VALUE;
    //     int index = 0;
    //     for (int i = 0; i < team.size(); i++) {
    //         if (minHp > team.get(i).maxHp - team.get(i).hp) {
    //             index = i;
    //             minHp = team.get(i).maxHp - team.get(i).hp;
    //         }
    //     }
    //     return team.get(index);
    // }

}
