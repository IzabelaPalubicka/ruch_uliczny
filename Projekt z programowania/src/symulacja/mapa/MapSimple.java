package symulacja.mapa;

import symulacja.participants.Cop;
import symulacja.participants.TrafficLights;
import symulacja.participants.pedestrian.Dog;
import symulacja.participants.pedestrian.Human;
import symulacja.mapa.Mapa;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;
import symulacja.participants.vehicle.VehicleFunction;

import java.util.List;

public class MapSimple implements Mapa {

    public final int HIGH = 32;
    public final int WIDTH = 6;
    public PositionOccupation positionOccupation;
    public PositionOccupation[][] mapa;

    public MapSimple() {
        this.mapa = makeMap();
    }


    public PositionOccupation[][] makeMap() {
        for (int i = 0; i < HIGH; i++) {

            PositionOccupation[] map1 = mapa[i];

            for (int j = 0; j < WIDTH; j++) {
                mapa[i][j] = positionOccupation.EMPTY;

            }
        }
        return mapa;
    }

    @Override
    public boolean settleHuman(Human human) {
        int coordinateX;
        int coordinateY;
        do {

            coordinateX = human.coordinateX();
            coordinateY = human.coordinateY();

        } while (mapa[coordinateX][coordinateY] != PositionOccupation.EMPTY);
        mapa[coordinateX][coordinateY] = PositionOccupation.HUMAN;
        return false;
    }

    @Override
    public boolean settleDog(Dog dog) {
        int coordinateX;
        int coordinateY;
        do {

            coordinateX = dog.coordinateX();
            coordinateY = dog.coordinateY();

        } while (mapa[coordinateX][coordinateY] != PositionOccupation.EMPTY);
        mapa[coordinateX][coordinateY] = PositionOccupation.DOG;
        return false;
    }

    @Override
    public boolean settleBicycle(Bicycle bicycle) {
        return false;
    }

    @Override
    public boolean settleCar(Car car) {
        return false;
    }

    @Override
    public boolean settleCop(Cop cop) {
        return false;
    }

    @Override
    public boolean TrafficLight(TrafficLights trafficLights) {
        return false;
    }
}

