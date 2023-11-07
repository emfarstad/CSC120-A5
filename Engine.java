public class Engine {
    /** the fuelType, one of STEAM, INTERNAL_COMBUSTION, ELECTRIC, OTHER */
    private FuelType f;
    /** the current fuel level of the engine, between 0 and the maxFuelLevel value*/
    private double currentFuelLevel;
    /** the maximum capacity of the engine's fuel tank*/
    private final double maxFuelLevel;

    /**
     * Constructs an engine with a given FuelType and a given maxFuelLevel and sets currentFuelLevel to 0
     * @param f FuelType
     * @param maxFuelLevel double maximumFuel the engine can hold
     */
    public Engine(FuelType f, double maxFuelLevel) {
        this.f = f;
        this.currentFuelLevel = 0;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Returns the current fuel level of the engine
     * @return the current fuel level of the engine as a double
     */
    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }

    /**
     * Sets currentFuelLevel of the engine to maxFuelLevel
     */
    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /**
     * If the currentFuelLevel is greater or equal to 10, the currentFuelLevel is depleted by 10 and a statement is printed with the new fuel level
     */
    public void go() {
        if(getCurrentFuelLevel() < 10) {
            throw new RuntimeException("Current fuel level is too low, please refuel the engine.");
        }
        this.currentFuelLevel = this.currentFuelLevel - 10;
        System.out.println("The fuel level is now " + this.currentFuelLevel);
    }

    public static void main(String args[]) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 120.0);
        myEngine.refuel();
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}