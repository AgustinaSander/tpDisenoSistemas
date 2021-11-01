
package Dominio;

import Enum.PosicionIVA;

public class Persona {
    protected int idPersona;
    protected String CUIT;
    protected PosicionIVA posIva;
    protected String telefono;
    protected Direccion direccion;
    
    public Persona(){
    }

    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(int idPersona, String CUIT, PosicionIVA posIva, String telefono, Direccion direccion) {
        this.idPersona = idPersona;
        this.CUIT = CUIT;
        this.posIva = posIva;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getCUIT() {
        return CUIT;
    }

    public void setCUIT(String CUIT) {
        this.CUIT = CUIT;
    }

    public PosicionIVA getPosIva() {
        return posIva;
    }

    public void setPosIva(PosicionIVA posIva) {
        this.posIva = posIva;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", CUIT=" + CUIT + ", posIva=" + posIva + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
}
