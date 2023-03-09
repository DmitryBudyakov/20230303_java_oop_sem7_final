package units;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList<Man> team1, ArrayList<Man> team2);

    String getInfo();
}
