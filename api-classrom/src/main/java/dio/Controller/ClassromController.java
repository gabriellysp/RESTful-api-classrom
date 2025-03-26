package dio.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import dio.Repository.ClassromRepository;
import dio.model.Classrom;

import java.util.List;

@RestController
@RequestMapping("/classrom")
public class ClassromController {

    private static final Object Classrom = null;
        @Autowired
        private ClassromRepository classromRepository;
    
        @GetMapping
        public List<Classrom> listaClassroms(){
            return classromRepository.findAll(); 
    }

    @PutMapping("/{id}")
    public Classrom atualizarClassroom(@PathVariable Long id, @RequestBody Classrom classrom) {
        Classrom existingClassroom = classromRepository.findById(id).orElseThrow();
        existingClassroom.setNome(classrom.getNome());
        existingClassroom.setDescricao(classrom.getDescricao());
        return classromRepository.save(existingClassroom);
    }

    @DeleteMapping("{id}")
    public void deletarClassroom(@PathVariable Long id) {
        classromRepository.deleteById(id);
    }

}
