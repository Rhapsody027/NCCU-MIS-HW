public class Machine implements FixedAsset {
    private int durableYear;
    private double residualValue, value, depreciation;

    public Machine(int durableYear, double residualValue, double value) {
        this.durableYear = durableYear;
        this.residualValue = residualValue;
        this.value = value;
    }

    public void calcDepreciation(int year) {
        if (year <= durableYear) {
            depreciation = (value - residualValue) / durableYear;
        } else {
            depreciation = 0;
        }
    }

    public double getDepreciation() {
        return depreciation;
    }

    public double getValue() {
        return value;
    }

}
