package symulacja.mapa;

import symulacja.participants.Cop;
import symulacja.participants.TrafficLights;
import symulacja.participants.pedestrian.Dog;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;

public interface Mapa {

        public PositionOccupation[][] makeMap();
        boolean settleHuman(Human human, PositionOccupation[][] mapa);
        boolean settleDog(Dog dog,  PositionOccupation[][] mapa);
        boolean settleBicycle(Bicycle bicycle,  PositionOccupation[][] mapa);
        boolean settleCar(Car car,  PositionOccupation[][] mapa);
        boolean settleCop(Cop cop,  PositionOccupation[][] mapa);
        boolean settleTrafficLight(TrafficLights trafficLights, PositionOccupation[][] mapa);

}
