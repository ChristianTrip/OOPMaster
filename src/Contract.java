public class Contract  {

    private Band band;
    private Event event;
    private double price;
    private double duration;
    private String conditions;

    public Contract(Band band, Event event, double price, double duration, String conditions) {
        this.band = band;
        this.event = event;
        this.price = price;
        this.duration = duration;
        this.conditions = conditions;
    }

    public Band getBand() {
        return band;
    }
    @Override
    public String toString() {
        return "Contract{" +
                "band = " + band +
                ", event = " + event +
                ", price = " + price +
                ", duration = " + duration +
                ", conditions = '" + conditions + '\'' +
                '}';
    }
}
