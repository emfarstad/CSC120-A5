import java.util.ArrayList;

public class Car {

    /** An arraylist of Passenger objects representing the passengers on the train car*/
    private ArrayList<Passenger> passengersOnboard;

    /** the maximum capacity of passengers that can be on the train car*/
    private int maxCapacity;

    /**
     * Constructs a car with a given maxCapacity and creates an ArrayList of size maxCapacity of passengers
     * @param maxCapacity The int maxCapacity of the car
     */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<> (this.maxCapacity);
    }

    /**
     * Gets the maxCapacity of the car
     * @return the int maxCapacity of the car
     */
    public int getCapacity() {
        return this.maxCapacity;
    }

    /**
     * Gets the number of seats remaining in the car
     * @return the int number of available seats
     */
    public int seatsRemaining() {
        return this.maxCapacity - this.passengersOnboard.size();
    }

    /**
     * If the car does not already contain the passenger and the number of seats remaining is not zero, the passenger is added to the passengersOnBoard ArrayList
     * @param p The passenger
     */
    public void addPassenger(Passenger p) {
        if(this.passengersOnboard.contains(p)) {
            throw new RuntimeException("Passenger is already onboard.");
        }
        if(seatsRemaining() == 0) {
            throw new RuntimeException("There are no available seats in this car.");
        }
        this.passengersOnboard.add(p);
    }

    /**
     * If the car contains the passenger, the passenger is removed from the passengersOnBoard ArrayList
     * @param p The passenger
     */
    public void removePassenger(Passenger p) {
        if(!this.passengersOnboard.contains(p)) {
            throw new RuntimeException("Passenger is not in this car and cannot be removed.");
        }
        this.passengersOnboard.remove(p);
    }

    /**
     * Creates a manifest of the names of all of the passengers in the car
     * @return a String containing the names of all of the passengers in the car
     */
    public String getManifest() {
        String manifest = "";
        if(!(this.passengersOnboard.size() == 0)) {
            manifest += this.passengersOnboard.get(0).getName();
            for(int i = 1; i < this.passengersOnboard.size(); i++) {
                manifest += ", " + this.passengersOnboard.get(i).getName();
            }
        }
        return manifest;
    }

    /**
     * Prints the manifest of all of the passengers in the car, or if there are none, prints the statement "This car is EMPTY."
     */
    public void printManifest() {
        if(getManifest().equals("")) {
            System.out.println("This car is EMPTY.");
        } else {
            System.out.println(getManifest());
        }
    }

    public static void main(String[] args) {
        Passenger jordan = new Passenger("Jordan");
        Passenger johanna = new Passenger("Johanna");
        //Passenger who = new Passenger("who");
        Car car1 = new Car(2);
        Car car2 = new Car(10);
        car1.addPassenger(jordan);
        car1.addPassenger(johanna);
        car1.printManifest();
        car2.printManifest();
        car1.removePassenger(jordan);
        car1.removePassenger(johanna);
        //car1.removePassenger(johanna);
        car1.printManifest();
        car2.printManifest();
    }
}