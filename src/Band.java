public class Band  {

    private String bandName;
    private int numOfMembers;
    private double bookingPrice;
    private Contract bandContract;


    public Band(String bandName, int numOfMembers, double bookingPrice) {
        this.bandName = bandName;
        this.numOfMembers = numOfMembers;
        this.bookingPrice = bookingPrice;
    }

    public String getBandName() {
        return bandName;
    }

    public Contract getBandContract() {
        return bandContract;
    }
    @Override
    public String toString() {
        return "BAND--------------------    " +
                "\nBandName = '" + bandName + '\'' +
                "\nNumber Of Members = " + numOfMembers +
                "\nBooking Price = " + bookingPrice;
    }
}
