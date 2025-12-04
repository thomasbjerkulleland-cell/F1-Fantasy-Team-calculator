import java.util.ArrayList;

class Driver {
    String name;
    int price, avgPoints;
    //String[] traits = ... quali prowess, wet weather ability, overall pace

    public Driver(String name, int price, int avgPoints){
        this.name = name;
        this.price = price;
        this.avgPoints = avgPoints;
    }
}

//Driver list populated in separate class to make Main method less messy
class Drivers {
    ArrayList<Driver> drivers;

    public Drivers(){
        drivers = new ArrayList<>();
        drivers.add(new Driver("Norris", 28200000, 158));
        drivers.add(new Driver("Piastri", 24700000, 157));
        drivers.add(new Driver("Leclerc", 27100000, 144));
        drivers.add(new Driver("Russell", 25800000, 156));
        drivers.add(new Driver("Verstappen", 29400000, 161));
        drivers.add(new Driver("Hamilton", 21600000, 135));
        drivers.add(new Driver("Alonso", 13400000, 116));
        drivers.add(new Driver("Albon", 15700000, 129));
        drivers.add(new Driver("Hulkenberg", 8900000, 113));
        drivers.add(new Driver("Lawson", 13300000, 111));
        drivers.add(new Driver("Antonelli", 19300000, 128));
        drivers.add(new Driver("Hadjar", 14600000, 121));
        drivers.add(new Driver("Bortoleto", 12500000, 107));
        drivers.add(new Driver("Gasly", 6000000, 102));
        drivers.add(new Driver("Bearman", 18800000, 120));
        drivers.add(new Driver("Ocon", 11000000, 112));
        drivers.add(new Driver("Stroll", 10800000, 110));
        drivers.add(new Driver("Sainz", 12100000, 112));
        drivers.add(new Driver("Tsunoda", 15300000, 114));
        drivers.add(new Driver("Colapinto", 6300000, 90));
    }
}