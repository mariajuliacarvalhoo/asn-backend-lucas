package br.com.asn.checkin_api.models.mappers;

import br.com.asn.checkin_api.models.Evento;
import br.com.asn.checkin_api.models.dto.EventoDTO;
import org.mapstruct.Mapper;


@Mapper (componentModel = "spring")
public interface EventoMapper {

    EventoDTO toEventoDTO(Evento evento);
    Evento toEvento(EventoDTO eventoDTO);

}
