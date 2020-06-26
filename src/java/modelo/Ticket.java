package modelo;

import java.sql.Date;

public class Ticket {
    public static final int PENDENTE = 0;
    public static final int FINALIZADO = 1;
    public static final int PAGO_AGURDANDO = 2;
    
    private long id;
    private int status;
    private Date checkIn;
    private Date checkOut;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCheckIn() {
        return checkIn; 
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }
}
