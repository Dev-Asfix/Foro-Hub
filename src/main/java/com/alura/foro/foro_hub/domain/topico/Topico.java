package com.alura.foro.foro_hub.domain.topico;

import com.alura.foro.foro_hub.domain.curso.Curso;
import com.alura.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "topico")
@Table(name = "topicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_creacion;
    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    public Topico(DatosRegistroTopico datos, Usuario autor, Curso curso){
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fecha_creacion = datos.fecha_creacion();
        this.status = datos.status();
        this.autor = autor;
        this.curso = curso;
    }
}
