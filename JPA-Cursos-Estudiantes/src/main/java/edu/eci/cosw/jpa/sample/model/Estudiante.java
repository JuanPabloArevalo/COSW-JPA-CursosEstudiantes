package edu.eci.cosw.jpa.sample.model;
// Generated Mar 9, 2016 7:01:57 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Estudiantes generated by hbm2java
 */
@Entity
@Table(name="ESTUDIANTES")
public class Estudiante  implements java.io.Serializable {


     private int codigo;
     private String nombre;
     private Set<Curso> cursos = new HashSet<>(0);

    public Estudiante() {
    }

	
    public Estudiante(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public Estudiante(int codigo, String nombre, Set<Curso> cursos) {
       this.codigo = codigo;
       this.nombre = nombre;
       this.cursos = cursos;
    }
    @Id
    @Column(name = "codigo", nullable = false)
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    @Column(name = "nombre", nullable = false, length = 45)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ESTUDIANTES_CURSOS",
            joinColumns = @JoinColumn(name = "ESTUDIANTES_codigo", referencedColumnName = "codigo"),
            inverseJoinColumns = @JoinColumn(name = "CURSOS_id", referencedColumnName = "id"))    
    public Set<Curso> getCursos() {
        return this.cursos;
    }
    
    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

}


