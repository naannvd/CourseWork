package safe;

import java.util.ArrayList;
import java.util.Arrays;

public class Sindh extends Province{
    static ArrayList<Integer> population = new ArrayList<>(Arrays.asList(6047748, 8367065, 14155909, 19028666, 30439893, 47886051));
    Sindh(){
        provinceName = "Sindh";
        sizeByKM = 140914;
        year = 1998;
        stats.setMalePopulation(16437542);
        stats.setFemalePopulation(14002350);
        stats.setSexRatio(calculateSexRatio());
        stats.setPopPerSquareKM(calculatePopDensity());
        stats.setPopulationGrowth(2.41);
    }
    public ArrayList<Integer> getPopulation(){return population;}

}
