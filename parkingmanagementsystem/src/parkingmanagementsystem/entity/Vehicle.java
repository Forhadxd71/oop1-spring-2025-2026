package parkingmanagementsystem.entity;

public class  Vehicle{
    private String vehicleId;
    private String vhicleType;
    private String driverName;
    private String numberPlate;
    private String parkingSlot;
    private String entryTime;

public Vehicle(String vhicleType,String vehicleId,String driverName,String numberPlate,String parkingSlot,String entryTime){
    this.vehicleId = vehicleId;
    this.vhicleType = vhicleType;
    this.driverName = driverName;
    this.numberPlate = numberPlate;
    this.parkingSlot = parkingSlot;
    this.entryTime = entryTime;
}

public String getVhicleId(){
    return vehicleId;
}
public String getVhicleType(){
    return vhicleType;
}
public String getDriverName(){
    return driverName;
}
public String getNumberPlate(){
    return numberPlate;
}
public String getParkingSlot(){
    return parkingSlot;
}
public String getEntryTime(){
    return entryTime;
}

public void setVhicleId(String vehicleId){
    this.vehicleId = vehicleId;
}

public void setVhicleType (String vehicleTye){
    this.vhicleType = vehicleTye;
}
public void setDriverName (String driverName){
    this.driverName = driverName;
}

public void setNumberPlate (String numberPlate){
    this.numberPlate = numberPlate;
}

public void setParkingSlot  (String parkingSlot){
    this.parkingSlot = parkingSlot;
}

public void setEntryTime (String entryTime){
    this.entryTime = entryTime;
}



public String toLine() {
    return vehicleId + "," + vhicleType + "," + driverName + "," + numberPlate + "," + parkingSlot + "," + entryTime;
}
public static Vehicle fromLine(String line) {
    if (line == null)
        return null;
    String[] data = line.split(",", -1);
    if (data.length != 6)
        return null;
    return new Vehicle(data[0], data[1], data[2], data[3],data[4],data[5]);
    }
public Object[] toRow() {
        return new Object[] { vehicleId, vhicleType, driverName, numberPlate, parkingSlot, entryTime };
    }

}