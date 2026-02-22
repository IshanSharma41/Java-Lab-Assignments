import java.time.Year;

class Vehicle {

    String brand;
    String model;
    Year yearofMfg;
    String color;
    char fuelType;
    int seats;
    double price;
    String mfgCode;
    int noOfServices;
    int speed;

    // Default constructor
    Vehicle() {
        brand = "Toyota";
        model = "Camry";
        yearofMfg = Year.of(2020);
        color = "Blue";
        fuelType = 'P';
        seats = 5;
        price = 2400000;
        mfgCode = "NA";
        noOfServices = 0;
        speed = 0;
    }

    // Parameterized constructor
    Vehicle(String brand, String model, Year yearofMfg, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.yearofMfg = yearofMfg;
        this.color = color;
        this.price = price;

        fuelType = 'P';
        seats = 5;
        mfgCode = "NA";
        noOfServices = 0;
        speed = 0;
    }

    // Parameterized constructor
    Vehicle(int seats, double price, char fuelType, String mfgCode, int noOfServices) {
        brand = "Unknown";
        model = "Unknown";
        yearofMfg = Year.now();
        color = "Black";

        this.seats = seats;
        this.price = price;
        this.fuelType = fuelType;
        this.mfgCode = mfgCode;
        this.noOfServices = noOfServices;
        speed = 0;
    }

    void start() {
        System.out.println("Vehicle started");
    }

    void drive() {
        System.out.println("Vehicle is driving");
    }

    void stop() {
        System.out.println("Vehicle stopped");
        speed = 0;
    }

    int accelerate(int incSpeed) {
        speed += incSpeed;
        return speed;
    }

    float calcMileage(float distance, float fuel) {
        float baseMileage = distance / fuel;

        if (fuelType == 'P') {
            return baseMileage + 5;
        } else if (fuelType == 'D') {
            return baseMileage + 3;
        } else {
            return baseMileage;
        }
    }

    void setMfgCode(String mCode) {
        mfgCode = mCode;
    }

    String getMfgCode() {
        return mfgCode;
    }

    void setNoOfServices(int nService) {
        noOfServices = nService;
    }

    int getNoOfServices() {
        return noOfServices;
    }
}