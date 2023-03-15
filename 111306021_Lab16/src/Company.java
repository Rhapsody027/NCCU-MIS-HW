import java.util.ArrayList;

public class Company {
    private String name;
    private int year = 1;

    private double bookValue, depreciation;

    private ArrayList<FixedAsset> assets = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addFixedAsset(FixedAsset asset) {
        assets.add(asset);
        bookValue += asset.getValue();
    }

    public void nextYear() {
        year += 1;
        calcDepreciation();
        bookValue -= depreciation;
    }

    public void lastYear() {
        if (year > 1) {
            year -= 1;
            bookValue += depreciation;
            calcDepreciation();
        }
    }

    public void calcDepreciation() {
        depreciation = 0;

        for (FixedAsset a : assets) {
            a.calcDepreciation(year);
            depreciation += a.getDepreciation();
        }
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getDepreciation() {
        return depreciation;
    }

    public double getBookValue() {
        return bookValue;
    }
}
