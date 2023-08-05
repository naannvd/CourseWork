package safe;

import java.util.ArrayList;
import java.util.Arrays;

public class Punjab extends Province{
    static ArrayList<Integer> population = new ArrayList<>(Arrays.asList(20540762, 25463974, 37607423, 47292441, 73653911, 110012442));

    Punjab(){
        provinceName = "Punjab";
        sizeByKM = 205345;
        year = 1998;
        stats.setMalePopulation(38065887);
        stats.setFemalePopulation(35555402);
        stats.setSexRatio(calculateSexRatio());
        stats.setPopPerSquareKM(calculatePopDensity());
        stats.setPopulationGrowth(3.4);
    }
    public ArrayList<Integer> getPopulation(){return population;}

}
