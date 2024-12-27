package com.alura.foro.foro_hub.domain.curso;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Entity(name = "curso")
@Table(name = "cursos")
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nombre;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Curso(){

    }

    public Curso(@Valid DatosRegistroCurso datos){
        this.nombre = datos.nombre();
        this.categoria = datos.categoria();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
