import java.util.*;

class Participant {
    private String name, id, status;
    private double fee;

    Participant(String name, String id, double fee) {
        this.name = name;
        this.id = id;
        this.fee = fee;
        this.status = "Registered";
    }

    void display() {
        System.out.println(name + " | " + id + " | ₹" + fee + " | " + status);
    }
}

class Event {
    private int capacity;
    private double fee;
    private ArrayList<Participant> participants = new ArrayList<>();

    Event(int capacity, double fee) {
        this.capacity = capacity;
        this.fee = fee;
    }

    void register(String name, String id) throws Exception {
        if (participants.size() >= capacity) {
            throw new Exception("Event capacity is full!");
        }

        participants.add(new Participant(name, id, fee));
    }

    void displayParticipants() {
        System.out.println("Name | Registration ID | Fee | Status");

        for (Participant p : participants) {
            p.display();
        }
    }
}

public class EventRegistration {
    public static void main(String[] args) {
        try {
            Event e = new Event(2, 500);

            e.register("Arun", "R001");
            e.register("Bala", "R002");

            e.displayParticipants();

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}