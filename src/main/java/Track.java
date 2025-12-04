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
    float rainChance;
    TrackTemp temp;
    TrackProperties[] properties;

    public Track(int calendarNumber, String name, float rainChance, TrackTemp temp, TrackProperties[] inputProperties){
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
            (float) 3.5,
            TrackTemp.MEDIUM,
            new TrackProperties[]{TrackProperties.QUALI_DEPENDANT})
        );
    }
}