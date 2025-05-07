package br.com.fiap.checkpoint2.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.checkpoint2.dto.PacienteRequestCreate;
import br.com.fiap.checkpoint2.dto.PacienteRequestUpdate;
import br.com.fiap.checkpoint2.model.Paciente;
import br.com.fiap.checkpoint2.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public Paciente createPaciente (PacienteRequestCreate dto) {
        Paciente paciente = dto.toModel();
        LocalDateTime now = LocalDateTime.now();
        paciente.setCreatedAt(now);
        paciente.setUpdatedAt(now);
        return pacienteRepository.save(paciente);
    }

    public Optional<Paciente> updatePaciente (PacienteRequestUpdate dto, Long id) {
        return pacienteRepository.findById(id)
        .map(p -> {
            p.setUpdatedAt(LocalDateTime.now());
            return pacienteRepository.save(dto.toModel(p));
        });
    }
    
    public boolean deletePaciente (Long id) {
        if (pacienteRepository.findById(id).isPresent()) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Paciente> getPacienteById (Long id) {
        return pacienteRepository.findById(id);
    }

    public List <Paciente> getAll () {
        return pacienteRepository.findAll();
    }
}