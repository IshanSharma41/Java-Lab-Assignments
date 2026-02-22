import java.time.Year;

public class MainVehicle{
    public static void main(String[] a){
        Vehicle v = new Vehicle();
        Vehicle v1 = new Vehicle("Mahindra", "Thar", Year.of(2022), "White", 1500000.50);
        v1.setMfgCode("THR2878822");
        v1.setNoOfServices(2);
        Vehicle v2 = new Vehicle(7, 2000000.00, 'D', "MND2022THAR", 3);
        int newSp = v.accelerate(20);
        System.out.println("New Speed: " + newSp);
        //float m = v.calcMileage(40, 500);
        //System.out.println("Mileage is: " + m + " km/litre");
        // float m1 = v1.calcMileage(200, 36);
        // System.out.println("Mileage of v1 is: " + m1 + " km/litre");

        Vehicle[] garage = new Vehicle[3];
        garage[0] = v;
        garage[1] = v1;
        garage[2] = v2;
        for(int i = 0; i < garage.length; i++){
            printDetails(garage[i]);
            garage[i].start();
            garage[i].drive();
            garage[i].accelerate(20);
            float m = garage[i].calcMileage(50, 500);
            System.out.println("Mileage is: " + m + " km/litre");
            garage[i].stop();
        }
    }

    public static void printDetails(Vehicle v){
        System.out.println("-----------------------------------------");
        System.out.println("------------Vehicle Details--------------");
        System.out.println("-----------------------------------------");
        System.out.println("Brand Name: " + v.brand);
        System.out.println("Model: " + v.model);
        System.out.println("Year of MFG: " + v.yearofMfg);
        System.out.println("Color of the vehicle: " + v.color);
        System.out.println("Fuel Type: " + v.fuelType);
    }
}

        