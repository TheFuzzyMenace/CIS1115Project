/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package earthquakedata;

import java.util.Scanner;
import utilities.Prompt;

/**
 *
 * @author 55zellerje10
 */
public class EarthquakeDataMenu {

    Scanner sc = new Scanner(System.in);
    DAOEarthquakeData quakeInstance = new DAOEarthquakeData();
    private EarthquakeData quakeData;

    public EarthquakeDataMenu() {
        menuLoop();
    }

    private void menuLoop() {
        int choice = 1;
        int id;
        String location;
        double magnitude;
        double duration;
        String damage;
        double damageTotal;

        while (choice != 0) {
            System.out.println("\nPet App");
            System.out.println("0 = Quit");
            System.out.println("1 = Retrieve All Records");
            System.out.println("2 = Create New Record");
            System.out.println("3 = Retrieve Single Record");
            System.out.println("4 = Update");
            System.out.println("5 = Delete");
            System.out.println("6 = Retrieve All: Order by ID");
            System.out.println("7 = Retrieve All: Order by Location");
            System.out.println("8 = Retrieve All: Order by Magnitude");
            System.out.println("9 = Retrieve All: Order by Duration (in sec)");
            System.out.println("10 = Retrieve All: Order by Damage Incurred (y/n)");
            System.out.println("11 = Retrieve All: Order by Damage Total ($)");
            System.out.println("12 = Retrieve All: Order by Damage Total and Location");
            System.out.println("13 = Retrieve All: Order by Reverse ID");
            System.out.println("14 = Statistics");

            choice = Prompt.getInt("Number of choice: ", 0, 14); //number of choices 0 - 12 i.e.(0,13)

            if (choice == 1) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.toString());
            } else if (choice == 2) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                id = Prompt.getInt("Enter Earthquake Instance id: ");
                location = Prompt.getLine("Enter Location: ");
                magnitude = Prompt.getDouble("Enter Magnitude: ");
                duration = Prompt.getDouble("Enter Duration: ");
                damage = Prompt.getLine("Was there damage reported? (yes/no): ");
                damageTotal = Prompt.getDouble("What was the total damage amount "
                        + "($)(Type 0 if no damage reported): ");
                EarthquakeData quake = new EarthquakeData(id, location, magnitude,
                        duration, damage, damageTotal);
                quakeInstance.create(quake);
            } else if (choice == 3) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                id = Prompt.getInt("Enter Earthquake Instance id: ");
                System.out.println(quakeInstance.retrieve(id));
            } else if (choice == 4) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                id = Prompt.getInt("Enter Earthquake Instance id: ");
                location = Prompt.getLine("Enter Earthquake Instance Location: ");
                magnitude = Prompt.getDouble("Enter Earthquake Instance Magnitude: ");
                duration = Prompt.getDouble("Enter Earthquake Instance Duration (in seconds): ");
                damage = Prompt.getLine("Was there damage (yes/no): ");
                damageTotal = Prompt.getDouble("What was the Damage Total (in $): ");
                EarthquakeData quake = new EarthquakeData(id, location, magnitude,
                        duration, damage, damageTotal);
                quakeInstance.update(quake);

            } else if (choice == 5) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                id = Prompt.getInt("Enter Earthquake Intance id: ");
                quakeInstance.delete(id);
            } else if (choice == 6) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderById());
            } else if (choice == 7) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderByLocation());
            } else if (choice == 8) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderByMagnitude());
            } else if (choice == 9) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderByDuration());
            } else if (choice == 10) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderDamage());
            } else if (choice == 11) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderByDamageTotal());
            } else if (choice == 12) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderByDamageTotalAndLocation());
            } else if (choice == 13) {
                System.out.printf("%5s %20s %20s %20s %20s %20s %n", "ID", "LOCATION",
                        "MAGNITUDE", "DURATION(s)", "DAMAGE?", "DAMAGE TOTALS($)");
                System.out.println(quakeInstance.orderByReverseId());
            } else if (choice == 14) {
                System.out.println(String.format("%20s,%20s,%20s,%20s,%20s, %n", "SUM", "AVERAGE", "LARGEST", "SMALLEST", "STANDARD DEV"));
                System.out.println(quakeInstance.stats());

            } else if (choice == 0) {
                ;
            }
        }
    }

    public static void main(String[] args) {
        new EarthquakeDataMenu();
    }
}
