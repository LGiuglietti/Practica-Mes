package Modulo;

import java.time.LocalDate;
import java.util.Date;

public class Boleto {
    private int precioEmitido;
    private LocalDate fechaEmision;

    public Boleto()
    {
        this.precioEmitido=100;
        fechaEmision=LocalDate.now();
    }
    public int getPrecioEmitido()
    {
        return precioEmitido;
    }
    public LocalDate getFechaEmision()
    {
        return fechaEmision;
    }
}
