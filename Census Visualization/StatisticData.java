package safe;

import java.io.Serializable;

public class StatisticData implements Serializable{
    private double populationGrowth;
    private int malePopulation;
    private int femalePopulation;
    private double sexRatio;
    private double popPerSquareKM;

    public double getPopulationGrowth() {return populationGrowth;}
    public int getMalePopulation() {return malePopulation;}
    public int getFemalePopulation() {return femalePopulation;}
    public double getSexRatio() {return sexRatio;}
    public double getPopPerSquareKM() {return popPerSquareKM;}

    public void setPopulationGrowth(double populationGrowth) {this.populationGrowth = populationGrowth;}
    public void setMalePopulation(int malePopulation) {this.malePopulation = malePopulation;}
    public void setFemalePopulation(int femalePopulation) {this.femalePopulation = femalePopulation;}
    public void setSexRatio(double sexRatio) {this.sexRatio = sexRatio;}
    public void setPopPerSquareKM(double popPerSquareKM) {this.popPerSquareKM = popPerSquareKM;}
}