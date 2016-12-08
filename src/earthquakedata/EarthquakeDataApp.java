
package earthquakedata;

/**
 *
 * @author Jeremiah E. Zellers
 */
public class EarthquakeDataApp {
    
    public static void main(String[] args) {
        System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION", 
                "MAGNITUDE", "DURATION" ,"DAMAGE?" ,"DAMAGE TOTALS");
        
        EarthquakeData quake1 = new EarthquakeData(1, "Pennsylvania", 5.5, 45.5, "yes", 1500);
        System.out.println(quake1);
        EarthquakeData quake2 = new EarthquakeData(2, "California", 9.5, 95.5, "yes", 1850);
        System.out.println(quake2);
    }
    
}                      
