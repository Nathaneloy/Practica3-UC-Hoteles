package es.unican.ps.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor 
@Entity
@Table(name = "DatosPago")
public class DatosPago implements Serializable {
    @Id 
    @GeneratedValue 
    private int id;
    @Column(nullable = false)
    private String numTarjeta;
    @Column(nullable = false)
    private char[] cvc = new char[3];
    @Column(nullable = false)
    private int mesCaducidad;
    @Column(nullable = false)
    private int anhoCaducidad;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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
