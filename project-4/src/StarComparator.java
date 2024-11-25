import java.util.Comparator;

class StarComparator implements Comparator<Star> {
    // implement comparator interface to compare 2 objects from Star class based on temperature (numerical attribute)
    public int compare(Star s1, Star s2) {
        return Integer.compare(s1.getTemperature(), s2.getTemperature());
    }
}
