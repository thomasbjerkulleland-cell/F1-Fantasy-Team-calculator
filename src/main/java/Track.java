import java.util.ArrayList;

enum TrackProperties{
    HIGH_DEG,
    QUALI_DEPENDANT
}

enum TrackTemp{
    HIGH,
    MEDIUM,
    LOW
}

class Track {
    int calendarNumber;
    String name;
    double rainChance;
    TrackTemp temp;
    TrackProperties[] properties;

    public Track(int calendarNumber, String name, double rainChance, TrackTemp temp, TrackProperties[] inputProperties){
        this.calendarNumber = calendarNumber;
        this.name = name;
        this.rainChance = rainChance;
        this.temp = temp;
        this.properties = new TrackProperties[inputProperties.length];
    }
}

class Tracks {
    ArrayList<Track> tracks;

    public Tracks(){
        tracks = new ArrayList<>();
        tracks.add(new Track(
            1,
            "Australia",
            15.5,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            2,
            "China",
            27.4,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            3,
            "Japan",
            24.8,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            4,
            "Bahrain",
            1.9,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );

        tracks.add(new Track(
            5,
            "Jeddah",
            0.4,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            6,
            "Miami",
            29.0,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            7,
            "Canada",
            24.8,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            8,
            "Monaco",
            6.9,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            9,
            "Barcelona",
            12.3,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            10,
            "Austria",
            30.4,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            11,
            "Silverstone",
            21.8,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            12,
            "Spa",
            33.7,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            13,
            "Hungary",
            20.2,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            14,
            "Netherlands",
            31.3,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            15,
            "Monza",
            24.0,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            16,
            "Madrid",
            9.6,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            17,
            "Baku",
            11.9,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            18,
            "Singapore",
            39.3,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            19,
            "Austin",
            12.9,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            20,
            "Mexico",
            22.6,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            21,
            "Brazil",
            24.8,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            22,
            "Las Vegas",
            2.5,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            23,
            "Qatar",
            3.5,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
        tracks.add(new Track(
            24,
            "Abu Dhabi",
            0.9,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
    }
}