package br.com.asn.checkin_api.services;

import br.com.asn.checkin_api.models.Evento;
import br.com.asn.checkin_api.models.dto.EventoDTO;
import br.com.asn.checkin_api.models.mappers.EventoMapper;
import br.com.asn.checkin_api.repositories.EventoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventoService {

    private final EventoMapper eventoMapper;
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository, EventoMapper eventoMapper) {
        this.eventoRepository = eventoRepository;
        this.eventoMapper = eventoMapper;
    }

    @Transactional
    public EventoDTO createEvento(EventoDTO eventoDTO){
        Evento evento = eventoMapper.toEvento(eventoDTO);
        evento.setStatus(true);
        eventoRepository.save(evento);
        return eventoMapper.toEventoDTO(evento);
    }
}
