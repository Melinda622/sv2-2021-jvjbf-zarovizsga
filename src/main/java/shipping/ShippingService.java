package shipping;

import java.util.*;

public class ShippingService {

    List<Transportable> packages=new ArrayList<>();

    public void addPackage(Transportable p){
        packages.add(p);
    }

   public List<Transportable> collectItemsByBreakableAndWeight(boolean breakable, int weight){
        return packages.stream().filter(p->p.isBreakable()==breakable&&p.getWeight()>=weight).toList();
   }

    public Map<String,Integer> collectTransportableByCountry(){
        Map<String,Integer> result=new HashMap<>();
        for (Transportable actual:packages) {
            if(!result.containsKey(actual.getDestinationCountry())){
                result.put(actual.getDestinationCountry(),packagesByCountry(actual.getDestinationCountry()));
            }
        }
        return result;
    }

    private int packagesByCountry(String country){
        return (int)packages.stream().filter(p->p.getDestinationCountry().equalsIgnoreCase(country)).count();
    }

    public List<Transportable> sortInternationalPackagesByDistance(){
        List<Transportable> result=
                packages.stream().filter(p->!p.getDestinationCountry().equalsIgnoreCase("Hungary")&&p instanceof InternationalPackage).
                        sorted((o1, o2) -> ((InternationalPackage) o1).getDistance()-((InternationalPackage) o2).getDistance()).toList();
        return result;
    }

    public List<Transportable> getPackages() {
        return packages;
    }
}
