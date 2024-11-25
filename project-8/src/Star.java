public class Star {
    private int temperature;
    private double luminosity;
    private double radius;
    private double absoluteMagnitude;
    private int starType;
    private String starColor;
    private String spectralClass;

    // default constructor
    public Star() {
        temperature = 0;
        luminosity = 0.0;
        radius = 0.0;
        absoluteMagnitude = 0.0;
        starType = 0;
        starColor = null;
        spectralClass = null;
    }

    // parameterized constructor
    public Star(int temperature, double luminosity, double radius, double absoluteMagnitude, int starType, String starColor, String spectralClass) {
        this.temperature = temperature;
        this.luminosity = luminosity;
        this.radius = radius;
        this.absoluteMagnitude = absoluteMagnitude;
        this.starType = starType;
        this.starColor = starColor;
        this.spectralClass = spectralClass;
    }

    // copy constructor
    public Star(Star s) {
        temperature = s.temperature;
        luminosity = s.luminosity;
        radius = s.radius;
        absoluteMagnitude = s.absoluteMagnitude;
        starType = s.starType;
        starColor = s.starColor;
        spectralClass = s.spectralClass;
    }

    // getters

    public int getTemperature() {
        return temperature;
    }
    public double getLuminosity() {
        return luminosity;
    }
    public double getRadius() {
        return radius;
    }
    public double getAbsoluteMagnitude() {
        return absoluteMagnitude;
    }
    public int getStarType() {
        return starType;
    }
    public String getStarColor() {
        return starColor;
    }
    public String getSpectralClass() {
        return spectralClass;
    }

    // toString method
    @Override
    public String toString() {
        return temperature + "," + luminosity + "," + radius + "," + absoluteMagnitude + "," + starType + "," + starColor + "," + spectralClass;
    }
}
