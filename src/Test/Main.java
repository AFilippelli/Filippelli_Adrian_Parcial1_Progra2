/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import primerparcial.CodigoInvalidoException;
import primerparcial.Gastronomia;
import primerparcial.Hospedaje;
import primerparcial.Servicio;
import primerparcial.Sistema;

/**
 *
 * @author adria
 */
public class Main {
    
    public static void main(String[]args){
        //1.1
        try{
            Gastronomia gast = new Gastronomia("4892","Hamburguesa criolla",180.0,4,15.0,true,3);
            System.out.println("1.1: Objeto Gastronomico creado correctamente: " + gast);
        }catch(CodigoInvalidoException e){
            System.out.println("Error al crear objeto gastronomico: " + e.getMessage());
        }
        
        //1.2
        try {
            Gastronomia gast2 = new Gastronomia("489235", "Hamburguesa criolla", 180.0, 4, 15.0, true,3);
            System.out.println("1.2: Objeto Gastronomia creado correctamente: " + gast2);
            //2.1
            LocalDate fechaGast = LocalDate.of(2020,10,28);
            System.out.println("2.1: precio final: " + gast2.calcularPrecioFinal(fechaGast));
        } catch (CodigoInvalidoException e) {
            System.out.println("Error al crear objeto gastronomico: " + e.getMessage());
        }
        
        //1.3
        try {
            Hospedaje hosp1 = new Hospedaje("2872", "Cabania 3 personas", 1500.0, 10.0, true,4);
            System.out.println("1.3: Objeto Hospedaje creado correctamente: " + hosp1);
        } catch (CodigoInvalidoException e) {
            System.out.println("Error al crear el objeto Hospedaje: " + e.getMessage());
        }
        
        //1.4
        try {
            Hospedaje hosp2 = new Hospedaje("287282", "Cabania 3 personas", 1500.0, 10.0, true,4);
            System.out.println("1.4: Objeto Hospedaje creado correctamente: " + hosp2);
            //2.2
            LocalDate fechaHosp = LocalDate.of(2020,10,27);
            System.out.println("2.2: precio final: " + hosp2.calcularPrecioFinal(fechaHosp));
        } catch (CodigoInvalidoException e) {
            System.out.println("Error al crear el objeto Hospedaje: " + e.getMessage());
        }
        
        try{
            List<Servicio> listaServicios = new ArrayList<>();
            Sistema sistema = new Sistema(listaServicios);

            sistema.agregarGastronomia("858927", "Milanesa con pure", 350.0, 3, 15.0, true,2);
            sistema.agregarHospedaje("489259", "Habitacion triple", 2200.0, 10.0, true,3);
            sistema.agregarGastronomia("182835", "Gaseosa", 120.0, 3, 20.0, false,4);
            sistema.agregarHospedaje("758972", "Habitacion simple", 1000.0, 15.0, false,1);
            
            System.out.println("3: Servicios agregados al sistema");
            for (Servicio servicio : listaServicios){
                System.out.println(servicio);
            }
            
            //4.1
            List<Servicio> serviciosEnPromocion = sistema.traerServicio(true); // Servicios en promoción
    
            //verifico si hay servicios en promoción
            if (serviciosEnPromocion.isEmpty()) {
                System.out.println("No hay servicios en promocion");
            }else {
                System.out.println("4.1: Servicios en promocion: ");
                for (Servicio servicio : serviciosEnPromocion) {
                    System.out.println(servicio);
                }
            }
            

            List<Servicio> serviciosDelDiaEnPromocion = sistema.traerServicio(true, 3); // Servicios en promoción para ese dia (dias del 1 al 7, 3 = dia miercoles)
    
            // Verificar si hay servicios disponibles para ese día
            if (serviciosDelDiaEnPromocion.isEmpty()) {
                System.out.println("No hay servicios en promoción para el día " + 3);
            } else {
                System.out.println("4.2: Servicios en promocion para el dia " + 3 + "(miercoles):");
                for (Servicio servicio : serviciosDelDiaEnPromocion) {
                    System.out.println(servicio);
                }
            }
     
        }catch(CodigoInvalidoException e){
            System.err.println("Error al agregar el producto: " + e.getMessage());
        }
        
    }
}
