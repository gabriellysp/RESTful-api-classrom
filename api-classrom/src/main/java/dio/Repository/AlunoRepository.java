package dio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dio.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
