package Formativa3Semana8P2package.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Formativa3Semana8P2package.Model.Paciente;
import Formativa3Semana8P2package.Repository.PacienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService{
    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(Long id) {
        return pacienteRepository.findById(id);
    }
    
    @Override
    public Paciente createPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente updatePaciente(Long id, Paciente paciente){
        if(pacienteRepository.existsById(id)){
            paciente.setId(id);
            return pacienteRepository.save(paciente);
        }
        else{
            return null;
        }

    }

    @Override
    public void deletePaciente(Long id){
        pacienteRepository.deleteById(id);
    }
}