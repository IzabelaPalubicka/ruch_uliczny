package symulacja.participants.pedestrian;

import symulacja.participants.RandomPositionOccupation;


public interface Pedestrian extends RandomPositionOccupation {

    int crossing(int n,int firstCoordinateY, int coordinateY, int coordinateX);
}
