import java.util.ArrayList;

public class Event {

    static int numberOfEvents;

    private String eventName;
    private String eventLocation;
    private String date;
    private ArrayList<Band> playingBands;

    public Event(String eventName, String eventLocation, String date) {
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.date = date;
        playingBands = new ArrayList<>();
        numberOfEvents ++;

    }

    public String printPlayingBands() {

        String bandNames = "";

        for (Band band : playingBands) {
            bandNames += band.getBandName() + ", ";
        }

        return bandNames;
    }

    public ArrayList<Band> getPlayingBands() {
        return playingBands;
    }

    public Band getBandFromPlayingBand(int indexNumber){
        return playingBands.get(indexNumber);
    }

    public void setPlayingBands(Band band) {
        this.playingBands.add(band);
    }

    public String getEventName() {
        return eventName;
    }
    @Override
    public String toString() {
        return  "Event name:    '" + eventName + "\'\n" +
                "Location:      '" + eventLocation + "\'\n" +
                "Date:           " + date + "\n" +
                "Bands playing:  " + getPlayingBands() + "\n";
    }
}
