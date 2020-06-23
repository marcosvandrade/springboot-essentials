package br.com.devdojo.repository;

import br.com.devdojo.model.Student;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author William Suane for DevDojo on 6/9/17.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findByNameIgnoreCaseContaining(String name);
}
