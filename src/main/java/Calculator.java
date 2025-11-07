import java.util.ArrayList;
import java.util.Scanner;

class Driver {
    String name;
    int price, avgPoints;

    public Driver(String name, int price, int avgPoints){
        this.name = name;
        this.price = price;
        this.avgPoints = avgPoints;
    }
}

class Constructor {
    String name;
    int price, avgPoints;

    public Constructor(String name, int price, int avgPoints){
        this.name = name;
        this.price = price;
        this.avgPoints = avgPoints;
    }
}

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

public class Calculator {
    static ArrayList<Driver> allDrivers = new ArrayList<>();
    static ArrayList<Constructor> constructors = new ArrayList<>();
    static int budget = 122603000; //MONEY TO SPEND!
    static ArrayList<Driver> setDrivers = new ArrayList<>();
    static boolean searchCons = true;
    static String setConstructor = ""; 

    static ArrayList<Team> teams = new ArrayList<>();
    
    public static void main(String[] args) throws Exception {
        fillArrays();
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("****************Configuration****************");
            System.out.println("1: Run with current settings (none default)");
            System.out.println("2: Change spending budget");
            System.out.println("3: Change owned drivers");
            System.out.println("4: Change owned constructor");
            System.out.println("5: Change unavailable drivers");
            System.out.println("6: Change unavailable constructor");
            System.out.println("q: Terminate the program");

            String mode = input.nextLine();

            if(mode.equals("1")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            }
            else if(mode.equals("2")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter new budget: (format: 100000000 or 100 000 000 or 100.000.000)");
                String spending = input.nextLine().replaceAll("\\s+", " ").replaceAll(" ", "").replaceAll(".", "");
                budget = Integer.parseInt(spending);
            }
            else if(mode.equals("3")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter owned drivers (format: lastnames separated by spaces):");
                String[] owned = input.nextLine().toLowerCase().replaceAll("\\s+", " ").split(" ");
                for(String name : owned){
                    setDrivers.add(findDriverByName(name));
                    allDrivers.remove(findDriverByName(name));
                }
            }
            else if(mode.equals("4")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter owned constructor:");
                String owned = input.nextLine().toLowerCase();
                searchCons = false;
                setConstructor = owned;
            }
            else if(mode.equals("5")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter unavailable drivers (format: lastnames separated by spaces):");
                String[] locked = input.nextLine().toLowerCase().split(" ");
                int lockedLen = locked.length;
                ArrayList<Driver> driversToRemove = new ArrayList<>();
                for(Driver driver : allDrivers){
                    for(int i = 0; i < lockedLen; i++){
                        if(driver.name.toLowerCase().equals(locked[i])) driversToRemove.add(driver);
                    }
                }
                for(Driver driver : driversToRemove){
                    allDrivers.remove(driver);
                }
            }
            else if(mode.equals("6")){
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Enter locked constructor:");
                String locked = input.nextLine().toLowerCase();
                constructors.remove(findConsByName(locked));
            }
            else if(mode.equals("q")){
                input.close();
                System.out.print("Goodbye!");
                System.exit(0);
            }
        }
        input.close();
        long start = System.nanoTime();
        createTeams();
        long end = System.nanoTime();
        System.out.println("Generating teams took " + ((end-start)/1000000) + " ms");

        ArrayList<Team> starTeams = new ArrayList<>();
        for(Team team : teams){
            for(Driver driver : team.drivers){
                if(driver.price<18000000){
                    Team clone = cloneTeam(team);
                    clone.starDriver = driver;
                    clone.pointsAvg += driver.avgPoints;
                    starTeams.add(clone);
                }
            }
        }

        for(Team t : starTeams) teams.add(t);

        start = System.nanoTime();
        teams.sort((a, b) -> Integer.compare(b.pointsAvg, a.pointsAvg));
        end = System.nanoTime();
        System.out.println("Sorting teams took " + ((end-start)/1000000) + " ms");

        for(int i = 0; i < 5; i++){
            Team team = teams.get(i);
            System.out.println("\nTeam " + (i+1) + ":");
            team.printTeamInfo();
        }
    }

    public static void createTeams(){
        for(Constructor cons : constructors){
            Team myTeam = new Team();
            myTeam.addCons(cons);
            for(Driver driver : setDrivers){
                myTeam.addDriver(driver); 
            }
            if(!searchCons) myTeam.addCons(findConsByName(setConstructor));
            recursion(myTeam, 0);
            if(!searchCons) break;
        }
    }

    private static void recursion(Team myTeam, int filled){
        if(myTeam.drivers.size()==5 && myTeam.constructors == 1){
            if(myTeam.price <= budget) teams.add(cloneTeam(myTeam));
            return;
        }

        for (int i = filled; i < allDrivers.size(); i++) {
            myTeam.addDriver(allDrivers.get(i));
            recursion(myTeam, i + 1);
            myTeam.removeDriver(myTeam.drivers.get(myTeam.drivers.size()-1));
        }
    }

    private static Team cloneTeam(Team original) {
        Team copy = new Team();
        copy.constructor = original.constructor; 
        copy.constructors = original.constructors;
        copy.price = original.price;
        copy.pointsAvg = original.pointsAvg;

        for (Driver d : original.drivers) {
            copy.drivers.add(d);
        }

        return copy;
    }

    private static Constructor findConsByName(String name){
        for(Constructor cons : constructors){
            if(cons.name.toLowerCase().equals(name)) return cons;
        }

        return constructors.get(0);
    }

    private static Driver findDriverByName(String name){
        for(Driver driver : allDrivers){
            if(driver.name.toLowerCase().equals(name)) return driver;
        }

        return allDrivers.get(0);
    }
    
    public static void fillArrays(){
        allDrivers.add(new Driver("Norris", 28200000, 158));
        allDrivers.add(new Driver("Piastri", 24700000, 157));
        allDrivers.add(new Driver("Leclerc", 27100000, 144));
        allDrivers.add(new Driver("Russell", 25800000, 156));
        allDrivers.add(new Driver("Verstappen", 29400000, 161));
        allDrivers.add(new Driver("Hamilton", 21600000, 135));
        allDrivers.add(new Driver("Alonso", 13400000, 116));
        allDrivers.add(new Driver("Albon", 15700000, 129));
        allDrivers.add(new Driver("Hulkenberg", 8900000, 113));
        allDrivers.add(new Driver("Lawson", 13300000, 111));
        allDrivers.add(new Driver("Antonelli", 19300000, 128));
        allDrivers.add(new Driver("Hadjar", 14600000, 121));
        allDrivers.add(new Driver("Bortoleto", 12500000, 107));
        allDrivers.add(new Driver("Gasly", 6000000, 102));
        allDrivers.add(new Driver("Bearman", 18800000, 120));
        allDrivers.add(new Driver("Ocon", 11000000, 112));
        allDrivers.add(new Driver("Stroll", 10800000, 110));
        allDrivers.add(new Driver("Sainz", 12100000, 112));
        allDrivers.add(new Driver("Tsunoda", 15300000, 114));
        allDrivers.add(new Driver("Colapinto", 6300000, 90));


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
