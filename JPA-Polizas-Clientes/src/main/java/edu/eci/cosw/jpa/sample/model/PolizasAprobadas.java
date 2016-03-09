package edu.eci.cosw.jpa.sample.model;
// Generated Mar 9, 2016 7:01:57 AM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * PolizasAprobadas generated by hbm2java
 */
public class PolizasAprobadas  implements java.io.Serializable {


     private PolizasAprobadasId id;
     private Clientes clientes;
     private TiposPoliza tiposPoliza;
     private Date fechaAprobacion;
     private Date fechaVencimiento;

    public PolizasAprobadas() {
    }

    public PolizasAprobadas(PolizasAprobadasId id, Clientes clientes, TiposPoliza tiposPoliza, Date fechaAprobacion, Date fechaVencimiento) {
       this.id = id;
       this.clientes = clientes;
       this.tiposPoliza = tiposPoliza;
       this.fechaAprobacion = fechaAprobacion;
       this.fechaVencimiento = fechaVencimiento;
    }
   
    public PolizasAprobadasId getId() {
        return this.id;
    }
    
    public void setId(PolizasAprobadasId id) {
        this.id = id;
    }
    public Clientes getClientes() {
        return this.clientes;
    }
    
    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
    public TiposPoliza getTiposPoliza() {
        return this.tiposPoliza;
    }
    
    public void setTiposPoliza(TiposPoliza tiposPoliza) {
        this.tiposPoliza = tiposPoliza;
    }
    public Date getFechaAprobacion() {
        return this.fechaAprobacion;
    }
    
    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }
    public Date getFechaVencimiento() {
        return this.fechaVencimiento;
    }
    
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }




}


