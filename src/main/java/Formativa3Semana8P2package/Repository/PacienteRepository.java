package Formativa3Semana8P2package.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Formativa3Semana8P2package.Model.Paciente;

public interface PacienteRepository extends JpaRepository <Paciente, Long>{
    
}