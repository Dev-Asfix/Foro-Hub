package com.alura.foro.foro_hub.domain.usuario;

import com.alura.foro.foro_hub.domain.perfil.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "usuario")
@Table(name = "usuarios")
@Getter
@Setter
//@NoArgsConstructor
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

    public Usuario(){

    }

    public Usuario(String nombre, String correo_electronico, String contrasena, Perfil perfil) {
        this.nombre = nombre;
        this.correo_electronico = correo_electronico;
        this.contrasena = contrasena;
        this.perfil = perfil;
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
