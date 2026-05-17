package parkingmanagementsystem.fileio;

import parkingmanagementsystem.entity.Vehicle;

import java.io.*;
import java.util.Random;
public class VehicleFileIO {

    private static final String FILE_NAME =
            "parkingmanagementsystem/fileio/vehicles.txt";

    private static final String TEMP_FILE =
            "parkingmanagementsystem/fileio/temp.txt";

// createFileIfNotExists        
public static void createFileIfNotExists() throws IOException {

    File file = new File(FILE_NAME);
    if (!file.exists())
            file.createNewFile();
}


// duplicate checker

public static boolean vehicleIdExists(String vehicleId) {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
        String line;
        while ((line = br.readLine()) != null) {
            Vehicle v = Vehicle.fromLine(line);

            if (v != null && v.getVhicleId().equals(vehicleId))
                return true;
        }

    }catch (IOException ignored) {}
    return false;
}

public static boolean numberPlateExists(String numberPlate) {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
        String line;
        while ((line = br.readLine()) != null) {
            Vehicle v = Vehicle.fromLine(line);

            if (v != null && v.getNumberPlate().equals(numberPlate))
                return true;
        }

    }catch (IOException ignored) {}
    return false;
}

public static boolean driverNameExists(String driverName) {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
        String line;
        while ((line = br.readLine()) != null) {
            Vehicle v = Vehicle.fromLine(line);

            if (v != null && v.getDriverName().equals(driverName))
                return true;
        }

    }catch (IOException ignored) {}
    return false;
}




// countRecords 
public static int countRecords() {

    int count = 0;

    try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
        String line;
        while ((line = br.readLine()) != null) {
            if (Vehicle.fromLine(line) != null)
                count++;
        }

    } catch (IOException ignored) {}
    return count;
}

public static int generateVehicleId(){
    Random rid = new Random();
    int number = 10000000 + rid.nextInt(90000000);
    return number;
}

public static String generateParkingSlot() {

    String[] slots = {
            "A-1","A-2","A-3","B-1","B-2","B-3"
    };

    Object[][] vehicles = getAllVehicles();
    for(String slot : slots) {
        boolean occupied = false;
        for(Object[] row : vehicles) {
            if(row[4] != null && row[4].equals(slot)) {
                occupied = true;
                break;
            }
        }if(!occupied)
            return slot;
    }return "FULL";
}



public static void addVehicle(Vehicle v) throws IOException {
    try (PrintWriter pw =
         new PrintWriter(new BufferedWriter(new FileWriter(FILE_NAME, true)))) {
            pw.println(v.toLine());
        }
}


public static boolean updateVehicle(Vehicle v)
            throws IOException {

        File inputFile = new File(FILE_NAME);

        File tempFile = new File(TEMP_FILE);

        boolean found = false;

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(inputFile));

                BufferedWriter bw =
                        new BufferedWriter(
                                new FileWriter(tempFile))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                Vehicle existing =
                        Vehicle.fromLine(line);

                if (existing != null &&
                        existing.getId().equals(v.getId())) {

                    bw.write(v.toLine());

                    found = true;

                } else {

                    bw.write(line);
                }

                bw.newLine();
            }
        }

        if (found) {

            if (!inputFile.delete()
                    || !tempFile.renameTo(inputFile)) {

                throw new IOException(
                        "Could not finalize update.");
            }

        } else {

            tempFile.delete();
        }

        return found;
    }

    public static boolean deleteVehicle(String id)
            throws IOException {

        File inputFile = new File(FILE_NAME);

        File tempFile = new File(TEMP_FILE);

        boolean found = false;

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(inputFile));

                BufferedWriter bw =
                        new BufferedWriter(
                                new FileWriter(tempFile))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                Vehicle existing =
                        Vehicle.fromLine(line);

                if (existing != null &&
                        existing.getId().equals(id)) {

                    found = true;

                    continue;
                }

                bw.write(line);

                bw.newLine();
            }
        }

        if (found) {

            if (!inputFile.delete()
                    || !tempFile.renameTo(inputFile)) {

                throw new IOException(
                        "Could not finalize delete.");
            }

        } else {

            tempFile.delete();
        }

        return found;
    }

    public static Object[][] getAllVehicles() {

        int total = countRecords();

        Object[][] rows = new Object[total][6];

        int idx = 0;

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(FILE_NAME))
        ) {

            String line;

            while ((line = br.readLine()) != null
                    && idx < total) {

                Vehicle v = Vehicle.fromLine(line);

                if (v != null) {

                    Object[] row = v.toRow();

                    rows[idx][0] = row[0];
                    rows[idx][1] = row[1];
                    rows[idx][2] = row[2];
                    rows[idx][3] = row[3];
                    rows[idx][4] = row[4];
                    rows[idx][5] = row[5];

                    idx++;
                }
            }

        } catch (IOException ignored) {
        }

        return rows;
    }

    public static Object[][] searchVehicles(String keyword) {

        String kw = keyword.toLowerCase();

        int matchCount = 0;

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(FILE_NAME))
        ) {

            String line;

            while ((line = br.readLine()) != null) {

                Vehicle v = Vehicle.fromLine(line);

                if (v != null &&
                        (
                                v.getId()
                                        .toLowerCase()
                                        .contains(kw)

                                        ||

                                        v.getOwnerName()
                                                .toLowerCase()
                                                .contains(kw)
                        )) {

                    matchCount++;
                }
            }

        } catch (IOException ignored) {
        }

        Object[][] results =
                new Object[matchCount][6];

        int idx = 0;

        try (
                BufferedReader br =
                        new BufferedReader(
                                new FileReader(FILE_NAME))
        ) {

            String line;

            while ((line = br.readLine()) != null
                    && idx < matchCount) {

                Vehicle v = Vehicle.fromLine(line);

                if (v != null &&
                        (
                                v.getId()
                                        .toLowerCase()
                                        .contains(kw)

                                        ||

                                        v.getOwnerName()
                                                .toLowerCase()
                                                .contains(kw)
                        )) {

                    Object[] row = v.toRow();

                    results[idx][0] = row[0];
                    results[idx][1] = row[1];
                    results[idx][2] = row[2];
                    results[idx][3] = row[3];
                    results[idx][4] = row[4];
                    results[idx][5] = row[5];

                    idx++;
                }
            }

        } catch (IOException ignored) {
        }

        return results;
    }
}
