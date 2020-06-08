package symulacja.mapa;

import symulacja.participants.Cop;
import symulacja.participants.TrafficLights;
import symulacja.participants.pedestrian.Dog;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;

//import java.util.Random;

public class MapSimple implements Mapa {

    public final int HIGH = 32;
    public final int WIDTH = 6;
    public PositionOccupation positionOccupation;
    public PositionOccupation[][] mapa = new PositionOccupation[HIGH][WIDTH];

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
    public boolean settleHuman(Human human,PositionOccupation[][] mapa) {
        do {

            human.coordinateX = human.coordinateX();
            human.coordinateY = human.coordinateY();
            human.firstCoordinateY = human.coordinateY;

        } while (mapa[human.coordinateX][human.coordinateY] != PositionOccupation.EMPTY);
        mapa[human.coordinateX][human.coordinateY] = PositionOccupation.HUMAN;
        return false;
    }

    @Override
    public boolean settleDog(Dog dog,PositionOccupation[][] mapa) {
        do {

            dog.coordinateX = dog.coordinateX();
            dog.coordinateY = dog.coordinateY();
            dog.firstCoordinateY = dog.coordinateY;

        } while (mapa[dog.coordinateX][dog.coordinateY] != PositionOccupation.EMPTY);
        mapa[dog.coordinateX][dog.coordinateY] = PositionOccupation.DOG;
        return false;
    }

    @Override
    public boolean settleBicycle(Bicycle bicycle,PositionOccupation[][] mapa) {
        do {

           bicycle.coordinateX = bicycle.coordinateX();
           bicycle.coordinateY = bicycle.coordinateY(bicycle.coordinateX);

        } while (mapa[bicycle.coordinateX][bicycle.coordinateY] != PositionOccupation.EMPTY);

        mapa[bicycle.coordinateX][bicycle.coordinateY] = PositionOccupation.BICYCLE;
        return false;
    }

    @Override
    public boolean settleCar(Car car, PositionOccupation[][] mapa) {
        do {

          car.coordinateX = car.coordinateX();
          car.coordinateY(car.coordinateX);
        } while (mapa[car.coordinateX][car.coordinateY] != PositionOccupation.EMPTY);

        mapa[car.coordinateX][car.coordinateY] = PositionOccupation.CAR;
        return false;
    }

    @Override
    public boolean settleCop(Cop cop,  PositionOccupation[][] mapa) {
        do {

            cop.coordinateX();
            cop.coordinateY();

        } while (mapa[cop.coordinateX][cop.coordinateY] != PositionOccupation.EMPTY);
        mapa[cop.coordinateX][cop.coordinateY] = PositionOccupation.COP;

        return false;
    }

    @Override
    public boolean settleTrafficLight(TrafficLights trafficLights, PositionOccupation[][] mapa) {

        if (trafficLights.light == true)
            mapa[trafficLights.coordinateX][trafficLights.coordinateY] = PositionOccupation.GREEN;
        if (trafficLights.light == false)
            mapa[trafficLights.coordinateX][trafficLights.coordinateY] = PositionOccupation.RED;
        return false;
    }


}
