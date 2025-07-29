/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.autodemia.controller;

import com.autodemia.domain.Curso;
import com.autodemia.domain.CursoEstudiante;
import com.autodemia.domain.Semana;
import com.autodemia.domain.Usuario;
import com.autodemia.service.CursoService;
import com.autodemia.service.CursoEstudianteService;
import com.autodemia.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.autodemia.service.SemanaService;
import com.autodemia.service.impl.SemanaServiceImpl;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CursoEstudianteService cursoEstudianteService;
    
    @Autowired
    private SemanaService semanaService;

    @GetMapping("/cursos")
    public String verCursosDisponibles(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Usuario estudiante = usuarioService.findByEmail(userDetails.getUsername());
        List<Curso> cursosDisponibles = cursoService.findAll();
        List<CursoEstudiante> cursosInscritos = cursoEstudianteService.findByEstudiante(estudiante);

        model.addAttribute("cursos", cursosDisponibles);
        model.addAttribute("misCursos", cursosInscritos);
        return "estudiante/index";

    }

    @PostMapping("/inscribirse/{cursoId}")
    public String inscribirse(@PathVariable Long cursoId, @AuthenticationPrincipal UserDetails userDetails) {
        Usuario estudiante = usuarioService.findByEmail(userDetails.getUsername());
        Curso curso = cursoService.findById(cursoId);
        if (cursoEstudianteService.yaInscritoEnCurso(curso.getId(), estudiante)) {
            return "redirect:/estudiante/cursos?error=yaInscrito";
        }

        cursoEstudianteService.inscribirEstudianteEnCurso(curso.getId(), estudiante);
        return "redirect:/estudiante/cursos";
    }

    @GetMapping("/mis-cursos")
    public String verCursosInscritos(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        Usuario estudiante = usuarioService.findByEmail(userDetails.getUsername());
        List<CursoEstudiante> cursosInscritos = cursoEstudianteService.findByEstudiante(estudiante);

        model.addAttribute("cursosInscritos", cursosInscritos);
        return "estudiante/mis_cursos";
    }

    @GetMapping("/curso/{id}")
    public String verCurso(@PathVariable Long id, Model model, @AuthenticationPrincipal UserDetails userDetails) {      
        Curso curso = cursoService.findById(id);


        model.addAttribute("curso", curso);

        // Puedes agregar más detalles: módulos, lecciones, tareas, etc.
        return "estudiante/curso_detalle";  
    }

}
