package br.com.asn.checkin_api.controllers;

import br.com.asn.checkin_api.models.Evento;
import br.com.asn.checkin_api.models.dto.EventoDTO;
import br.com.asn.checkin_api.services.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<List<Evento>> getAllEventos(){
        return ResponseEntity.ok(eventoService.getAllEventos());
        // List<Evento> eventos = eventoService.getAllEventos();
        // return ResponseEntity.ok(eventos);
    }

    @GetMapping("/status")
    public ResponseEntity<List<Evento>> getAllEventosByStatus(){
        return ResponseEntity.ok(eventoService.getAllEventosByStatus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> getEventoById(@PathVariable String id){
        Optional<Evento> optionalEvento = eventoService.getEventoById(id);
    
        if (optionalEvento.isPresent()) {
            return ResponseEntity.ok(optionalEvento.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // @GetMapping("/usuario/{usuarioId}")
    // public ResponseEntity<List<Evento>> getAllEventosFromUsuarioId(@PathVariable Long usuarioId) {
    //     List<Evento> eventos = eventoService.getAllEventosFromUsuarioId(usuarioId);
    //     return ResponseEntity.ok(eventos);
    // }

    @PutMapping("/{id}")
    public ResponseEntity<EventoDTO> updateEvento(@PathVariable String id, @RequestBody EventoDTO eventoDTO){
        EventoDTO response = eventoService.updateEvento(id, eventoDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<Void> enableEvento(@PathVariable String id){
        eventoService.enableEvento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<Void> disableEvento(@PathVariable String id){
        eventoService.disableEvento(id);
        return ResponseEntity.noContent().build();
    }





}
