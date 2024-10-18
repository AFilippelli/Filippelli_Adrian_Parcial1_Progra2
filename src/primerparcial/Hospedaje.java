/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 *
 * @author adria
 */
public class Hospedaje extends Servicio{
    
    private String hospedaje;
    private double precioPorNoche;

    public Hospedaje(String codServicio,String hospedaje, double precioPorNoche, double porcentajeDescuento, boolean enPromocion, int dia) throws CodigoInvalidoException {
        super(codServicio, porcentajeDescuento, enPromocion, dia);
        this.hospedaje = hospedaje;
        this.precioPorNoche = precioPorNoche;
    }

    public String getHospedaje() {
        return hospedaje;
    }

    public void setHospedaje(String hospedaje) {
        this.hospedaje = hospedaje;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "hospedaje=" + hospedaje + ", precioPorNoche=" + precioPorNoche + '}';
    }
    
    @Override
    public double calcularPrecioFinal(LocalDate dia){
        //si no es sabado ni domingo, se aplica el descuento agregado
        if(enPromocion && dia.getDayOfWeek() != DayOfWeek.SATURDAY && dia.getDayOfWeek() != DayOfWeek.SUNDAY){
            return this.precioPorNoche * (1 - porcentajeDescuento / 100);
        }
        return this.precioPorNoche;
    }
}
