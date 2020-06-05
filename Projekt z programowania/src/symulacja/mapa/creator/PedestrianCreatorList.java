package symulacja.mapa.creator;

import symulacja.participants.pedestrian.Dog;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.pedestrian.Pedestrian;


import java.util.LinkedList;
import java.util.List;

public class PedestrianCreatorList implements PedestrianCreator {

    protected int amountHuman;
    protected int amountDog;

    public PedestrianCreatorList(int amountHuman, int amountDog) {
        this.amountHuman = amountHuman;
        this.amountDog = amountDog;
    }


    @Override
    public List<Human> creatorHuman() {
        List<Human> humanList = new LinkedList<>();
        for(int i = 0; i < amountHuman; i++)
            humanList.add(new Human());
        return humanList;
    }

    @Override
    public List<Dog> creatorDogs() {
        List<Dog> dogList = new LinkedList<>();
        for(int i = 0; i < amountHuman; i++)
            dogList.add(new Dog());
        return dogList;
    }
}
