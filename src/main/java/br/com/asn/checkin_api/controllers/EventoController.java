package br.com.asn.checkin_api.controllers;

import br.com.asn.checkin_api.models.dto.EventoDTO;
import br.com.asn.checkin_api.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @PostMapping
    public ResponseEntity<?> postEvento(@RequestBody EventoDTO eventoDTO){
        EventoDTO response = eventoService.createEvento(eventoDTO);

        return ResponseEntity.ok(response);

    }
}
