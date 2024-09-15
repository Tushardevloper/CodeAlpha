package CodeAlpha.Task_3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;


public class HotelReservationSystem {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.addRoom(new Room(101, "Standard", 100));
        hotel.addRoom(new Room(102, "Deluxe", 150));
        hotel.addRoom(new Room(103, "Suite", 200));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Hotel Reservation System!");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter room type (Standard, Deluxe, Suite): ");
                    String roomType = scanner.next();
                    List<Room> availableRooms = hotel.searchAvailableRooms(roomType);
                    if (availableRooms.isEmpty()) {
                        System.out.println("No available rooms for this type.");
                    } else {
                        for (Room room : availableRooms) {
                            System.out.println(room);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter your name: ");
                    String customerName = scanner.next();
                    System.out.println("Enter room number: ");
                    int roomNumber = scanner.nextInt();
                    System.out.println("Enter check-in date (yyyy-mm-dd): ");
                    LocalDate checkInDate = LocalDate.parse(scanner.next());
                    System.out.println("Enter check-out date (yyyy-mm-dd): ");
                    LocalDate checkOutDate = LocalDate.parse(scanner.next());

                    //number of nights
                    long numberOfNights = ChronoUnit.DAYS.between(checkInDate, checkOutDate);


                    Room selectedRoom = null;
                    for (Room room : hotel.getRooms()) {
                        if (room.getRoomNumber() == roomNumber) {
                            selectedRoom = room;
                            break;
                        }
                    }

                    if (selectedRoom == null) {
                        System.out.println("Room number not found.");
                    } else {
                        // Calculate the total amount
                        double amount = numberOfNights * selectedRoom.getPricePerNight();

                        // Process the payment
                        if (Payment.processPayment(customerName, amount)) {
                            hotel.makeReservation(customerName, roomNumber, checkInDate, checkOutDate);
                        } else {
                            System.out.println("Payment failed.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Showing all reservations:");
                    hotel.viewAllReservations();
                    break;

                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
