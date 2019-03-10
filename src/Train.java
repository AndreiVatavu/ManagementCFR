import java.util.*;

public class Train {
    private int trainId;
    private int nrOfWagons;
    private int nrOfCompartiments;
    private int nrOfCompartimentSeats;
    private int currentStation;
    private List<Wagon> wagons;
    private List<SeatRequest> seatRequests = new ArrayList<>();


    public Train(int trainId, int nrOfWagons, int nrOfCompartiments, int nrOfCompartimentSeats) {
        this.nrOfWagons = nrOfWagons;
        this.nrOfCompartiments = nrOfCompartiments;
        this.nrOfCompartimentSeats = nrOfCompartimentSeats;
        this.currentStation = -1;
        wagons = new ArrayList<>(nrOfWagons);
        for (int i = 0; i < nrOfWagons; i++) {
            wagons.add(new Wagon(i, nrOfCompartiments, nrOfCompartimentSeats));
        }
    }

    public void updateSeats(List<SeatRequest> requests) {
        currentStation++;
        List<Wagon> tmpWagons = new ArrayList<>();
        for (Wagon wagon : wagons) {
            tmpWagons.add(wagon.copyWagon());
        }
        seatRequests.addAll(requests);
        List<SeatRequest> removeSeats = new ArrayList<>();

        for (SeatRequest req : seatRequests) {
            int max = 0;
            int w = -1, c = -1;

            for (int wagon = 0; wagon < tmpWagons.size(); wagon++) {
                List<Compartiment> compartiments = tmpWagons.get(wagon).getCompartiments();
                for (int compartiment = 0; compartiment < compartiments.size(); compartiment++) {
                    int freeSeats = compartiments.get(compartiment).getFreeSeatsBetween(req);
                    if (freeSeats > max) {
                        max = freeSeats;
                        c = compartiment;
                        w = wagon;
                    }
                    if (max == nrOfCompartimentSeats) {
                        break;
                    }
                }
                if (max == nrOfCompartimentSeats) {
                    break;
                }
            }
            if (max == 0) {

            } else if (tmpWagons.get(w).reserveSeats(c, req)) {
                if (req.getFromStation() == currentStation) {
                    wagons.get(w).reserveSeats(c, req);
                    removeSeats.add(req);
                }
            }
        }
        for (SeatRequest req : removeSeats) {
            seatRequests.remove(req);
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Trenul ").append(trainId).append("\n");
        for (Wagon wagon : wagons) {
            str.append(wagon.toString());
        }
        return str.toString();
    }
}
