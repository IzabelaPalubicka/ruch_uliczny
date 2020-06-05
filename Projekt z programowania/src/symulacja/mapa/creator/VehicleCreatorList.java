package symulacja.mapa.creator;

import symulacja.mapa.Mapa;
import symulacja.participants.vehicle.Car;
import symulacja.participants.vehicle.VehicleFunction;

import java.util.LinkedList;
import java.util.List;

public class VehicleCreatorList implements VehicleCreator{

    protected int amountCar;
    protected int amountBicycle;

    public VehicleCreatorList(int amountCar, int amountBicycle) {
        this.amountCar = amountCar;
        this.amountBicycle = amountBicycle;
    }

    @Override
    public List<VehicleFunction> creatorCars(Mapa mapa, int maxSpeed, int speed) {
        List<VehicleFunction> carList = new LinkedList<>();
        for(int i = 0; i < amountCar; i++)
            carList.add(new Car(maxSpeed, speed));
        return carList;
    }

    @Override
    public List<VehicleFunction> creatorBicycles(Mapa mapa, int maxSpeed, int speed) {
        List<VehicleFunction> bicycleList = new LinkedList<>();
        for(int i = 0; i < amountCar; i++)
            bicycleList.add(new Car(maxSpeed, speed));
        return bicycleList;
    }

}
