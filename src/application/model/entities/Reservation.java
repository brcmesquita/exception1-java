package application.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    // vamos precisar criar uma máscara para receber as datas no padrão dd/MM/yyyy
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    // para calcular a diferença de dias, vamos usar milisegundos
    // para isso, utilizamos um long
    public long duration() {
        // o método "getTime()" irá transformar o tempo em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        // o método "TimeUnit" irá fazer a conversão inversa
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Agora vamos criar um método ToString para mostrar as informações
    @Override
    public String toString() {
        return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
                + ", " + duration() + " nights.";
    }
}
