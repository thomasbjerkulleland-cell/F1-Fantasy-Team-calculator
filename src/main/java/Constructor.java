import java.util.ArrayList;

class Constructor {
    String name;
    int price, avgPoints;
    //String[] traits = ... car prefers low/high temp, tire preserving, kerbs, low/high downforce setups

    public Constructor(String name, int price, int avgPoints){
        this.name = name;
        this.price = price;
        this.avgPoints = avgPoints;
    }
}

//Constructors list populated in separate class to make Main method less messy
class Constructors {
    ArrayList<Constructor> constructors;

    public Constructors(){
        constructors = new ArrayList<>();
        constructors.add(new Constructor("McLaren", 27900000, 165));
        constructors.add(new Constructor("Ferrari", 24700000, 142));
        constructors.add(new Constructor("Mercedes", 24200000, 142));
        constructors.add(new Constructor("Red Bull", 23300000, 136));
        constructors.add(new Constructor("Racing Bulls", 14600000, 113));
        constructors.add(new Constructor("Aston Martin", 13500000, 105));
        constructors.add(new Constructor("Kick Sauber", 12400000, 100));
        constructors.add(new Constructor("Williams", 13300000, 113));
        constructors.add(new Constructor("Haas", 14300000, 106));
        constructors.add(new Constructor("Alpine", 6000000, 92));
    }
}