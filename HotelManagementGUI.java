import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

class Guest {
    private String name;
    private String contact;

    public Guest(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nContact: " + contact;
    }
}

class Room {
    private int roomNumber;
    private boolean isOccupied;
    private List<String> orderedItems;
    private Guest guest;
    private double roomCost;

    public Room(int roomNumber, double roomCost) {
        this.roomNumber = roomNumber;
        this.isOccupied = false;
        this.orderedItems = new ArrayList<>();
        this.guest = null;
        this.roomCost = roomCost;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
        if (!occupied) {
            orderedItems.clear();
            guest = null;
        }
    }

    public List<String> getOrderedItems() {
        return orderedItems;
    }

    public void addOrderedItem(String item) {
        orderedItems.add(item);
    }

    public double calculateTotalCost() {
        double itemsCost = orderedItems.size() * 10.0;
        return roomCost + itemsCost;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }
}

class HotelManagementSystem {
    private List<Room> rooms;

    public HotelManagementSystem() {
        rooms = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        rooms.add(new Room(101, 100.0));
        rooms.add(new Room(102, 120.0));
        rooms.add(new Room(103, 150.0));
        rooms.add(new Room(104, 200.0));
        rooms.add(new Room(105, 250.0));
        rooms.add(new Room(106, 300.0));
        rooms.add(new Room(107, 180.0));
        rooms.add(new Room(108, 220.0));
        rooms.add(new Room(109, 270.0));
        rooms.add(new Room(110, 320.0));
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

public class HotelManagementGUI {
    private HotelManagementSystem hotelManagementSystem;
    private JFrame frame;
    private JButton viewRoomsButton;
    private JButton bookRoomButton;
    private JButton orderFoodButton;
    private JButton cancelBookingButton;

    public HotelManagementGUI() {
        hotelManagementSystem = new HotelManagementSystem();
        frame = new JFrame("Hotel Management System");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        viewRoomsButton = new JButton("View Rooms");
        viewRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showRooms();
            }
        });

        bookRoomButton = new JButton("Book Room");
        bookRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookRoom();
            }
        });

        orderFoodButton = new JButton("Order Food");
        orderFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFood();
            }
        });

        cancelBookingButton = new JButton("Cancel Booking");
        cancelBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelBooking();
            }
        });

        JPanel panel = new JPanel();
        panel.add(viewRoomsButton);
        panel.add(bookRoomButton);
        panel.add(orderFoodButton);
        panel.add(cancelBookingButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HotelManagementGUI();
            }
        });
    }
}
