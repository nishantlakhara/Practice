package designsolid.liskov.vehiclewithengine;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new MotorCycle());
        vehicleList.add(new BiCycle());

        for(Vehicle vehicle: vehicleList) {
            System.out.println(vehicle.hasEngine());
        }

        // Solution to above : Remove hasEngine from Vehicle class. Make it as generic as possible.
        // Add hasEngine method in MotorCycle class and Car class separately.
    }

}
