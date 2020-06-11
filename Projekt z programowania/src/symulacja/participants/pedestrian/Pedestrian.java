package symulacja.participants.pedestrian;

import symulacja.participants.RandomPositionOccupation;

import java.util.List;

public interface Pedestrian extends RandomPositionOccupation {

    int crossing(int n,int firstCoordinateY, int coordinateY, int coordinateX);
}
