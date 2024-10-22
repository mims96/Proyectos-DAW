package rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import rest.modelo.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
