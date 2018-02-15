/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cosw.jpa.sample;

import edu.eci.cosw.jpa.sample.model.Cliente;
import edu.eci.cosw.jpa.sample.model.ClienteId;
import edu.eci.cosw.jpa.sample.model.PolizaAprobada;
import edu.eci.cosw.jpa.sample.model.PolizaAprobadaId;
import edu.eci.cosw.jpa.sample.model.TipoPoliza;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author hcadavid
 */
public class SimpleMainApp {
   
    public static void main(String a[]){
        SessionFactory sf=getSessionFactory();
        Session s=sf.openSession();
        Transaction tx=s.beginTransaction();
        
        // Creando cliente
        ClienteId idCliente = new ClienteId(102077, "cc");
        Cliente cliente = new Cliente(idCliente, "Juan Pablo Arevalo", "Calle 168", "313459");
        
        // Consultando poliza 1
        TipoPoliza poliza = (TipoPoliza) s.load(TipoPoliza.class, 1);
        System.out.println("Codigo: " + poliza.getCodigoPoliza());
        System.out.println("Nombre: " + poliza.getNombre());
        System.out.println("Descripcion: " + poliza.getDescripcion());
        System.out.println("Monto maximo: " + poliza.getMontoMaximo());
        
        // Creando poliza aprobada para el cliente con la poliza 1
        Date today = new Date();
        PolizaAprobadaId aprobadaId = new PolizaAprobadaId(idCliente.getId(), idCliente.getTipoId(), poliza.getCodigoPoliza());
        PolizaAprobada aprobada = new PolizaAprobada(aprobadaId, cliente, poliza, today, today);
        
        s.saveOrUpdate("POLIZAS_APROBADAS", aprobada);
        
        tx.commit();       
        s.close();
        sf.close();

    }

    public static SessionFactory getSessionFactory() {
        // loads configuration and mappings
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry
                = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

}
