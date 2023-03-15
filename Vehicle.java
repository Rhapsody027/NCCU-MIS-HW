public class Vehicle implements FixedAsset {
    private int durableYear;
    private double residualValue, value, depreciation, deRate;

    public Vehicle(int durableYear, double residualValue, double value) {
        this.durableYear = durableYear;
        this.residualValue = residualValue;
        this.value = value;
    }

    public void calcDepreciation() {
        deRate = (1.0 / durableYear) * 2.0;
    }

    public void calcDepreciation(int year) {
        calcDepreciation();

        if (year == durableYear) {
            depreciation = (value - residualValue) / durableYear;
        } else if (year < durableYear) {
            depreciation = residualValue * deRate;
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
