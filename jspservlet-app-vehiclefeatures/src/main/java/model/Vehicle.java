package model;
 public class Vehicle{
    int vehicleId;
    String vehicleName;
    String vehicleModel;
    int vehicleCC;
    String vehicleDescription;
    int vehiclePrice;
    public Vehicle(){

    }
    
    public Vehicle(int vehicleId, String vehicleName, String vehicleModel, int vehicleCC, String vehicleDescription,
            int vehiclePrice) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehicleCC = vehicleCC;
        this.vehicleDescription = vehicleDescription;
        this.vehiclePrice = vehiclePrice;
    }
    
    public Vehicle(String vehicleName, String vehicleModel, int vehicleCC, String vehicleDescription,
            int vehiclePrice) {
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehicleCC = vehicleCC;
        this.vehicleDescription = vehicleDescription;
        this.vehiclePrice = vehiclePrice;
        
    }
    public int getVehicleId() {
        return vehicleId;
    }
    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String getVehicleName() {
        return vehicleName;
    }
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
    public String getVehicleModel() {
        return vehicleModel;
    }
    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    public int getVehicleCC() {
        return vehicleCC;
    }
    public void setVehicleCC(int vehicleCC) {
        this.vehicleCC = vehicleCC;
    }
    public String getVehicleDescription() {
        return vehicleDescription;
    }
    public void setVehicleDescription(String vehicleDescription) {
        this.vehicleDescription = vehicleDescription;
    }
    public int getVehiclePrice() {
        return vehiclePrice;
    }
    public void setVehiclePrice(int  vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
    public String toString(){
        return "" + this.vehicleId + this.vehicleName + this.vehicleCC + this.vehicleDescription + this.vehiclePrice ;
    }
}
