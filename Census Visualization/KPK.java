package safe;

import java.util.ArrayList;
import java.util.Arrays;

public class KPK extends Province{
     static ArrayList<Integer> population = new ArrayList<>(Arrays.asList(4556545, 5730991, 8388551, 11061328, 17743645, 30523371));

    KPK(){
        provinceName = "Khyber Pakhtunkhwa";
        sizeByKM = 101741;
        year = 1998;
        stats.setMalePopulation(9111362);
        stats.setFemalePopulation(8632283);
        stats.setSexRatio(calculateSexRatio());
        stats.setPopPerSquareKM(calculatePopDensity());
        stats.setPopulationGrowth(3.55);
    }

    public ArrayList<Integer> getPopulation(){return population;}
}
