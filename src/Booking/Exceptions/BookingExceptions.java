package Booking.Exceptions;

public class BookingExceptions {

    public static class BookingUnavailableException extends RuntimeException {
        public BookingUnavailableException(String message) {
            super(message);
        }
    }

    public static class InvalidBookingPeriodException extends RuntimeException {
        public InvalidBookingPeriodException(String message) {
            super(message);
        }
    }

    public static class ClientAlreadyBookedAccommodationException extends RuntimeException {
        public ClientAlreadyBookedAccommodationException(String message) {
            super(message);
        }
    }

}
