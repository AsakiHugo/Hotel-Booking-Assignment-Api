package com.example.hotelbookingassignment.ds;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Optional;

@EqualsAndHashCode
@ToString
public class BookingResult implements Serializable {
    private BookingState bookingState;
    private Reservation reservation;

    public static BookingResult createRoomBookedResult(Reservation reservation) {
        return new BookingResult(BookingState.ROOM_BOOKED, reservation);
    }

    public static BookingResult createNoRoomAvailableResult() {
        return new BookingResult(BookingState.NO_ROOM_AVAILABLE, null);
    }

    private BookingResult(BookingState bookingState, Reservation reservation) {
        this.bookingState = bookingState;
        this.reservation = reservation;
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public Optional<Reservation> getReservation() {
        return Optional.ofNullable(reservation);
    }

    public enum BookingState {
        ROOM_BOOKED,
        NO_ROOM_AVAILABLE
    }
}
