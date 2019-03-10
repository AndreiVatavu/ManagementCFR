import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static int STATIONS_NUMBER = 7;
    public static int WAGONS_NUMBER = 5;
    public static int WAGON_COMPARTIMENTS = 10;
    public static int COMPARTIMENT_SEATS = 8;
    public static int MAX_GROUP_NUMBER = 5;

    public static void main(String[] args) {
        List<SeatRequest> requests = new ArrayList<>();
        Train train = new Train(0, WAGONS_NUMBER, WAGON_COMPARTIMENTS, COMPARTIMENT_SEATS);
        Scanner sc = new Scanner(System.in);

        String input;
        while ((input = sc.nextLine()) != null) {
            String[] parts = input.split(" ");
            try {
                switch (parts[0].toLowerCase()) {
                    case "reserve":
                        try {
                            int fromStation = Integer.parseInt(parts[1]);
                            int toStation = Integer.parseInt(parts[2]);
                            int nrSeats = Integer.parseInt(parts[3]);
                            if (toStation <= fromStation || fromStation < 0 || toStation > STATIONS_NUMBER) {
                                throw new Exception("Invalid stations pair");
                            }
                            if (nrSeats < 1 || nrSeats > MAX_GROUP_NUMBER) {
                                throw  new Exception("Invalid number of seats");
                            }
                            SeatRequest req = new SeatRequest(nrSeats, fromStation, toStation);
                            requests.add(req);
                        } catch (Exception e) {
                            System.out.println("Invalid command: " + e.getMessage());
                        }
                        break;
                    case "update":
                        Collections.sort(requests);
                        train.updateSeats(requests);
                        requests.clear();
                        System.out.println(train);
                        break;
                    case "show":
                        System.out.println(train);
                        break;
                    case "exit":
                        throw new Exception("Exit");
                    default:
                        System.out.println("Invalid command");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        sc.close();
    }
}
