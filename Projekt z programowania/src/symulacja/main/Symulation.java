package symulacja.main;

import symulacja.mapa.MapSimple;
import symulacja.mapa.Mapa;
import symulacja.mapa.creator.MapaCreator;
import symulacja.mapa.creator.PedestrianCreator;
import symulacja.mapa.creator.PedestrianCreatorList;
import symulacja.mapa.creator.VehicleCreatorList;
import symulacja.participants.pedestrian.Pedestrian;
import symulacja.participants.vehicle.Bicycle;
import symulacja.participants.vehicle.Car;
import symulacja.participants.vehicle.VehicleFunction;

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
        Symulation symulation = new Symulation(mapa, pedestrianCreator, vehicleCreator );

        List<VehicleFunction> carList;
        List<VehicleFunction> bicycleList;
        List<Pedestrian> humanList;
        List<Pedestrian> dogList;

        carList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedCar);
        bicycleList = vehicleCreator.creatorCars(mapa, konsola.maxSpeedBicycle);
        humanList = pedestrianCreator.creatorHuman();
        dogList = pedestrianCreator.creatorDogs();
        
        indexBicycle = 0;
        int indexCar = 0;
        int indexHuman=0;
        int indexDog=0;

        for (int i = 0; i < konsola.numberVehicle; i++) {
           int x;
            Random random = new Random();
            x = random.nextInt() % 2;
            if (x == 1 && indexCar<konsola.numberCar) {
              Car car = new Car(konsola.maxSpeedCar,Vehicle.speed(konsola.maxSpeedCar));
                carList.get(indexCar)=car;
               carList(indexcar).coordinateX();
               carList(indexcar).coordinateY();
               indexCar++;
           }
            if(x==0 && indexBicycle<konsola.numberBicycle){
               Bicycle bicycle = new Bicycle(konsola.maxSpeedBicycle,Bicycle.speed(konsola.maxSpeedBicycle));
                listBicycle[indexBicycle] = bicycle;
               listBicycle[indexBicycle].coordinateX();
                listBicycle[indexBicycle].coordinateY();
                indexBicycle++;
           }
           if(x==1 && indexHuman<konsola.numberHuman){
              Human human = new Human();
               listHuman(indexHuman) = human;
               indexHuman++;
             }
            if(x==0 && indexDog<konsola.numberDog){
             Dog dog = new Dog();
             listDog(indexDog) = dog;
             indexDog++;
            for (int y = 0; ; y++) {
            if(y<numberBicycle){
         bicycleList(y).move(konsola.maxSpeedBicycle);
         System.out.println("Rower nr" + (y + 1) + "znajduje się na mapie na pozycji x" + bicycleList(y).coordinateX + " i pozycji y" + bicycleList(y).coordinateY);
         }

        if(y<numberCar)
        {
            carList(y).move(konsola.maxSpeedCar);
            System.out.println("Auto nr" + (y + 1) + "znajduje się na mapie na pozycji x" + carList(y).coordinateX +
                    "i pozycji y" + carList.coordinateY);
        }
        if(y<numberDog){
            dogList(y).move();
            System.out.println("Pies nr " y+1" znajduje sie wlasnie w pozycji"dogList(y).coordinateX "x i "dog.List(y).coordinateY"y");
        }
        if(y<numberHuman){
            humanList(y).move();
            System.out.println("Przechodzien nr jest  w tej chwili w puncie"humnaList.coordinateX" "humanList.coordinateY);
        }

        for (int y = 0; y != indexBicycle; y++) {
            for (int w = 0; w != indexBicycle; w++) {
                if ((bicycleList(y).coordinateX == carList(w).coordinateX && biclycleList(y).coordinateY == carList(w).coordinateY ) ||
                        (caList(y).coordinateX==carList(numberCar-y).coordinateX && caList(y).coordinateY==carList(numberCar-y).coordinateX)) {
                    System.out.println("NASTĄPILA STŁUCZKA! DROGA NIE JEST BEZPIECZNA");
                System.exit(0);
                }
                if((carList(y).coordinateX==humanList(y).coordniateX && carList(y).coordinateY==humanList(y).coordniateY)|| 
                        (carList(y).coordinateX==dogList(y).coordniateX && carList(y).coordinateY==humanList(y).coordniateY)){
                    System.out.println("MIAL MIEJSCE WYPADEK! DROGA NIE JEST BEZPIECZNA");
                    System.exit(0);}
                }
            }          
        }
    }
 }

