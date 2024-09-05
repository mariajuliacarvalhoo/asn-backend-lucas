package br.com.asn.checkin_api.models;


import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private LocalDateTime dataHora;

    @Column
    private Integer horaAula;

    @Column
    private String curso;

    @Column
    private String local;

    @Column
    private Boolean status;

    @Column
    private String palestrante;

    @Column
    private String profissao_palestrante;

    public Evento(String titulo, String descricao, LocalDateTime dataHora, Integer horaAula, String curso, String local, Boolean status, String palestrante, String profissao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.horaAula = horaAula;
        this.curso = curso;
        this.local = local;
        this.status = status;
        this.palestrante = palestrante;
        this.profissao_palestrante = profissao;
    }


}
