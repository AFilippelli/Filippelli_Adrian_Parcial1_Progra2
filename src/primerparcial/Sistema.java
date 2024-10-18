/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class Sistema {
    
    private List<Servicio> lstServicio;

    public Sistema(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    public List<Servicio> getLstServicio() {
        return lstServicio;
    }

    public void setLstServicio(List<Servicio> lstServicio) {
        this.lstServicio = lstServicio;
    }

    @Override
    public String toString() {
        return "Sistema{" + "lstServicio=" + lstServicio + '}';
    }
    
    public Servicio traerServicio(String codServicio)throws ServicioNoEncontradoException{
        /*
        recorre la lista de servicios y si encuentra un servicio con el mismo codigo
        que el pasado por parametros, lo retorna, en caso contrario, devuelve una excepcion
        */
        for(Servicio servicio : this.lstServicio){
            if(servicio.getCodServicio().equals(codServicio)){
                return servicio;
            }
        }
        throw new ServicioNoEncontradoException("Servicio con codigo: " + codServicio + ", no existe");
    }
    
    public List<Servicio> traerServicio(boolean enPromocion){
        /*
        recorre la lista de servicios, compara con el parametro si el servicio se encuentra en promocion,
        en el caso de que si, lo agrega a la lista de servicios en promocion
        */
        List<Servicio> serviciosEnPromocion = new ArrayList<>();
        
        for(Servicio servicio : this.lstServicio){
            if (servicio.isEnPromocion() == enPromocion) {
                serviciosEnPromocion.add(servicio);
                
            }
        }
        return serviciosEnPromocion;
    }
    
    public List<Servicio> traerServicio(boolean enPromocion, int dia){
        List<Servicio> serviciosDisponibles = new ArrayList<>();
        
        for(Servicio servicio : this.lstServicio){
            if(servicio.enPromocion == enPromocion && servicio.getDia() == dia){
                serviciosDisponibles.add(servicio);
            }
        }
        return serviciosDisponibles;
    }
    
    public boolean agregarGastronomia(String codServicio,String gastronomia, double precio, int diaSemDesc,
        double porcentajeDescuento, boolean enPromocion, int dia)throws CodigoInvalidoException{
        
        for(Servicio servicio : this.lstServicio){
            if(servicio.getCodServicio().equals(codServicio)){
                throw new CodigoInvalidoException("Error, ya existe un servicio gastronomico con codigo: " + codServicio);
            }
        }
        Gastronomia nuevoProdGastronomico = new Gastronomia(codServicio,gastronomia,precio,diaSemDesc,porcentajeDescuento,enPromocion,dia);
        this.lstServicio.add(nuevoProdGastronomico);
        return true;
    }
    
    public boolean agregarHospedaje(String codServicio,String hospedaje, double precioPorNoche, 
        double porcentajeDescuento, boolean enPromocion, int dia)throws CodigoInvalidoException{
    
        for(Servicio servicio : this.lstServicio){
            if(servicio.getCodServicio().equals(codServicio)){
                    throw new CodigoInvalidoException("Error, ya existe un servicio de hospedaje con codigo: " + codServicio);
            }
        } 
        Hospedaje nuevoProdHospedaje = new Hospedaje(codServicio,hospedaje,precioPorNoche,porcentajeDescuento,enPromocion,dia);
        this.lstServicio.add(nuevoProdHospedaje);
        return true;
    }
    
}
