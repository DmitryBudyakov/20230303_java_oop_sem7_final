import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import units.Countryman;
import units.Magicman;
import units.Man;
import units.Monk;
import units.Names;
import units.Robber;
import units.Sniper;
import units.Spearman;
import units.XBowman;

/**
 * Main
 */
public class Main {

    public static final int N = 10; // количество персонажей в каждой команде
    public static ArrayList<Man> darks = new ArrayList<>();
    public static ArrayList<Man> lights = new ArrayList<>();
    public static ArrayList<Man> list = new ArrayList<>();

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Press Enter to begin.");
        in.nextLine();

        darks = createTeam(0, 10); // создание команды 1
        lights = createTeam(1, 1); // создание команды 2

        // добавление команд в общий список
        for (Man man : lights) {
            list.add(man);
        }
        for (Man man : darks) {
            list.add(man);
        }

        // сортировка полного списка - вар.2 - через compateTo в классе Man
        Collections.sort(list);

        while (true) {
            int deadLights = 0;
            int deadDarks = 0;
            View.view();
            in.nextLine();

            // проверка количества убитых
            for (Man man : lights) {
                if (man.getHp() == 0)
                    deadLights++;
            }
            System.out.printf("Dead Lights: %d\n", deadLights);
            for (Man man : darks) {
                if (man.getHp() == 0)
                    deadDarks++;
            }
            System.out.printf("Dead Darks: %d\n", deadDarks);

            // окончание игры, если у одной из команд все убитые
            if (deadLights == N) {
                System.out.println("Game is over. Green(darks) are winner.");
                break;
            }
            if (deadDarks == N) {
                System.out.println("Game is over. Blue(lights) are winner.");
                break;
            }

            for (Man man : list) {
                if (lights.contains(man))
                    man.step(lights, darks);
                else
                    man.step(darks, lights);
            }
        }
    }

    /**
     * Выбор случайного имени из класса enum Names
     * 
     * @return
     */
    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    /**
     * @param teamKind - тип персонажей в команде
     *                 0 - крестьянин, разбойник, снайпер и колдун
     *                 1 - крестьянин, копейщик, арбалетчик, монах
     * @return
     */
    private static ArrayList<Man> createTeam(int teamKind, int posY) {
        ArrayList<Man> team = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (teamKind == 0) {
                switch (new Random().nextInt(4)) {
                    case 0:
                        team.add(new Countryman(getName(), i + 1, posY));
                        break;
                    case 1:
                        team.add(new Magicman(getName(), i + 1, posY));
                        break;
                    case 2:
                        team.add(new Robber(getName(), i + 1, posY));
                        break;
                    case 3:
                        team.add(new Sniper(getName(), i + 1, posY));
                        break;
                }
            } else if (teamKind == 1) {
                switch (new Random().nextInt(4)) {
                    case 0:
                        team.add(new Countryman(getName(), i + 1, posY));
                        break;
                    case 1:
                        team.add(new Monk(getName(), i + 1, posY));
                        break;
                    case 2:
                        team.add(new Spearman(getName(), i + 1, posY));
                        break;
                    case 3:
                        team.add(new XBowman(getName(), i + 1, posY));
                        break;
                }
            }
        }
        return team;
    }

}