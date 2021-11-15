package ar.edu.unju.escmi.poo.principal;

import ar.edu.unju.escmi.poo.util.ClienteUtil;
import ar.edu.unju.escmi.poo.util.MenuUtil;
import ar.edu.unju.escmi.poo.util.MozoUtil;
import ar.edu.unju.escmi.poo.util.ReservaUtil;
import ar.edu.unju.escmi.poo.util.SalonUtil;

public class Principal {
    public static void main(String[] args) {
        ClienteUtil clienteUtil = new ClienteUtil();
        MozoUtil mozoUtil = new MozoUtil();
        SalonUtil salonUtil = new SalonUtil();
        ReservaUtil reservaUtil = new ReservaUtil();
        MenuUtil menuUtil = new MenuUtil();

        // clientes
        clienteUtil.precargarClientes();

        // mozos
        mozoUtil.precargarMozos();

        // salons
        salonUtil.pregargarSalones();

        // reservas
        reservaUtil.precargarReservas();

        // menu
        menuUtil.menu();
    }
}