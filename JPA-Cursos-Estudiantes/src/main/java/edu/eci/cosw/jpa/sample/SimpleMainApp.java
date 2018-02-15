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

import edu.eci.cosw.jpa.sample.model.Curso;
import edu.eci.cosw.jpa.sample.model.Estudiante;
import java.util.HashSet;
import java.util.Set;
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
        
        Estudiante estudiante1 = new Estudiante(2087559, "Juan Pablo Arevalo Merchan");
        Estudiante estudiante2 = new Estudiante(2082314, "Stefany Moron");
        
        Set<Estudiante> estudiantes = new HashSet<>();
        estudiantes.add(estudiante1);
        estudiantes.add(estudiante2);
        // Creando cursos
        Curso curso1 = new Curso(888111, "Creacion Correos1111", "CDC");
        Curso curso2 = new Curso(77711, "Construccion SOFW111", "COSW2018");

        Set<Curso> cursos = new HashSet<>();
        cursos.add(curso1);
        cursos.add(curso2);
        estudiante1.setCursos(cursos);
        estudiante2.setCursos(cursos);
        curso1.setEstudiantes(estudiantes);
        curso2.setEstudiantes(estudiantes);
        
        s.saveOrUpdate(estudiante1);
        s.saveOrUpdate(estudiante2);
        
        s.saveOrUpdate(curso1);
        s.saveOrUpdate(curso2);
        
        
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
