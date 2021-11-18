package ar.edu.unju.escmi.poo.principal;

import ar.edu.unju.escmi.poo.util.ClienteUtil;
import ar.edu.unju.escmi.poo.util.MenuUtil;
import ar.edu.unju.escmi.poo.util.MozoUtil;
import ar.edu.unju.escmi.poo.util.ReservaUtil;
import ar.edu.unju.escmi.poo.util.SalonUtil;


public class Principal {
    public static void main(String[] args) {

        // usar primera vez
        
        /*
        // clientes
        ClienteUtil.precargarClientes();

        // mozos
        MozoUtil.precargarMozos();

        // salons
        SalonUtil.pregargarSalones();

        // reservas
        ReservaUtil.precargarReservas();
        
        // menu
    	*/
        MenuUtil.menu();
    }
}
