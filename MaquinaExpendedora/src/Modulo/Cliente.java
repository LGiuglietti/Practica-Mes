package Modulo;

public class Cliente {
    private String nombre;
    private int dni;
    private String tipoCliente; //subvencionado, jubilado, etc

    public Cliente(String nombre, int dni, String tipocliente) {
        this.nombre = nombre;
        this.dni = dni;
        this.tipoCliente = tipocliente;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public String getTipocliente() {
        return tipoCliente;
    }
    public void setTipocliente(String tipoCliente)
    {
        this.tipoCliente=tipoCliente;
    }
}
