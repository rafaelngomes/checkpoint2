package br.com.fiap.checkpoint2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.checkpoint2.model.Paciente;

public interface PacienteRepository 
        extends JpaRepository <Paciente, Long>{

}