package earthquakedata;

/**
 *
 * @author Jeremaih E. Zellers
 */
public class EarthquakeDataApp2 {

    public static void main(String[] args) {
        System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");

        DAOEarthquakeData quakeInstance = new DAOEarthquakeData();
        quakeInstance.create(new EarthquakeData(1, "Pennsylvania", 5.5, 18.95, "yes", 1500.00));
        quakeInstance.create(new EarthquakeData(2, "California", 9.5, 35.59, "yes", 1850.00));
        quakeInstance.create(new EarthquakeData(3, "Hawaii", 5.9, 24.61, "yes", 3500.00));
        System.out.println(quakeInstance);

//retrieve all data
//        System.out.println(quakeInstance);
//Retrieve a SINGLE id (null if no id found)
        //System.out.println(data.retrieve(2));
        // System.out.println(data.retrieve(5));
//Delete an object (using id)
        quakeInstance.delete(1);
        quakeInstance.delete(2);
        System.out.println(quakeInstance);

//Update and object
        EarthquakeData quakeInstance1 = new EarthquakeData(3, "Pennsylvania", 1.1, 48.9, "no", 0.00);
        quakeInstance.update(quakeInstance1);
        System.out.println(quakeInstance);

    }

}
