package br.com.asn.checkin_api.services;

import br.com.asn.checkin_api.models.Evento;
import br.com.asn.checkin_api.models.dto.EventoDTO;
import br.com.asn.checkin_api.models.mappers.EventoMapper;
import br.com.asn.checkin_api.repositories.EventoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.List;

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

    public List<Evento> getAllEventos(){
        return eventoRepository.findAll();
    }

    public List<Evento> getAllEventosByStatus(){
        return eventoRepository.findByStatusTrue();
    }

    public Optional<Evento> getEventoById(String id){
        return eventoRepository.findById(id);
    }

    @Transactional
    public EventoDTO updateEvento(String id, EventoDTO eventoDTO){

        Optional<Evento> optionalEvento = eventoRepository.findById(id);

        if (optionalEvento.isPresent()) {
            Evento evento = optionalEvento.get();

            if (eventoDTO.getTitulo() != null) {
                evento.setTitulo(eventoDTO.getTitulo());
            }
            if (eventoDTO.getDescricao() != null) {
                evento.setDescricao(eventoDTO.getDescricao());
            }
            if (eventoDTO.getDataHora() != null) {
                evento.setDataHora(eventoDTO.getDataHora());
            }
            if (eventoDTO.getHoraAula() != null) {
                evento.setHoraAula(eventoDTO.getHoraAula());
            }
            if (eventoDTO.getCurso() != null) {
                evento.setCurso(eventoDTO.getCurso());
            }
            if (eventoDTO.getLocal() != null) {
                evento.setLocal(eventoDTO.getLocal());
            }

            eventoRepository.save(evento);

            return eventoMapper.toEventoDTO(evento);
        } else {
           
            throw new RuntimeException("Evento não encontrado com o id: " + id);
        }
    }


    @Transactional
    public void enableEvento(String id){
        Optional<Evento> optionalEvento = eventoRepository.findById(id);

        if (optionalEvento.isPresent()) {
            Evento evento = optionalEvento.get();
            evento.setStatus(true);
            eventoRepository.save(evento);
        } else {
            throw new RuntimeException("Evento não encontrado com o id: " + id);
        }
    }

    @Transactional
    public void disableEvento(String id){
        Optional<Evento> optionalEvento = eventoRepository.findById(id);

        if (optionalEvento.isPresent()) {
            Evento evento = optionalEvento.get();
            evento.setStatus(false);
            eventoRepository.save(evento);
        } else {
            throw new RuntimeException("Evento não encontrado com o id: " + id);
        }
    }

    //Fazer GetAllEventosFromUsuarrioId(UsuarioId)
}

