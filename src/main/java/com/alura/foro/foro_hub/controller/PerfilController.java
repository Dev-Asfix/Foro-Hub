package com.alura.foro.foro_hub.controller;

import com.alura.foro.foro_hub.domain.perfil.DatosDetallePerfil;
import com.alura.foro.foro_hub.domain.perfil.DatosRegistroPerfil;
import com.alura.foro.foro_hub.domain.perfil.Perfil;
import com.alura.foro.foro_hub.domain.perfil.PerfilRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/perfiles")
public class PerfilController {

    @Autowired
    private PerfilRepository perfilRepository;

    @PostMapping
    @Transactional
    public ResponseEntity registrarPerfil(@RequestBody @Valid DatosRegistroPerfil datos,
                                          UriComponentsBuilder uriComponentsBuilder){
        var perfil = new Perfil(datos);
        perfilRepository.save(perfil);
        var uri = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(perfil.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosDetallePerfil(perfil));

    }
}
