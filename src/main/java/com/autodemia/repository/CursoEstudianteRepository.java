/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodemia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.autodemia.domain.CursoEstudiante;
import com.autodemia.domain.Usuario;


public interface CursoEstudianteRepository extends JpaRepository<CursoEstudiante, Long> {
    CursoEstudiante findByCursoIdAndEstudiante(Long cursoId, Usuario estudiante);
    

}