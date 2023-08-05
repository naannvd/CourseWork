package safe;

import java.util.ArrayList;
import java.util.Arrays;

public class Balochistan extends Province{
     static ArrayList<Integer> population = new ArrayList<>(Arrays.asList(1167167, 1353484, 2428678, 4332376, 6565885, 12344408));

    Balochistan(){
        provinceName = "Balochistan";
        sizeByKM = 347190;
        year = 1998;
        stats.setMalePopulation(3742537);
        stats.setFemalePopulation(2823318);
        stats.setSexRatio(calculateSexRatio());
        stats.setPopPerSquareKM(calculatePopDensity());
        stats.setPopulationGrowth(3.03);
    }
    public ArrayList<Integer> getPopulation(){return population;}

}
