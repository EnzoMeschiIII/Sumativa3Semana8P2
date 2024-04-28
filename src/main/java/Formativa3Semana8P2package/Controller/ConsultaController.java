package Formativa3Semana8P2package.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Formativa3Semana8P2package.Model.Consulta;
import Formativa3Semana8P2package.Service.ConsultaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Optional;



@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;


    @GetMapping("/{id}")
    public ResponseEntity<Consulta> getConsultaById(@PathVariable Long codigo) {
        Optional<Consulta> consultaExiste = consultaService.getConsultaById(codigo);

        if (consultaExiste.isPresent()) {
            return ResponseEntity.ok(consultaExiste.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Consulta> createConsulta(@RequestBody Consulta consulta) {

        Optional<Consulta> consultaExiste = consultaService.getConsultaById(consulta.getCodigo());
        if (consultaExiste.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Consulta createdConsulta = consultaService.createConsulta(consulta);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdConsulta);
    }
}
