/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.time.LocalDate;

/**
 *
 * @author adria
 */
public class Gastronomia extends Servicio{
    
    private String gastronomia;
    private double precio;
    private int diaSemDesc;

    public Gastronomia(String codServicio,String gastronomia, double precio, int diaSemDesc, double porcentajeDescuento, boolean enPromocion, int dia) throws CodigoInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion, dia);
        this.gastronomia = gastronomia;
        this.precio = precio;
        this.diaSemDesc = diaSemDesc;
    }

    public String getGastronomia() {
        return gastronomia;
    }

    public void setGastronomia(String gastronomia) {
        this.gastronomia = gastronomia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDiaSemDesc() {
        return diaSemDesc;
    }

    public void setDiaSemDesc(int diaSemDesc) {
        this.diaSemDesc = diaSemDesc;
    }

    @Override
    public String toString() {
        return "Gastronomia{" + "gastronomia=" + gastronomia + ", precio=" + precio + ", diaSemDesc=" + diaSemDesc + '}';
    }
   
    
    @Override
    public double calcularPrecioFinal(LocalDate dia){ 
        if(enPromocion){ //si hay promocion:
            return this.precio * (1 - porcentajeDescuento / 100); 
        } //devuelve el precio con descuento en el caso que haya, sin descuento en caso contrario.
        return this.precio;
    }
}
