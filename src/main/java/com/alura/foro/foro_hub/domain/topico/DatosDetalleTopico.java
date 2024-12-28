package com.alura.foro.foro_hub.domain.topico;

import com.alura.foro.foro_hub.domain.curso.Curso;
import com.alura.foro.foro_hub.domain.usuario.DatosTopicoUsuario;
import com.alura.foro.foro_hub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosDetalleTopico(

        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fecha_creacion,

        Estados status,

        DatosTopicoUsuario autor,

        Curso curso
) {
    public DatosDetalleTopico(Topico datos){
        this(datos.getId(), datos.getTitulo(), datos.getMensaje(), datos.getFecha_creacion(), datos.getStatus(),
                new DatosTopicoUsuario(datos.getAutor().getId(), datos.getAutor().getNombre(), datos.getAutor().getCorreo_electronico(),
                        datos.getAutor().getPerfil()), datos.getCurso());
    }
}
