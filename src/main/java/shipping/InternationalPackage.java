package shipping;

public class InternationalPackage implements Transportable {

    private int weight;
    private boolean isbreakable;
    private String destinationCountry;
    private int distance;
    private static final int SHIPPING_PRICE = 1200;
    private static final int SHIPPING_PRICE_PER_KM = 10;

    public InternationalPackage(int weight, boolean isbreakable, String destinationCountry, int distance) {
        this.weight = weight;
        this.isbreakable = isbreakable;
        this.destinationCountry = destinationCountry;
        this.distance = distance;

    }
    public boolean isreakable() {
        return isbreakable;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public boolean isBreakable() {
        return isbreakable;
    }

    @Override
    public int calculateShippingPrice() {
        int pricePerKm = SHIPPING_PRICE_PER_KM * distance;
        if (isbreakable == true) {
            return SHIPPING_PRICE * 2 + pricePerKm;
        } else {
            return SHIPPING_PRICE + pricePerKm;
        }
    }

    @Override
    public String getDestinationCountry() {
        return destinationCountry;
    }
}
