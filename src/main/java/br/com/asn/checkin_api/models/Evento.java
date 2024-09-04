package br.com.asn.checkin_api.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Table(name = "evento")
@Getter
@Setter
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
    private LocalDateTime data;

    @Column
    private int horaaula;

    @Column
    private String curso;

    @Column
    private String local;

    @Column
    private Boolean status;

}
