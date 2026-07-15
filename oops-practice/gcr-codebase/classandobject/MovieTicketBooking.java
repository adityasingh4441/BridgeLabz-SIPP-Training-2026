import java.util.Scanner;

class MovieTicket {
    String movieName;
    String seatNumber;
    double price;

    MovieTicket(String movieName) {
        this.movieName = movieName;
    }

    void bookTicket(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully");
    }

    void displayDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter seat number: ");
        String seatNumber = scanner.nextLine();

        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();

        MovieTicket ticket = new MovieTicket(movieName);
        ticket.bookTicket(seatNumber, price);
        ticket.displayDetails();
    }
}
