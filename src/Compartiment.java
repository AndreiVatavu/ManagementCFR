import java.util.ArrayList;
import java.util.List;

public class Compartiment{
    private int compartimentId;
    private int totalSeats;
    private List<Seat> seats;

    public Compartiment(int compartimentId, int totalSeats) {
        this.compartimentId = compartimentId;
        this.totalSeats = totalSeats;
        seats = new ArrayList<>(totalSeats);
        for (int i = 0; i < totalSeats; i++) {
            seats.add(new Seat(i));
        }
    }

    public Compartiment copyCompartiment() {
        Compartiment copy = new Compartiment(compartimentId, totalSeats);
        List<Seat> tmpSeats = new ArrayList<>();
        for (Seat seat : seats) {
            tmpSeats.add(seat.copySeat());
        }
        copy.setSeats(tmpSeats);
        return copy;
    }

    public boolean reserveSeats(SeatRequest reserveReq) {
        if (getFreeSeatsBetween(reserveReq) >= reserveReq.getNrSeats()) {
            for (int station = reserveReq.getFromStation(); station < reserveReq.getToStation(); station++) {
                int seatNr = 0;
                int j = 0;
                while (seatNr < reserveReq.getNrSeats()) {
                    if (!seats.get(j).isReserved(station)) {
                        seats.get(j).reserve(station);
                        seatNr++;
                    }
                    j++;
                }
            }
            return true;
        }
        return false;
    }

    public void freeSeats() {

    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getFreeSeats(int station) {
        int freeSeats = 0;
        for (Seat seat : seats) {
            if (!seat.isReserved(station)) {
                freeSeats++;
            }
        }
        return freeSeats;
    }

    public int getReservedSeats(int station) {
        int reservedSeats = 0;
        for (Seat seat : seats) {
            if (seat.isReserved(station)) {
                reservedSeats++;
            }
        }
        return reservedSeats;
    }

    public int getFreeSeatsBetween(SeatRequest req) {
        int freeSeats = getFreeSeats(req.getFromStation());
        for (int i = req.getFromStation() + 1; i < req.getToStation(); i++) {
            int free = getFreeSeats(i);
            if (freeSeats > free) {
                freeSeats = free;
            }
        }
        return freeSeats;
    }

    public boolean isEmpty(SeatRequest req) {
        return getFreeSeatsBetween(req) == totalSeats;
    }

    public int getCompartimentId() {
        return compartimentId;
    }

    public void setCompartimentId(int compartimentId) {
        this.compartimentId = compartimentId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\t\tCompartiment ").append(compartimentId).append("\n");
        for (Seat seat : seats) {
            str.append(seat.toString());
        }
        return str.toString();
    }
}
