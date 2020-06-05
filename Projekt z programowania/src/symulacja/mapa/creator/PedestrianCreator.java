package symulacja.mapa.creator;

import symulacja.participants.pedestrian.Dog;
import symulacja.participants.pedestrian.Human;


import java.util.List;

public interface PedestrianCreator {

    public List<Human> creatorHuman();
    public List<Dog> creatorDogs();

}
