import Modulo.Boleto;
import Modulo.MES;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //inicializo Mes Boleto y Scanner
        MES miMaquina=new MES();
        Boleto miBoleto=new Boleto();
        Scanner teclado= new Scanner(System.in);

        System.out.println("ingrese opcion a acceder: 1-tecnico 2-usuario");
        int desicion=teclado.nextInt();
        if(desicion==1) { //si selecciona tecnico
            System.out.println("ingrese la contrasenia de la empresa");
            String contraseniaIngresada;
            teclado.nextLine(); //limpia buffer
            contraseniaIngresada = teclado.nextLine();
            //controlo que contrasenia ingresada == a contrasenia de sistema
            if (contraseniaIngresada.equalsIgnoreCase(miMaquina.getContrasenia())) {
                System.out.println("contrasenia correcta ingresando al sistema");
            } else {
                System.out.println("contrasenia ingresada es la incorrecta");
                System.exit(1); //cierra programa en caso de ingresar contrasenia incorrecta
            }
        }
        switch (desicion){
            case 1: //tecnico
                int desicionTecnico;
                System.out.println("ingrese opcion a acceder: 1-modificar precio 2-ver recaudacion \n" +
                        " 3-ver tope 4-cambiar tope 5-vaciar recaudacion 6-ver cantidad de boletos dados");
                desicionTecnico=teclado.nextInt();
                switch (desicionTecnico){ //switch para tecnico
                    case 1:
                        System.out.println("ingrese nuevo precio"); //nuevo precio de boleto
                        double nuevoPrecio=teclado.nextDouble();
                        miMaquina.setPrecioActual(nuevoPrecio);
                    case 2:
                        System.out.println("recaudacion: $"+miMaquina.getRecaudacion());
                    case 3:
                        System.out.println(miMaquina.getTopeBoletos());
                    case 4:
                        System.out.println("ingrese nuevo tope"); //nuevo tope del limite de la cantidad de boletos a vender
                        int nuevoTope=teclado.nextInt();
                        miMaquina.setTopeBoletos(nuevoTope);
                    case 5:
                        miMaquina.vaciarRecaudacion();
                        System.out.println("robar el puchero del saldito en la MES? 1-si 2-no");
                        int robarSaldito=teclado.nextInt();
                        if(robarSaldito==1) //consulta de vaciar el sueldo
                        {
                            miMaquina.vaciarSaldo();
                        }
                    case 6:
                        System.out.println("cantidad de boletos dados: "+miMaquina.getContadorBoletos());
                        //fin switch tecnico
                }
            case 2: //switch cliente
                int continuarComprandoBoletos=1;
                while(continuarComprandoBoletos==1) {
                    System.out.println("el precio de boleto es: $" + miMaquina.getPrecioActual());
                    System.out.println("el saldo actual en la maquina es de: $" + miMaquina.getSaldo());
                    System.out.println("cuanto dinero desea ingresar: ");
                    double dineroIngresado = teclado.nextDouble();
                    if(miMaquina.imprimirBoleto(dineroIngresado)) { //si se imprimio el boleto
                        System.out.println("fecha de boleto: " + miBoleto.getFechaEmision());
                        System.out.println("saldo restante en maquina: $" + miMaquina.getSaldo());
                        System.out.println("Felicitaciones ya tiene su boleto");
                    }
                    //de todas formas pregunto si quiere comprar otro
                    System.out.println("desea comprar otro boleto? 1-si 2-no, cualquier otro numero ingresado cerrara el sistema");
                    continuarComprandoBoletos= teclado.nextInt(); //variable bucle
                }
        }
    }
}