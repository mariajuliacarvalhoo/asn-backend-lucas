package br.com.asn.checkin_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.asn.checkin_api.models.Usuario;

public interface UserRepository extends JpaRepository<Usuario, String>{

}
