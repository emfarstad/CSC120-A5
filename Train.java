import java.util.ArrayList;

public class Train {
    private final Engine engine;
    private ArrayList<Car> cars;

    /**
     * Constructs a train with a given fuelType, fuelCapacity, nCars, and passengerCapacity and initializes the engine and creates an ArrayList of nCars number of cars each with passengerCapacity
     * @param fuelType The fuelType used to create the engine
     * @param fuelCapacity The fuelCapacity used to create the engine
     * @param nCars The int number of cars the train has
     * @param passengerCapacity The int number of passengers each car can hold
     */
    public Train (FuelType fuelType, double fuelCapacity, 
    int nCars, int passengerCapacity) {
        if(fuelCapacity <= 0) {
            throw new RuntimeException("Fuel capacity too low.");
        }
        this.engine = new Engine(fuelType, fuelCapacity);

        if(nCars < 0) {
            throw new RuntimeException("Number of cars cannot be lower than 0.");
        }
        this.cars = new ArrayList<> (nCars);

        for (int i = 0; i < nCars; i++) {
            Car c = new Car(passengerCapacity);
            this.cars.add(c);
        }
    }

    /**
     * Gets the engine
     * @return the engine
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * Gets the car at index i in the cars ArrayList
     * @param i int index
     * @return The car at index i in the cars ArrayList
     */
    public Car getCar(int i) {
        if (i < 0 || i >= this.cars.size()) {
            throw new IndexOutOfBoundsException("A car does not exist at this index.");
        }
        return this.cars.get(i);
    }

    /**
     * Gets the maximum capacity of passengers for the train using the Car method getCapacity() for each car
     * @return The int maximum number of passengers the train can hold
     */
    public int getMaxCapacity() {
        int totalCapacity = 0;
        for(Car c: this.cars) {
            totalCapacity += c.getCapacity();
        }
        return totalCapacity;
    }

    /**
     * Gets the number of seats remaining on the train using the Car method seatsRemaining() for each car
     * @return The int number of seats remaining on the train
     */
    public int seatsRemaining() {
        int totalSeatsRemaining = 0;
        for(Car c: this.cars) {
            totalSeatsRemaining += c.seatsRemaining();
        }
        return totalSeatsRemaining;
    }

    /**
     * Prints the manifest of passenger names for the entire train using the Car method getManifest() for each car
     */
    public void printManifest() {
        String manifest = "";
        if(this.cars.size() == 0) {
            manifest = "This train is EMPTY.";
        } else{
            manifest += this.getCar(0).getManifest();
            for(int i = 1; i < this.cars.size(); i++){
                manifest += ", " + this.getCar(i).getManifest();
            }
        }
        if(manifest.startsWith(", ")) {
            manifest = manifest.replaceFirst(", ", "");
        }
        if(manifest.endsWith(", ")) {
            manifest = manifest.substring(0, manifest.length() - 2);
        }
        System.out.println(manifest);
    }

    public static void main(String[] args) {
        Train train = new Train(FuelType.OTHER, 100.0, 3, 12);
        System.out.println(train.cars);
        System.out.println(train.getEngine());
        System.out.println(train.getCar(2));
        //System.out.println(train.getCar(-1));
        System.out.println(train.getMaxCapacity());
        System.out.println(train.seatsRemaining());
        Passenger p = new Passenger("Person");
        Passenger g = new Passenger("Johanna");
        Passenger j = new Passenger("Jordan");
        g.boardCar(train.getCar(1));
        j.boardCar(train.getCar(1));
         System.out.println(train.seatsRemaining());
        train.printManifest();
        //train.getCar(2).addPassenger(p);
        train.getCar(1).addPassenger(p); // how to throw exception for if passenger is on board another car?
        System.out.println(train.seatsRemaining());
        train.printManifest();
        j.getOffCar(train.getCar(1));
        System.out.println(train.seatsRemaining());
        train.printManifest();
        train.getEngine().refuel();
        train.getEngine().go();
    }

}
