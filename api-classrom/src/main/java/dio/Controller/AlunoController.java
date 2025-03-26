package dio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dio.Repository.AlunoRepository;
import dio.model.Aluno;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarAlunos(){
         return alunoRepository.findAll();
    }

    @PostMapping
    public Aluno  adicionarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno aluno) {
        Aluno existingAluno = alunoRepository.findById(id).orElseThrow();
        existingAluno.setNome(aluno.getNome());
        existingAluno.setMatricula(aluno.getMatricula());
        return alunoRepository.save(existingAluno);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunoRepository.deleteById(id);
    }

}
