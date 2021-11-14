package ar.edu.unju.escmi.poo.dominio;

public class Salon {
    private String nombre;
    private int mesas;

    public Salon() {
    }

    public Salon(String nombre, int mesas) {
        this.nombre = nombre;
        this.mesas = mesas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMesas() {
        return mesas;
    }

    public void setMesas(int mesas) {
        this.mesas = mesas;
    }

    @Override
    public String toString() {
        return "Salon [mesas=" + mesas + ", " + (nombre != null ? "nombre=" + nombre : "") + "]";
    }
}
