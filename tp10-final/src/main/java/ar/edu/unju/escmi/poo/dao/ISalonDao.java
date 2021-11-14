package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Salon;

public interface ISalonDao {
    

    public void guardarSalon(Salon nuevo);
    public List<Salon> obtenerSalones();
    public Salon obtenerSalon(String nombre);
}
