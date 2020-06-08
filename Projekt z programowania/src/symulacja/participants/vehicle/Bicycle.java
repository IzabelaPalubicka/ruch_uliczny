package symulacja.participants.vehicle;

import symulacja.mapa.MapSimple;
import symulacja.mapa.PositionOccupation;


public class Bicycle extends Vehicle {

    public Bicycle(int maxSpeed, int speed) {
        super(maxSpeed, speed);
    }

    @Override
    public int coordinateX() {
        return super.coordinateX();
    }



    public void accelerate(int speed, int maxSpeed) {
        super.accelerate(speed, maxSpeed);
    }

    public void slowDown(int speed, int maxSpeed) {
        super.slowDown(speed, maxSpeed);
    }

    @Override
    public int coordinateY(int coordinateX) {
        return super.coordinateY(coordinateX);
    }

    @Override
    public PositionOccupation seeObstacle(int coordinateX, int coordinateY, MapSimple position) {
        return super.seeObstacle(coordinateX, coordinateY, position);
    }

    public void move(int speed, int coordinateX, int coordinateY, MapSimple position) {

       position.mapa[coordinateX][coordinateY] = PositionOccupation.EMPTY;

        if (coordinateY == 4) {
            coordinateX -= (int)(speed / 10);
            if (coordinateX >= 0){
                switch (seeObstacle(coordinateX, coordinateY, position)) {
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
            position.mapa[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
        }
            else System.gc();
        } else {

            coordinateX += (int)(speed / 10);
            if(coordinateX <32) {
                switch (seeObstacle(coordinateX, coordinateY, position)) {
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
                position.mapa[coordinateX][coordinateY] = PositionOccupation.BICYCLE;
            }
            else System.gc();
        }

    }

}
