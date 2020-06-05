package symulacja.mapa.creator;


import symulacja.mapa.Mapa;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;


import java.util.List;

public interface VehicleCreator {

    public List<Car> creatorCars(Mapa mapa, int maxSpeed, int speed);
    public List<Bicycle> creatorBicycles(Mapa mapa, int maxSpeed, int speed);

}
