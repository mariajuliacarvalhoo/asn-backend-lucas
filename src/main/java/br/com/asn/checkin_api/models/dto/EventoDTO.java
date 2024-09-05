package br.com.asn.checkin_api.models.dto;

import br.com.asn.checkin_api.models.Evento;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
@Getter
public class EventoDTO {

    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private Integer horaAula;
    private String curso;
    private String local;
    private Boolean status;
    private String palestrante;
    private String profissao_palestrante;

    public Evento eventoConverter(){
        return new Evento(titulo, descricao, dataHora, horaAula, curso, local, status, palestrante, profissao_palestrante);
    }

}
