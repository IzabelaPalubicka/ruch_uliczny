package symulacja.mapa.creator;


import symulacja.mapa.Mapa;
import symulacja.participants.vehicle.VehicleFunction;

import java.util.List;

public interface VehicleCreator {

    public List<VehicleFunction> creatorCars(Mapa mapa, int maxSpeed, int speed);
    public List<VehicleFunction> creatorBicycles(Mapa mapa, int maxSpeed, int speed);

}
