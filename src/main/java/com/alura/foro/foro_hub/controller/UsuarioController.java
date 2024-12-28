package com.alura.foro.foro_hub.controller;

import com.alura.foro.foro_hub.domain.perfil.DatosDetallePerfil;
import com.alura.foro.foro_hub.domain.perfil.Perfil;
import com.alura.foro.foro_hub.domain.perfil.PerfilRepository;
import com.alura.foro.foro_hub.domain.usuario.DatosDetalleUsuario;
import com.alura.foro.foro_hub.domain.usuario.DatosRegistroUsuario;
import com.alura.foro.foro_hub.domain.usuario.Usuario;
import com.alura.foro.foro_hub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroUsuario datos,
                                    UriComponentsBuilder uriComponentsBuilder){
        var perfil = perfilRepository.findById(datos.idPerfil())
                .orElseThrow(()-> new RuntimeException("Perfil no encontrado"));

        var usuario = new Usuario(datos.nombre(), datos.correoElectronico(),
                datos.contrasena(), perfil);

        usuarioRepository.save(usuario);

        var datosDetalleUser = new DatosDetalleUsuario(usuario);
        //return ResponseEntity.status(HttpStatus.CREATED).body(datosDetalleUser);
        var uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(datosDetalleUser);

    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleUsuario>> listar(@PageableDefault(page=0, size=10)Pageable paginacion){
        var page = usuarioRepository.findAll(paginacion).map(DatosDetalleUsuario::new);
        return ResponseEntity.ok(page);
    }
}
