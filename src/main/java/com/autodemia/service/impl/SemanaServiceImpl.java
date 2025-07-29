/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodemia.service.impl;

import com.autodemia.dao.CursoDao;
import com.autodemia.dao.SemanaDao;
import com.autodemia.domain.Curso;
import com.autodemia.domain.Semana;
import com.autodemia.service.CursoService;
import com.autodemia.service.SemanaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SemanaServiceImpl implements SemanaService {

    @Autowired
    private SemanaDao semanaDao;

    @Autowired
    private CursoService cursoService;

    @Override
    public List<Semana> findByCursoOrderByNumeroAsc(Curso curso) {
        return semanaDao.findByCursoOrderByNumeroAsc(curso);
    }
       
}
