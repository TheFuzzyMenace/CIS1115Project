package earthquakedata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The Data Access Object to a list of earthquake data. This is how people get
 * access to your program.
 *
 * @author Jeremiah E. Zellers
 */
public class DAOEarthquakeData {

    private final String fileName = "earthquakedata.txt";

    List<EarthquakeData> quakeList;

    public DAOEarthquakeData() {
        quakeList = new ArrayList();
        readList();

    }

    public void create(EarthquakeData quakeData) {
        //code to add earthquake data to list
        quakeList.add(quakeData);
        writeList();

    }

    public EarthquakeData retrieve(int id) {
        //return a single quake record from the list or null if it doesn't exist

        for (EarthquakeData quake : quakeList) {
            if (quake.getId() == id) {
                return quake;
            }

        }

        return null;
    }

    public void update(EarthquakeData quakeData) {

        for (EarthquakeData quakeInstance : quakeList) {
            if (quakeInstance.getId() == quakeData.getId()) {
                quakeInstance.setId(quakeData.getId());
                quakeInstance.setLocation(quakeData.getLocation());
                quakeInstance.setMagnitude(quakeData.getMagnitude());
                quakeInstance.setDuration(quakeData.getDuration());
                quakeInstance.setDamage(quakeData.getDamage());
                quakeInstance.setDamageTotal(quakeData.getDamageTotal());
                writeList();
                break;
            }
        }

    }

    public void delete(int id) {

        EarthquakeData quakeInstance = null;
        for (EarthquakeData quake : quakeList) {
            if (quake.getId() == id) {
                quakeInstance = quake;
                break;
            }
        }
        quakeList.remove(quakeInstance);
        writeList();

    }

    public String orderById() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getId));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one. 
    }

    public String orderByLocation() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getLocation));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one. 
    }

    public String orderByMagnitude() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getMagnitude));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one. 
    }

    public String orderByDuration() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getDuration));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one. 
    }

    public String orderDamage() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getDamage));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one. 

    }

    public String orderByDamageTotal() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getDamageTotal));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one.     
    }

    public String orderByReverseId() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getId).reversed());
        return this.toString();
    }

    // ------------------Below is how you sort by two different attribuites! (then.Comparing does this)
    public String orderByDamageTotalAndLocation() {
        quakeList.sort(Comparator.comparing(EarthquakeData::getDamageTotal).thenComparing(EarthquakeData::getLocation));
        //(your class name :: what you want to sort by)
        return this.toString(); //use this.toString to call THIS classes toString.. not the other one. 
    }

    public String stats() {
        double sum = 0;
        int count = 0;
        double average = 0;
        double largest = Integer.MIN_VALUE;
        double smallest = Integer.MAX_VALUE;
        double total = 0;
        double stdev = 0;

        for (EarthquakeData quake : quakeList) {
            sum += quake.getMagnitude();
            count++;
        }

        for (EarthquakeData quake1 : quakeList) {
            if (quake1.getMagnitude() > largest) {
                largest = quake1.getMagnitude();
            } else if (quake1.getMagnitude() < smallest) {
                smallest = quake1.getMagnitude();

            }
        }
        average = sum / count;
        for (EarthquakeData quake2 : quakeList) {
            total += Math.pow((quake2.magnitude - average), 2);
        }
        if (total > 0) {
            stdev = Math.sqrt(total / (count - 1));
        }

        return String.format("%20.2f,%20.2f,%20.2f, %20.2f, %20.2f", sum, average, largest, smallest, stdev);
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String location = data[1];
                double magnitude = Double.parseDouble(data[2]);
                double duration = Double.parseDouble(data[3]);
                String damage = data[4];
                double damageTotals = Double.parseDouble(data[5]);
                EarthquakeData quake = new EarthquakeData(id, location, magnitude, duration, damage, damageTotals);
                quakeList.add(quake);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOEarthquakeData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (EarthquakeData quake : quakeList) {
                writer.write(String.format("%d,%s,%.2f,%.2f,%s,%.2f\n",
                        quake.getId(),
                        quake.getLocation(),
                        quake.getMagnitude(),
                        quake.getDuration(),
                        quake.getDamage(),
                        quake.getDamageTotal()));
            }

        } catch (IOException ex) {
            Logger.getLogger(DAOEarthquakeData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        //This is the standard tode to spit out a nice table
        StringBuilder sb = new StringBuilder("");

        for (EarthquakeData quakeData : quakeList) {
            sb.append(quakeData).append("\n");
        }
        return sb.toString();

    }
}
