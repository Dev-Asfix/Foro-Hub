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
@NoArgsConstructor
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

}
