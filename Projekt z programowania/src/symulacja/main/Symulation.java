package symulacja.main;

import symulacja.mapa.MapSimple;
import symulacja.mapa.Mapa;
import symulacja.mapa.creator.MapaCreator;
import symulacja.mapa.creator.PedestrianCreator;
import symulacja.mapa.creator.PedestrianCreatorList;
import symulacja.mapa.creator.VehicleCreatorList;
import symulacja.participants.pedestrian.Pedestrian;
import symulacja.participants.vehicle.*;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.pedestrian.Dog;
import symulacja.participants.RandomPositionOccupation;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Symulation {

    Konsola konsola;
    Mapa map;
    MapSimple mapa;
    PedestrianCreatorList pedestrianCreator;
    VehicleCreatorList vehicleCreator;

    public Symulation(Mapa map, PedestrianCreatorList pedestrianCreator, VehicleCreatorList vehicleCreator) {
        this.mapa = new MapSimple();
        this.pedestrianCreator = pedestrianCreator;
        this.vehicleCreator = vehicleCreator;
    }

    public static void main(String[] args) throws InterruptedException {

        MapSimple mapa = new MapSimple();
        Konsola konsola = new Konsola();
        VehicleCreatorList vehicleCreator = new VehicleCreatorList(konsola.numberCar, konsola.numberBicycle);
        PedestrianCreatorList pedestrianCreator = new PedestrianCreatorList(konsola.numberHuman, konsola.numberDog);
        Symulation symulation = new Symulation(mapa, pedestrianCreator, vehicleCreator);

        List<VehicleFunction> carList;
        List<VehicleFunction> bicycleList;
        List<Pedestrian> humanList;
        List<Pedestrian> dogList;

        carList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedCar);
        bicycleList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedBicycle);
        humanList = pedestrianCreator.creatorHuman();
        dogList = pedestrianCreator.creatorDogs();

        int indexBicycle = 0;
        int indexCar = 0;
        int indexHuman = 0;
        int indexDog = 0;

        for (int i = 0; i < konsola.numberCar + konsola.numberBicycle; i++) {
            int x;
            Random random = new Random();
            x = random.nextInt() % 2;
            if (x == 1 && indexCar < konsola.numberCar) {
                Car car = new Car(konsola.maxSpeedCar);
                carList.add(car);
                carList.get(indexCar).coordinateX();
                carList.get(indexCar).coordinateY();
                indexCar++;
            }
            if (x == 0 && indexBicycle < konsola.numberBicycle) {
                Bicycle bicycle = new Bicycle(konsola.maxSpeedBicycle);
                bicycleList.add(bicycle);
                bicycleList.get(indexBicycle).coordinateX();
                bicycleList.get(indexBicycle).coordinateY();
                indexBicycle++;
            }
            if (x == 1 && indexHuman < konsola.numberHuman) {
                Human human = new Human();
                humanList.add(human);
                indexHuman++;
            }
            if (x == 0 && indexDog < konsola.numberDog) {
                Dog dog = new Dog();
                dogList.add(dog);
                indexDog++;
            }

            for (int z = 0; ; z++) {

                if (z < konsola.numberBicycle) {
                    bicycleList.get(z).move(bicycleList.get(z).speed(konsola.maxSpeedBicycle), bicycleList.get(z).coordinateX(),bicycleList.get(z).coordinateY());
                    System.out.println("Rower nr" + (z + 1) + "znajduje się na mapie na pozycji x" + bicycleList.get(z).coordinateX() + " i pozycji y" + bicycleList.get(z).coordinateY());
                }

                if (z < konsola.numberCar) {
                    carList.get(z).move(bicycleList.get(z).speed(konsola.maxSpeedBicycle), carList.get(z).coordinateX(), carList.get(z).coordinateY());
                    System.out.println("Auto nr" + (z + 1) + "znajduje się na mapie na pozycji x" + carList.get(z).coordinateX() +
                            "i pozycji y" + carList.get(z).coordinateY());
                }
                if (z < konsola.numberDog) {
                    dogList.get(z).crossing(humanList.get(z).coordinateY(),humanList.get(z).coordinateY(),humanList.get(z).coordinateX());
                    System.out.println("Pies nr "+ (z + 1) +" znajduje sie wlasnie w pozycji"+
                            dogList.get(z).coordinateX() + "x i "+ dogList.get(z).coordinateY()+ "y");
                }
                if (z < konsola.numberHuman) {
                    humanList.get(z).crossing(humanList.get(z).coordinateY(),humanList.get(z).coordinateY(),humanList.get(z).coordinateX());
                    System.out.println("Przechodzien nr jest  w tej chwili w puncie"+ humanList.get(z).coordinateX()+"i"+ humanList.get(z).coordinateY());
                }

                for (int y = 0; y != indexBicycle; y++) {
                    for (int w = 0; w != indexBicycle; w++) {
                        if ((bicycleList.get(y).coordinateX() == carList.get(w).coordinateX() && bicycleList.get(y).coordinateY() == carList.get(w).coordinateY()) ||
                                (carList.get(y).coordinateX() == carList.get(konsola.numberCar - y).coordinateX() && carList.get(y).coordinateY() == carList.get(konsola.numberCar - y).coordinateX())) {
                            System.out.println("NASTĄPILA STŁUCZKA! DROGA NIE JEST BEZPIECZNA");
                            System.exit(0);
                        }
                        if ((carList.get(y).coordinateX() == humanList.get(y).coordinateX() && carList.get(y).coordinateY() == humanList.get(y).coordinateY()) ||
                                (carList.get(y).coordinateX() == dogList.get(y).coordinateX() && carList.get(y).coordinateY() == dogList.get(y).coordinateY())) {
                            System.out.println("MIAL MIEJSCE WYPADEK! DROGA NIE JEST BEZPIECZNA");
                            System.exit(0);
                        }
                    }
                }
            }
        }

    }
}
