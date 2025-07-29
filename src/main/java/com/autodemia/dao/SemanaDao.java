
package com.autodemia.dao;

import com.autodemia.domain.Curso;
import com.autodemia.domain.Semana;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SemanaDao extends JpaRepository<Semana, Long> {
    List<Semana> findByCursoOrderByNumeroAsc(Curso curso);
}
