package safe;

public interface Statistics {
    public double calculateSexRatio();
    public double calculatePopDensity();
    public double calculatePopGrowth(Province prevYear, Province currYear);
}
