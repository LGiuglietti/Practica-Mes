package Modulo;
//maquina expendedora simplificada
public class MES {
    private double precioActual;
    private double recaudacion;
    private int contadorBoletos;
    private int topeBoletos;
    private double saldo;
    private String contrasenia;

    public MES(int precioActual, double recaudacion, int contadorBoletos, int topeBoletos, double saldo, String contrasenia) {
        this.precioActual = precioActual;
        this.recaudacion = recaudacion;
        this.contadorBoletos = contadorBoletos;
        this.topeBoletos = topeBoletos;
        this.saldo = saldo;
        this.contrasenia=contrasenia;
    }
    public MES()
    {
        this.precioActual=100;
        this.recaudacion=0;
        this.contadorBoletos=0;
        this.topeBoletos=1000;
        this.saldo=0;
        this.contrasenia="1234";
    }
    public double getPrecioActual()
    {
        return precioActual;
    }

    public double getRecaudacion() {
        return recaudacion;
    }

    public int getContadorBoletos() {
        return contadorBoletos;
    }

    public int getTopeBoletos() {
        return topeBoletos;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setPrecioActual(double nuevoPrecio)
    {
        this.precioActual=nuevoPrecio;
    }
    public void setTopeBoletos(int nuevoTopeBoletos)
    {
        this.topeBoletos=nuevoTopeBoletos;
    }
    private void ingresarDinero(double dinero)
    {
        this.saldo+=dinero;
    }
    public boolean imprimirBoleto(double dinero) //resta precio de boleto a salgo, suma un boleto y agrega precio a recaudacion
    {
        ingresarDinero(dinero);
        if(saldo>=precioActual && contadorBoletos<topeBoletos)
        {
            saldo-=precioActual;
            contadorBoletos++;
            recaudacion+=precioActual;
            return true;
        }
        else
        {
            saldo-=dinero;
            return false;
        }
    }
    public void vaciarRecaudacion () //reset disponible para el tecnico de los atributos de la clase
    {
        contadorBoletos=0;
        recaudacion=0;
        saldo=0;
    }
    public void vaciarSaldo() //en caso de querer vaciar por separado
    {
        saldo=0;
    }
    public String getContrasenia()
    {
        return contrasenia;
    }

}
