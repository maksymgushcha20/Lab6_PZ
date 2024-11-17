import java.util.Objects;

/**
 * Базовий клас Aircraft представляє загальні характеристики літаків.
 */
abstract class Aircraft {
    private String model;
    private int capacity;
    private double cargoCapacity;
    private double range;
    private double fuelConsumption;

    public Aircraft(String model, int capacity, double cargoCapacity, double range, double fuelConsumption) {
        this.model = model;
        this.capacity = capacity;
        this.cargoCapacity = cargoCapacity;
        this.range = range;
        this.fuelConsumption = fuelConsumption;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public double getRange() {
        return range;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    @Override
    public String toString() {
        return model + " (Capacity: " + capacity + ", Cargo: " + cargoCapacity + "t, Range: " + range + "km, Fuel: " + fuelConsumption + "L/100km)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aircraft aircraft = (Aircraft) obj;
        return capacity == aircraft.capacity &&
                Double.compare(aircraft.cargoCapacity, cargoCapacity) == 0 &&
                Double.compare(aircraft.range, range) == 0 &&
                Double.compare(aircraft.fuelConsumption, fuelConsumption) == 0 &&
                Objects.equals(model, aircraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, capacity, cargoCapacity, range, fuelConsumption);
    }
}

/**
 * Клас PassengerAircraft представляє пасажирський літак.
 */
class PassengerAircraft extends Aircraft {
    public PassengerAircraft(String model, int capacity, double cargoCapacity, double range, double fuelConsumption) {
        super(model, capacity, cargoCapacity, range, fuelConsumption);
    }
}

/**
 * Клас CargoAircraft представляє вантажний літак.
 */
class CargoAircraft extends Aircraft {
    public CargoAircraft(String model, double cargoCapacity, double range, double fuelConsumption) {
        super(model, 0, cargoCapacity, range, fuelConsumption); // Capacity = 0 для вантажних літаків
    }
}

/**
 * Клас MilitaryAircraft представляє військовий літак.
 */
class MilitaryAircraft extends Aircraft {
    public MilitaryAircraft(String model, int capacity, double cargoCapacity, double range, double fuelConsumption) {
        super(model, capacity, cargoCapacity, range, fuelConsumption);
    }
}
