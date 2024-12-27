package com.alura.foro.foro_hub.domain.usuario;

import com.alura.foro.foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "usuario")
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo_electronico;

    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "perfil_id")
    private Perfil perfil;

}
