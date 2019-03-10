import java.util.ArrayList;
import java.util.List;

public class Wagon {
    private int wagonId;
    private int nrOfCompartiments;
    private int compartimentSeats;
    private List<Compartiment> compartiments;

    public Wagon(int wagonId, int nrOfCompartiments, int compartimentSeats) {
        this.wagonId = wagonId;
        this.nrOfCompartiments = nrOfCompartiments;
        this.compartimentSeats = compartimentSeats;
        compartiments = new ArrayList<>();
        for (int i = 0; i < nrOfCompartiments; i++) {
            compartiments.add(new Compartiment(i, compartimentSeats));
        }
    }

    public Wagon copyWagon() {
        Wagon copy = new Wagon(wagonId, nrOfCompartiments, compartimentSeats);
        List<Compartiment> tmpCom = new ArrayList<>();
        for (Compartiment com : compartiments) {
            tmpCom.add(com.copyCompartiment());
        }
        copy.setCompartiments(tmpCom);
        return copy;
    }

    public int getFreeSeatsBetween(SeatRequest req) {
        int freeSeats = 0;
        for (Compartiment compartiment : compartiments) {
                freeSeats += compartiment.getFreeSeatsBetween(req);
        }
        return freeSeats;
    }

    public boolean reserveSeats(SeatRequest reserveReq) {
        if (getFreeSeatsBetween(reserveReq) <= reserveReq.getNrSeats()) {
            for (Compartiment com : compartiments) {
                if (com.reserveSeats(reserveReq)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getWagonId() {
        return wagonId;
    }

    public void setWagonId(int wagonId) {
        this.wagonId = wagonId;
    }

    public int getNrOfCompartiments() {
        return nrOfCompartiments;
    }

    public void setNrOfCompartiments(int nrOfCompartiments) {
        this.nrOfCompartiments = nrOfCompartiments;
    }

    public int getCompartimentSeats() {
        return compartimentSeats;
    }

    public void setCompartimentSeats(int compartimentSeats) {
        this.compartimentSeats = compartimentSeats;
    }

    public List<Compartiment> getCompartiments() {
        return compartiments;
    }

    public void setCompartiments(List<Compartiment> compartiments) {
        this.compartiments = compartiments;
    }

    public boolean reserveSeats(int compartimentId, SeatRequest req) {
        return compartiments.get(compartimentId).reserveSeats(req);
    }

    public void freeSeats(int compartimentId) {
        compartiments.get(compartimentId).freeSeats();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\tWagon ").append(wagonId).append("\n");
        for (Compartiment compartiment : compartiments) {
            str.append(compartiment.toString());
        }
        return  str.toString();
    }
}
