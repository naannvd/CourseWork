package safe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Province implements Statistics, Serializable {
    protected String provinceName;
    protected int sizeByKM;
    protected int year;
    protected StatisticData stats = new StatisticData();
    protected static ArrayList<Integer> populationYears = new ArrayList<>(Arrays.asList(1951,1961,1972,1981,1998,2017));

    protected Province(){}

    @Override
    public double calculateSexRatio() {
        return (double) stats.getMalePopulation() / stats.getFemalePopulation() * 100;
    }

    @Override
    public double calculatePopDensity() {
        int totalPop = stats.getMalePopulation() + stats.getFemalePopulation();
        return (double) totalPop/sizeByKM;
    }

    @Override
    public double calculatePopGrowth(Province prevYear, Province currYear){

        int prevTotalPopulation = prevYear.stats.getMalePopulation() + prevYear.stats.getFemalePopulation();
        int currTotalPopulation = currYear.stats.getMalePopulation() + currYear.stats.getFemalePopulation();

        double growth = (double) (currTotalPopulation - prevTotalPopulation) / prevTotalPopulation * 100;
        int yearDiff = currYear.year - prevYear.year;

        return growth / yearDiff;
    }

    public void setStats(StatisticData stats){this.stats = stats;}
    public StatisticData getStats(){return stats;}

    public String getProvinceName(){return provinceName;}
    public void setProvinceName(String provinceName){this.provinceName = provinceName;}

    public int getYear(){return year;}
    public void setYear(int year){this.year = year;}

    /*public void displayStatistics(){
        System.out.println("\t\t\t"+provinceName+"-"+year+" Statistical Data");
        System.out.println("> Province size: "+sizeByKM+" sq Km");
        System.out.println("> Male Population: "+stats.getMalePopulation());
        System.out.println("> Female Population: "+stats.getFemalePopulation());
        System.out.printf("> Sex Ratio: %.2f%n",stats.getSexRatio());
        System.out.printf("> Population density by size: %5.2f%n",stats.getPopPerSquareKM());
        System.out.printf("> Population growth from last census:%5.2f",stats.getPopulationGrowth());System.out.print("%\n\n");
    }*/

    @Override
    public String toString(){
        return "\t"+ provinceName + " - " + year + " Statistical Data\n\n" +
                " > Province size: " + sizeByKM + " sq Km\n"+
                " > Male Population: " + stats.getMalePopulation() + "\n"+
                " > Female Population: " + stats.getFemalePopulation() + "\n"+
                " > Sex Ratio: " + (double) Math.round(stats.getSexRatio()*100)/100+ "\n"+
                " > Population density: " + (double) Math.round(stats.getPopPerSquareKM()*100)/100+ "\n"+
                " > Population growth from last census: " + (double) Math.round(stats.getPopulationGrowth()*100)/100+ "%\n\n";
    }

    public ArrayList<Integer> getPopulationYears(){return populationYears;}
}
