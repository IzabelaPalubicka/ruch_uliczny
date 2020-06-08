package symulacja.main;

import symulacja.mapa.MapSimple;
import symulacja.mapa.creator.PedestrianCreatorList;
import symulacja.mapa.creator.VehicleCreatorList;
import symulacja.participants.pedestrian.APedestrian;
import symulacja.participants.pedestrian.Pedestrian;
import symulacja.participants.vehicle.*;
import symulacja.participants.pedestrian.Human;
import symulacja.participants.pedestrian.Dog;

import java.util.List;
import java.util.Random;

public class Symulation {

    MapSimple positions;
    PedestrianCreatorList pedestrianCreator;
    VehicleCreatorList vehicleCreator;
    static int indexBicycle = -1;
    static int indexCar = -1;
    static int indexHuman = -1;
    static int indexDog = -1;
    static Random random = new Random();

    public Symulation(MapSimple positions, PedestrianCreatorList pedestrianCreator, VehicleCreatorList vehicleCreator) {
        this.positions = positions;
        this.pedestrianCreator = pedestrianCreator;
        this.vehicleCreator = vehicleCreator;
    }

    static void settleParticipants() {

    }

    static void movementParticipant() {

    }

    public static void main(String[] args) {

        MapSimple positions = new MapSimple();
        Konsola konsola = new Konsola();
        VehicleCreatorList vehicleCreator = new VehicleCreatorList(konsola.numberCar, konsola.numberBicycle);
        PedestrianCreatorList pedestrianCreator = new PedestrianCreatorList(konsola.numberHuman, konsola.numberDog);
        Symulation symulation = new Symulation(positions, pedestrianCreator, vehicleCreator);

        List<Car> carList;
        List<Bicycle> bicycleList;
        List<Human> humanList;
        List<Dog> dogList;

        carList = vehicleCreator.creatorCars(positions, konsola.maxSpeedCar, konsola.safeSpeedCar);
        bicycleList = vehicleCreator.creatorBicycles(positions, konsola.maxSpeedBicycle, konsola.safeSpeedBicycle);
        humanList = pedestrianCreator.creatorHuman();
        dogList = pedestrianCreator.creatorDogs();


        for (int i = 0; i < konsola.numberCar + konsola.numberBicycle; i++) {
            int x;
            int counterA = -1;
            int counterB = -1;
            int optionA = 0;
            int optionB = 0;
            do {
                x = random.nextInt() % 2;
            } while (x < 0);
            if (x == 1 && indexCar < konsola.numberCar) {
                ++counterA;
                ++indexCar;
                if (indexCar < konsola.numberCar) {
                    Car car = new Car(konsola.maxSpeedCar, konsola.safeSpeedCar);
                    carList.add(car);
                    positions.settleCar(carList.get(indexCar), positions.mapa);
                    System.out.println("Auto nr " + (indexCar + 1) + " wjechało na mapę na pozycję [" + carList.get(indexCar).coordinateX +
                            "," + carList.get(indexCar).coordinateY + "] ");
                }
            }
            if (x == 0 && indexBicycle < konsola.numberBicycle) {
                ++counterB;
                ++indexBicycle;
                if (indexBicycle < konsola.numberBicycle) {
                    Bicycle bicycle = new Bicycle(konsola.maxSpeedBicycle, konsola.safeSpeedBicycle);
                    bicycleList.add(bicycle);
                    positions.settleBicycle(bicycleList.get(indexBicycle), positions.mapa);
                    System.out.println("Rower nr " + (indexBicycle + 1) + " wjechał na mape na pozycję [" + bicycleList.get(indexBicycle).coordinateX +
                            "," + bicycleList.get(indexBicycle).coordinateY + "] ");
                }
            }
            if (x == 1 && indexHuman < konsola.numberHuman) {
                ++indexHuman;
                if (indexHuman < konsola.numberHuman) {
                    Human human = new Human();
                    humanList.add(human);
                    positions.settleHuman(humanList.get(indexHuman), positions.mapa);
                    System.out.println("Przechodzień nr " + (indexHuman + 1) + " pojawił się w tej chwili w punkcie [" + humanList.get(indexHuman).coordinateX + "," + humanList.get(indexHuman).coordinateY + "] ");
                }
            }
            if (x == 0 && indexDog < konsola.numberDog) {
                ++indexDog;
                if (indexDog < konsola.numberDog) {
                    Dog dog = new Dog();
                    dogList.add(dog);
                    positions.settleDog(dogList.get(indexDog), positions.mapa);
                    System.out.println("Pies nr " + (indexDog + 1) + " pojawił się właśnie na pozycji [" +
                            dogList.get(indexDog).coordinateX + "," + dogList.get(indexDog).coordinateY + "] ");
                }
            }

            if (counterA == optionA) {
                do {
                    if (indexHuman < konsola.numberHuman && indexCar < konsola.numberCar) {

                        humanList.get(indexHuman).coordinateY = humanList.get(indexHuman).crossing(humanList.get(indexHuman).firstCoordinateY, humanList.get(indexHuman).coordinateY, humanList.get(indexHuman).coordinateX, positions.mapa);
                        System.out.println("Przechodzień nr " + (indexHuman + 1) + " jest  w tej chwili w punkcie [" + humanList.get(indexHuman).coordinateX + "," + humanList.get(indexHuman).coordinateY + "] ");


                        carList.get(indexCar).move(konsola.maxSpeedBicycle, carList.get(indexCar).coordinateX, carList.get(indexCar).coordinateY, positions.mapa);
                        System.out.println("Auto nr " + (indexCar + 1) + " znajduje się na mapie na pozycji [" + carList.get(indexCar).coordinateX +
                                "," + carList.get(indexCar).coordinateY + "] ");

                        if (carList.get(indexCar).coordinateX == humanList.get(indexHuman).coordinateX && carList.get(indexCar).coordinateY == humanList.get(indexHuman).coordinateY) {
                            System.out.println("MIAł MIEJSCE WYPADEK! DROGA NIE JEST BEZPIECZNA");
                            System.exit(0);
                        }
                    }
                } while ((humanList.get(indexHuman).coordinateY < 5 && humanList.get(indexHuman).coordinateY > 0) && (carList.get(indexCar).coordinateY < 31 && carList.get(indexCar).coordinateY > 0));
                optionA = counterA + 1;
            }


            if (counterB == optionB) {
                do {
                    if (indexDog < konsola.numberDog && indexBicycle < konsola.numberBicycle) {
                        dogList.get(indexDog).coordinateY = dogList.get(indexDog).crossing(dogList.get(indexDog).firstCoordinateY, dogList.get(indexDog).coordinateY, dogList.get(indexDog).coordinateX, positions.mapa);
                        System.out.println("Pies nr " + (indexDog + 1) + " znajduje się właśnie na pozycji [" +
                                dogList.get(indexDog).coordinateX + "," + dogList.get(indexDog).coordinateY + "] ");


                        bicycleList.get(indexBicycle).move(konsola.maxSpeedBicycle, bicycleList.get(indexBicycle).coordinateX, bicycleList.get(indexBicycle).coordinateY, positions.mapa);
                        System.out.println("Rower nr " + (indexBicycle + 1) + " znajduje się na mapie na pozycji [" + bicycleList.get(indexBicycle).coordinateX + "," + bicycleList.get(indexBicycle).coordinateY + "] ");

                        if (bicycleList.get(indexBicycle).coordinateX == dogList.get(indexDog).coordinateX && bicycleList.get(indexBicycle).coordinateY == dogList.get(indexDog).coordinateY) {
                            System.out.println("MIAł MIEJSCE WYPADEK! DROGA NIE JEST BEZPIECZNA");
                            System.exit(0);
                        }
                    }
                } while ((dogList.get(indexDog).coordinateY < 5 && dogList.get(indexDog).coordinateY > 0) && (bicycleList.get(indexBicycle).coordinateY < 31 && bicycleList.get(indexBicycle).coordinateY > 0));

                optionB = counterB + 1;
            }

//                for (int y = 0; y != indexBicycle; y++) {
//                    for (int w = 0; w != indexBicycle; w++) {
//                        if ((bicycleList.get(y).coordinateX == carList.get(w).coordinateX && bicycleList.get(y).coordinateY == carList.get(w).coordinateY) ||
//                                (carList.get(y).coordinateX == carList.get(konsola.numberCar - y).coordinateX && carList.get(y).coordinateY == carList.get(konsola.numberCar - y).coordinateX)) {
//                            System.out.println("NASTĄPIłA STŁUCZKA! DROGA NIE JEST BEZPIECZNA");
//                            System.exit(0);
//                        }
//                        if ((carList.get(y).coordinateX == humanList.get(y).coordinateX && carList.get(y).coordinateY == humanList.get(y).coordinateY) ||
//                                (carList.get(y).coordinateX == dogList.get(y).coordinateX && carList.get(y).coordinateY == dogList.get(y).coordinateY)) {
//                            System.out.println("MIAł MIEJSCE WYPADEK! DROGA NIE JEST BEZPIECZNA");
//                            System.exit(0);
//                        }
//                    }
//                }


            //    }
        }

    }
}
