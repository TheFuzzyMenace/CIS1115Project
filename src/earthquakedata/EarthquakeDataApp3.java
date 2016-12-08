/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earthquakedata;

/**
 *
 * @author Jeremiah E 
 */
public class EarthquakeDataApp3 {
    public static void main(String[] args) {
        
        DAOEarthquakeData quakeInstance = new DAOEarthquakeData();
       quakeInstance.create(new EarthquakeData(25, "Mansfield", 5.9, 24.61, "yes", 3500.00));
//        System.out.println(data);
        
    
        System.out.println(quakeInstance);
        
    }
    
}
