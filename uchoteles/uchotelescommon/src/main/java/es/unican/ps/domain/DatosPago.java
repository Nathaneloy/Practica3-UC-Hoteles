package es.unican.ps.domain;

public class DatosPago {
    private int id;
    private String numTarjeta;
    private char[] cvc = new char[3];
    private int mesCaducidad;
    private int anhoCaducidad;
    private TipoTarjeta tipo;

    

    public DatosPago(int id, String numTarjeta, char[] cvc, int mesCaducidad, int anhoCaducidad, TipoTarjeta tipo) {
        this.id = id;
        this.numTarjeta = numTarjeta;
        this.cvc = cvc;
        this.mesCaducidad = mesCaducidad;
        this.anhoCaducidad = anhoCaducidad;
        this.tipo = tipo;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumTarjeta() {
        return numTarjeta;
    }
    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }
    public char[] getCvc() {
        return cvc;
    }
    public void setCvc(char[] cvc) {
        this.cvc = cvc;
    }
    public int getMesCaducidad() {
        return mesCaducidad;
    }
    public void setMesCaducidad(int mesCaducidad) {
        this.mesCaducidad = mesCaducidad;
    }
    public int getAnhoCaducidad() {
        return anhoCaducidad;
    }
    public void setAnhoCaducidad(int anhoCaducidad) {
        this.anhoCaducidad = anhoCaducidad;
    }
    public TipoTarjeta getTipo() {
        return tipo;
    }
    public void setTipo(TipoTarjeta tipo) {
        this.tipo = tipo;
    }

    

}
