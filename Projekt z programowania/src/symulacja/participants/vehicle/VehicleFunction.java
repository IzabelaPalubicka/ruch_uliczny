package symulacja.participants.vehicle;

import symulacja.mapa.PositionOccupation;
import symulacja.participants.RandomPositionOccupation;

public interface VehicleFunction extends RandomPositionOccupation {


    void accelerate(int speed, int maxSpeed);

    void slowDown(int speed, int safeSpeed);

    PositionOccupation seeObstacle(int coordinateX, int coordinateY);

    public void move(int maxSpeed, int coordinateX, int coordinateY);


}

