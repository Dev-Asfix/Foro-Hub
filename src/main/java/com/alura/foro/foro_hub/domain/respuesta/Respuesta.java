package com.alura.foro.foro_hub.domain.respuesta;

import com.alura.foro.foro_hub.domain.topico.Topico;
import com.alura.foro.foro_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "respuesta")
@Table(name = "respuestas")
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private Topico topico;
    private LocalDateTime fecha_creacion;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario usuario;

    private boolean solucion;

    public Respuesta(){

    }

    public Respuesta(DatosRegistroRespuesta datos ,Topico datosTopico, Usuario datosUsuario){
        this.mensaje = datos.mensaje();
        this.topico = datosTopico;

        this.fecha_creacion = LocalDateTime.now();
        this.usuario = datosUsuario;
        this.solucion = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(LocalDateTime fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isSolucion() {
        return solucion;
    }

    public void setSolucion(boolean solucion) {
        this.solucion = solucion;
    }
}
