package symulacja.participants.vehicle;

import symulacja.mapa.Mapa;
import symulacja.mapa.PositionOccupation;

import java.util.Random;

public class Bicycle extends Vehicle {

    public Bicycle(int maxSpeed) {
        super(maxSpeed);
    }

    @Override
    public int coordinateX() {
        return super.coordinateX();
    }

    @Override
    public int coordinateY(int coordinateX) {
        return super.coordinateY(coordinateX);
    }

    public void accelerate(int speed, int maxSpeed) {
        super.accelerate(speed, maxSpeed);
    }

    public void slowDown(int speed, int maxSpeed) {
        super.slowDown(speed, maxSpeed);
    }
    
    public int speed(int maxSpeed){
        super.speed(maxSpeed);
        return speed;
    }

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY) {
        return super.seeObstacle(coordinateX, coordinateY);
    }


    public void move(int speed, int coordinateX, int coordinateY) {

        Map[coordinateX][coordinateY] = PositionOccupation.EMPTY;
        if (coordinateY == 1) {
            coordinateX += (speed / 10);

            switch (seeObstacle(coordinateX, coordinateY)) {
                case HUMAN:
                case DOG:
                case RED:
                    slowDown(maxSpeed, 0);
                    break;
                case COP:
                    slowDown(maxSpeed, PERMISSIBLE_SPEED);
                    break;
                default:
                    accelerate(speed, maxSpeed);
            }
        } else {

            coordinateY -= (speed / 10);
            switch (seeObstacle(coordinateX, coordinateY)) {
                case HUMAN:
                case DOG:
                case RED:
                    slowDown(maxSpeed, 0);
                    break;
                case CAR:
                    slowDown(maxSpeed, PERMISSIBLE_SPEED);
                    break;
                default:
                    accelerate(speed, maxSpeed);
            }
        }

        Map[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
    }

}
