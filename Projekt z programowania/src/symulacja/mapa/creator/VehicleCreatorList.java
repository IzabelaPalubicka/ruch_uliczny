package symulacja.mapa.creator;

import symulacja.mapa.Mapa;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;


import java.util.LinkedList;
import java.util.List;

/**Klasa ta dpowiedzialna jest za powstanie tablicy obiektow klas Car i Bicycle*/
public class VehicleCreatorList implements VehicleCreator{

    protected int amountCar;
    protected int amountBicycle;

    public VehicleCreatorList(int amountCar, int amountBicycle) {
        this.amountCar = amountCar;
        this.amountBicycle = amountBicycle;
    }

    @Override
    public List<Car> creatorCars(Mapa mapa, int maxSpeed, int speed) {
        List<Car> carList = new LinkedList<>();
        for(int i = 0; i < amountCar; i++)
            carList.add(new Car(maxSpeed, speed));
        return carList;
    }

    @Override
    public List<Bicycle> creatorBicycles(Mapa mapa, int maxSpeed, int speed) {
        List<Bicycle> bicycleList = new LinkedList<>();
        for(int i = 0; i < amountBicycle; i++)
            bicycleList.add(new Bicycle(maxSpeed, speed));
        return bicycleList;
    }

}
