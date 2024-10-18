/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package primerparcial;

import java.time.LocalDate;

/**
 *
 * @author adria
 */
public abstract class Servicio {

    protected String codServicio;
    protected double porcentajeDescuento;
    protected boolean enPromocion;
    protected int dia;

    public Servicio(String codServicio, double porcentajeDescuento, boolean enPromocion, int dia) throws CodigoInvalidoException {
        setCodServicio(codServicio);
        this.porcentajeDescuento = porcentajeDescuento;
        this.enPromocion = enPromocion;
        this.dia = dia;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(String codServicio) throws CodigoInvalidoException{
        if(codServicio.length() != 6){
            throw new CodigoInvalidoException("El codigo debe tener 6 digitos");
        }
        this.codServicio = codServicio;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public boolean isEnPromocion() {
        return enPromocion;
    }

    public void setEnPromocion(boolean enPromocion) {
        this.enPromocion = enPromocion;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Servicio{" + "codServicio=" + codServicio + ", porcentajeDescuento=" + porcentajeDescuento + ", enPromocion=" + enPromocion + ", dia=" + dia + '}';
    }
    
 
    public abstract double calcularPrecioFinal(LocalDate dia);
    
}
