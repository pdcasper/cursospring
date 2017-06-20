package com.pdcasper.springboot.repository;

import com.pdcasper.springboot.domain.Atleta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    List<Atleta> findByApellidos(String apellidos);
}
