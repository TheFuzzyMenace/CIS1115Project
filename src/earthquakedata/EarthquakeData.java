package earthquakedata;

/**
 * This is the OBJECT CLASS This program will log various parameters associated
 * with earthquakes.
 *
 * @author Jeremiah E. Zellers
 */
public class EarthquakeData {



    private int id;
    private String location;
    double magnitude;
    private double duration;
    private String damage;
    private double damageTotal;

    public EarthquakeData() {
    }

    public EarthquakeData(int id, String location, double magnitude, double duration, String damage, double damageTotal) {
        this.id = id;
        this.location = location;
        this.magnitude = magnitude;
        this.duration = duration;
        this.damage = damage;
        this.damageTotal = damageTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public double getDamageTotal() {
        return damageTotal;
    }

    public void setDamageTotal(double damageTotal) {
        this.damageTotal = damageTotal;
    }
    

    @Override
    public String toString() {
        return String.format("%5d %20s %20.2f %20.2f %20s %20.2f %n",
                id, location, magnitude, duration, damage, damageTotal);
    }

}
