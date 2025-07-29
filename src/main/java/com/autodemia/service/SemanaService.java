/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.autodemia.service;

import com.autodemia.domain.Curso;
import com.autodemia.domain.Semana;
import java.util.List;

/**
 *
 * @author josti
 */
public interface SemanaService {
    List<Semana> findByCursoOrderByNumeroAsc(Curso curso);
}
