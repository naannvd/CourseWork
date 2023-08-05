package safe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Pakistan implements Serializable {

    private final double countryArea, sexRatio, populationGrowth, literacyRate, populationDensity;


    private static final ArrayList<Integer> populationYears = new ArrayList<>(Arrays.asList(1951,1961,1972,1981,1998,2017,2022));
    private static final ArrayList<Integer> countryPopulation = new ArrayList<>(Arrays.asList(33740167, 42880378, 65309340,
            84253644,132352279, 207774520, 229254416)); //Country population from 1951-2022;

    private static final ArrayList<Double> unemploymentRates = new ArrayList<>(Arrays.asList(0.76, 0.72, 0.75, 0.67, 0.40, 0.42, 0.65
            , 1.70, 2.95, 1.83, 3.57, 4.08, 4.65, 4.70)); //Employment rate from 1999-2022
    private static final ArrayList<Integer> unemploymentYears = new ArrayList<>(Arrays.asList(1999,2001,2004,2005,2007,2008,2010,2012,2013,2014,2015,2018,2020,2022));


    Pakistan(){
        sexRatio = 1.033; //103.3 per 100 females
        countryArea = 881913;
        populationGrowth = (double) (countryPopulation.get(6) - countryPopulation.get(0)) / countryPopulation.get(0) * 100;
        literacyRate = 59.13;
        populationDensity = (double) countryPopulation.get(6) / countryArea;
    }

    /*public void display() {

        System.out.println("\t\t\tCountry Statistics by 2022");
        System.out.println("> Country area: " +countryArea+" sq Km");
        System.out.println("> Sex ratio: "+ sexRatio+". For every 100 females, there are 103.3 males");
        System.out.println("> Population growth from 1951-2022: "+populationGrowth);
        System.out.println("> Population density per square KM: "+populationDensity);
        System.out.println("> Literacy rate: "+literacyRate+"\n");

        System.out.println("> Population growth by census intervals: ");
        for (int i = 0; i < populationYears.size(); i++)
            System.out.println("\t\t> "+populationYears.get(i)+" - "+countryPopulation.get(i));

        System.out.println("\n> Employment rates by census intervals: ");
        for (int i = 0; i < unemploymentYears.size(); i++){
            System.out.print("> "+ unemploymentYears.get(i)+" - "+ unemploymentRates.get(i)+"%   ");
            if (i % 4 == 3)
                System.out.print("\n");
        }
    }*/

    public String toString() {

        StringBuilder pakistan = new StringBuilder();
        pakistan.append("\t\t\tCountry Statistics by 2022\n");
        pakistan.append("> Country area: ").append(countryArea).append(" sq Km").append("\n");
        pakistan.append("> Sex ratio: ").append((double)Math.round(sexRatio*100)/100).append("\n");
        pakistan.append("> Population growth from 1951-2022:  ").append((double)Math.round(populationGrowth*100)/100).append("\n");
        pakistan.append("> Population density per square Km:  ").append((double)Math.round(populationDensity*100)/100).append("\n");
        pakistan.append("> Literacy rate:  ").append(literacyRate).append("\n");
        pakistan.append("> Population growth by census intervals: ").append("\n\n");

        for (int i = 0; i < populationYears.size(); i++){
            pakistan.append("\t\t").append(populationYears.get(i)).append(" - ").append(countryPopulation.get(i)).append("\n");
        }
        pakistan.append("\n\n");
        pakistan.append("> Employment rates by census intervals: ").append("\n\n");
        for (int i = 0; i < unemploymentYears.size(); i++){
            pakistan.append("\t\t").append(unemploymentYears.get(i)).append(" - ").append(unemploymentRates.get(i)).append("\n");
        }

        return pakistan.toString();
    }

    //population statistic getters
    public ArrayList<Integer> getCountryPopulation(){return countryPopulation;}
    public ArrayList<Integer> getPopulationYears(){return populationYears;}

    //employment statistic getters
    public ArrayList<Integer> getUnemploymentYears(){return unemploymentYears;}
    public ArrayList<Double> getUnemploymentRates(){return unemploymentRates;}
}