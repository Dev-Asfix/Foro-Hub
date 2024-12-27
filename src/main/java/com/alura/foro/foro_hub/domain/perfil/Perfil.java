package com.alura.foro.foro_hub.domain.perfil;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "perfil")
@Table(name = "perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String nombre;
}
