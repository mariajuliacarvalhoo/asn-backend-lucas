package br.com.asn.checkin_api.repositories;

import br.com.asn.checkin_api.models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, String> {

    List<Evento> findByStatusTrue();

}
