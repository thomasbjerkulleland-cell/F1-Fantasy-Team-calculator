import java.util.ArrayList;

class Team {
    ArrayList<Driver> drivers;
    Constructor constructor;
    int price, pointsAvg, constructors;
    Driver starDriver;

    public Team(){
        this.drivers = new ArrayList<>();
        this.price = 0;
        this.pointsAvg = 0;
        this.constructors = 0;
        this.starDriver = new Driver("", 0, 0);
    }

    public int addDriver(Driver driver){
        if (drivers.size() >= 5) return -1; //Team is full of drivers
        
        drivers.add(driver);
        price += driver.price;
        pointsAvg += driver.avgPoints;

        return 0;
    }

    public int removeDriver(Driver driver){
        drivers.remove(driver);

        price -= driver.price;
        pointsAvg -= driver.avgPoints;

        return 0;
    }

    public int addCons(Constructor cons){
        if (constructors >= 1){
            price -= constructor.price;
            pointsAvg -= constructor.avgPoints;
            constructor = cons;
            price += cons.price;
            pointsAvg += cons.avgPoints;
        }
        else{
            constructor = cons;
            constructors++;
            price += cons.price;
            pointsAvg += cons.avgPoints;
        }

        return 0;
    }

    public void printTeamInfo(){
        System.out.println("    Average points: " + this.pointsAvg + " (" + (this.pointsAvg - this.starDriver.avgPoints) + " pre-star)" +"    -    Price: " + this.price);
        System.out.println("    "+ this.constructor.name + ":" + "    AvgPoints: " + this.constructor.avgPoints + " Price: " + this.constructor.price);
        System.out.println("    "+ this.drivers.get(0).name + ":" + "    AvgPoints: " + this.drivers.get(0).avgPoints + " Price: " + this.drivers.get(0).price);
        System.out.println("    "+ this.drivers.get(1).name + ":" + "    AvgPoints: " + this.drivers.get(1).avgPoints + " Price: " + this.drivers.get(1).price);
        System.out.println("    "+ this.drivers.get(2).name + ":" + "    AvgPoints: " + this.drivers.get(2).avgPoints + " Price: " + this.drivers.get(2).price);
        System.out.println("    "+ this.drivers.get(3).name + ":" + "    AvgPoints: " + this.drivers.get(3).avgPoints + " Price: " + this.drivers.get(3).price);
        System.out.println("    "+ this.drivers.get(4).name + ":" + "    AvgPoints: " + this.drivers.get(4).avgPoints + " Price: " + this.drivers.get(4).price);
    }
}