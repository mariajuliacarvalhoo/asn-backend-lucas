package br.com.asn.checkin_api.models.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EventoDTO {
    private String id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private Integer horaAula;
    private String curso;
    private String local;
    private Boolean status;
    private String palestrante;
    private String profissaoPalestrante;

}
