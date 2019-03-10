import java.util.ArrayList;
import java.util.List;

public class Seat {
    int seatId;
    List<Boolean> stations = new ArrayList<>(Main.STATIONS_NUMBER);

    public Seat(int seatId) {
        this.seatId = seatId;
        for (int i = 0; i < Main.STATIONS_NUMBER; i++) {
            stations.add(false);
        }
    }

    public Seat copySeat() {
        Seat copy = new Seat(seatId);
        List<Boolean> tmpStations = new ArrayList<>(Main.STATIONS_NUMBER);
        for (Boolean b : stations) {
            tmpStations.add(Boolean.valueOf(b));
        }
        return copy;
    }

    public boolean isReserved(int station) {
        return  stations.get(station);
    }

    public void reserve(int station) {
        stations.set(station, true);
    }

    public void freeSeat(int station) {
        stations.set(station, false);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\t\t\tSeat ").append(seatId).append("\n");
        for (int i = 0; i < Main.STATIONS_NUMBER; i++) {
            str.append("\t\t\t\tStation ").append(i).append(": ").append(stations.get(i).toString());
        }
        str.append("\n");
        return str.toString();
    }
}
