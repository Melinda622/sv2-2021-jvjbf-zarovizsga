package shipping;

public class NationalPackage implements Transportable {

    private int weight;
    private boolean isbreakable;
    private static final int SHIPPING_PRICE=1000;

    public NationalPackage(int weight, boolean isbreakable) {
        this.weight = weight;
        this.isbreakable = isbreakable;
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
        if(isbreakable==true){
            return SHIPPING_PRICE*2;
        }else{
            return SHIPPING_PRICE;
        }
    }

    @Override
    public String getDestinationCountry() {
        return Transportable.super.getDestinationCountry();
    }
}
