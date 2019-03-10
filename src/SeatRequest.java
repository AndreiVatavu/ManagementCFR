public class SeatRequest implements Comparable{
    private int nrSeats;
    private int fromStation;
    private int toStation;

    public SeatRequest(int nrSeats, int fromStation, int toStation) {
        this.nrSeats = nrSeats;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    public int getNrSeats() {
        return nrSeats;
    }

    public void setNrSeats(int nrSeats) {
        this.nrSeats = nrSeats;
    }

    public int getFromStation() {
        return fromStation;
    }

    public void setFromStation(int fromStation) {
        this.fromStation = fromStation;
    }

    public int getToStation() {
        return toStation;
    }

    public void setToStation(int toStation) {
        this.toStation = toStation;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Number of seats ").
                append(nrSeats).append(" from station ").
                append(fromStation).
                append(" to station ").
                append(toStation);
        return str.toString();
    }

    @Override
    public int compareTo(Object o) {
        SeatRequest req = (SeatRequest) o;
        return req.getNrSeats() - nrSeats;
    }
}
