package safe;

import java.util.ArrayList;
import java.util.Arrays;

public class ICT extends Province{
     static ArrayList<Integer> population = new ArrayList<>(Arrays.asList(37274, 46847, 76594, 208186, 530564, 1025290));

    ICT(){
        provinceName = "Islamabad Capital Territory";
        sizeByKM = 906;
        year = 1998;
        stats.setMalePopulation(463010);
        stats.setFemalePopulation(342225);
        stats.setSexRatio(calculateSexRatio());
        stats.setPopPerSquareKM(calculatePopDensity());
        stats.setPopulationGrowth(8.04);
    }
    public ArrayList<Integer> getPopulation(){return population;}

}
