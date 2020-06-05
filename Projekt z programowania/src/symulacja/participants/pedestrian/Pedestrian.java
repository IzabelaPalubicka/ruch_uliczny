package symulacja.participants.pedestrian;

import symulacja.participants.RandomPositionOccupation;

import java.util.List;

public interface Pedestrian extends RandomPositionOccupation {

    void crossing(int firstCoordinateY, int coordinateY, int coordinateX);

    void leftPavementCrossing(int coordinateY, int coordinateX);

    void rightPavementCrossing(int coordinateY, int coordinateX);
}
