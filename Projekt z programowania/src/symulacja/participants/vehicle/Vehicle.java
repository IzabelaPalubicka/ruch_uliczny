package symulacja.participants.vehicle;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;

import java.util.Random;

public abstract class Vehicle extends VehicleProperties implements VehicleFunction {


    public Vehicle(int maxSpeed, int speed) {
        super(maxSpeed, speed);
    }


    public int coordinateX() {
        Random random = new Random();
        do {
            coordinateX = random.nextInt() % 32;
        } while (coordinateX != 0 && coordinateX != 31);
        return coordinateX;
    }

    public int coordinateY(int coordinateX){
        if (coordinateX == 0) {
            coordinateY = 1;
        } else {
            coordinateY = 4;
        }
        return coordinateY;
    }

    public void accelerate(int speed, int maxSpeed) {
        if (speed < maxSpeed) {
            speed = speed * 2;
        }
    }

    public void slowDown(int speed, int safeSpeed) {
        if (speed > safeSpeed) {
            speed = speed / 2;
        }
    }

    public PositionOccupation seeObstacle(int coordinateX, int coordinateY, MapSimple position) {
        if (coordinateY == 1) {
            for (int i = 1; i <= TIME_REACTION; i++)
                for (int j = 0; j <= 4; j++) {
                    if (position.mapa[coordinateX + i][coordinateY + j] != positionOccupation.EMPTY) {
                        return position.mapa[coordinateX + i][coordinateY + j];
                    }
//                    if (i == TIME_REACTION && j == 4) {
                    else
                        return positionOccupation.EMPTY;

                }
        } else {
            for (int i = 1; i <= TIME_REACTION; i++)
                for (int j = 0; j <= 4; j++) {
                    if (position.mapa[coordinateX - i][coordinateY - j] != positionOccupation.EMPTY) {
                        return position.mapa[coordinateX - i][coordinateY - j];
                    }
//                    if (i == TIME_REACTION && j == 4) {
                    else return positionOccupation.EMPTY;
                }
        }
        return positionOccupation.EMPTY;
    }



    public int move(int maxSpeed, int coordinateX, int coordinateY, MapSimple position) {
    return coordinateX; }

    public int speed(int n,  int speed,int coordinateX, int coordinateY, MapSimple position){
        return speed;
    }


}

