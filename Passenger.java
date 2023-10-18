public class Passenger {
    
    private String name;

    /**
     * Constructs a passenger with a given name
     * @param name The String the passenger is named
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the passenger
     * @return The String name of the passenger
     */
    public String getName() {
        return this.name;
    }

    /**
     * Using the addPassenger method in the car class, a passenger is added to a car's passengersOnBoard ArrayList or an exception is thrown
     * @param c The car the passenger is trying to be added to
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
        } catch (RuntimeException e){
            System.out.println(e);
        }
    }

    /**
     * Using the removePassenger method in the car class, a passenger is removed from a car's passengersOnBoard ArrayList or an exception is thrown
     * @param c The car the passenger is trying to be removed from
     */
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
        } catch (RuntimeException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        Passenger jordan = new Passenger("Jordan");
        Passenger johanna = new Passenger("Johanna");
        //Passenger who = new Passenger("who");
        Car car1 = new Car(2);
        Car car2 = new Car(10);
        
        jordan.boardCar(car1);
        johanna.boardCar(car1);
        //johanna.boardCar(car1);
        johanna.boardCar(car2); //how do I make it so that this can't happen?
        johanna.getOffCar(car2);
        //jordan.getOffCar(car2);
    }
}
