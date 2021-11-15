package ar.edu.unju.escmi.poo.dao;

import java.util.List;

import ar.edu.unju.escmi.poo.dominio.Mozo;

public interface IMozoDao {

    public void guardarMozo(Mozo nuevo);

    public List<Mozo> obtenerMozos();

    public Mozo obtenerMozo(int dni);
}
