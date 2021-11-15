package ar.edu.unju.escmi.poo.principal;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Cliente;
import ar.edu.unju.escmi.poo.dominio.Empresa;
import ar.edu.unju.escmi.poo.dominio.Mozo;
import ar.edu.unju.escmi.poo.dominio.Particular;
import ar.edu.unju.escmi.poo.util.ClienteUtil;
import ar.edu.unju.escmi.poo.util.MozoUtil;

public class pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		ClienteUtil clienteUtil = new ClienteUtil();
        List<Cliente> clientes = new ArrayList<Cliente>();
        
        Particular particular = null;
        Empresa empresa = null;
        
        particular = new Particular("Mayko Hernandez", "hola@pvto.com", 123, 44706681);
        particular.setId(1);
        clientes.add(particular);
        particular = new Particular("Samoel Panfila", "hola2@pvto.com", 432, 44706400);
        particular.setId(2);
        clientes.add(particular);
        particular = new Particular("Churro Chorolque", "hola3@pvto.com", 623, 44700523);
        particular.setId(3);
        clientes.add(particular);
        particular = new Particular("Santula Ancalay", "hola4@pvto.com", 765, 44500463);
        particular.setId(4);
        clientes.add(particular);
        empresa = new Empresa("La Nortenia", "lanortenia@ea.com", 963, 123456789);
        empresa.setId(5);
        clientes.add(empresa);
        empresa = new Empresa("La Surenia", "lasurenia@ea.com", 741, 456123789);
        empresa.setId(6);
        clientes.add(empresa);
        empresa = new Empresa("The Wester", "thewester@ea.com", 852, 789456123);
        empresa.setId(7);
        clientes.add(empresa);
        
        System.out.println(clienteUtil.obtenerClientes());
        System.out.println(clientes);
        */
		

        Mozo mozo = new Mozo(23549842, "Jarvis", "mi casa 18",true);
        System.out.println(MozoUtil.obtenerMozo(23549842));
        System.out.println(mozo);
        
	}

}
