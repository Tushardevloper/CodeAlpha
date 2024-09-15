package CodeAlpha.Task_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // Add room
    public void addRoom(Room room) {
        rooms.add(room);
    }

    // Get all rooms in the hotel
    public List<Room> getRooms() {
        return rooms;
    }

    // Search available rooms by room type
    public List<Room> searchAvailableRooms(String roomType) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoomType().equalsIgnoreCase(roomType) && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }


    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    // Make a reservation and mark room as unavailable
    public boolean makeReservation(String customerName, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null && room.isAvailable()) {
            Reservation reservation = new Reservation(customerName, room, checkIn, checkOut);
            reservations.add(reservation);
            room.setAvailable(false);  // Mark room as unavailable after reservation
            System.out.println("Reservation successful!");
            return true;
        } else {
            System.out.println("Room not available.");
            return false;
        }
    }

    // View all reservations
    public void viewAllReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
