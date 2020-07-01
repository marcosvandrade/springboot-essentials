package br.com.devdojo.endpoint;

import br.com.devdojo.error.ResourceNotFoundException;
import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author William Suane for DevDojo on 6/5/17.
 */
@RestController
@RequestMapping("students")
public class StudentEndpoint {

    private final StudentRepository studentDAO;
    @Autowired
    public StudentEndpoint(StudentRepository studentDAO) {
        this.studentDAO = studentDAO;
    }

    // @GetMapping(path = "admin/students")
    // @ApiOperation(value = "Return a list with all students", response = Student[].class)
    // public ResponseEntity<?> listAll(Pageable pageable) {
    //     return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
    // }

    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
        verifyIfStudentExists(id);
        Student student = studentDAO.findOne(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // @GetMapping(path = "protected/students/{id}")
    // public ResponseEntity<?> getStudentById(@PathVariable("id") Long id, Authentication authentication) {
    //     System.out.println(authentication);
    //     verifyIfStudentExists(id);
    //     Student student = studentDAO.findOne(id);
    //     return new ResponseEntity<>(student, HttpStatus.OK);
    // }

    @GetMapping(path = "/findByName/{name}")
    public ResponseEntity<?> findStudentsByName(@PathVariable String name){
         return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
     }

    // @PostMapping(path = "admin/students")
    // @Transactional(rollbackFor = Exception.class)
    // public ResponseEntity<?> save(@Valid @RequestBody Student student) {
    //     return new ResponseEntity<>(studentDAO.save(student),HttpStatus.CREATED);
    // }

    @PostMapping
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> save(@Valid @RequestBody Student student) {
       return new ResponseEntity<>(studentDAO.save(student),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        verifyIfStudentExists(id);
        studentDAO.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student) {
        verifyIfStudentExists(student.getId());
        studentDAO.save(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//     @DeleteMapping(path = "admin/students/{id}")
// //    @PreAuthorize("hasRole('ADMIN')")
//     public ResponseEntity<?> delete(@PathVariable Long id) {
//         verifyIfStudentExists(id);
//         studentDAO.delete(id);
//         return new ResponseEntity<>(HttpStatus.OK);
//     }

//     @PutMapping(path = "admin/students")
//     public ResponseEntity<?> update(@RequestBody Student student) {
//         verifyIfStudentExists(student.getId());
//         studentDAO.save(student);
//         return new ResponseEntity<>(HttpStatus.OK);
//     }
    private void verifyIfStudentExists(Long id){
        if (studentDAO.findOne(id) == null)
            throw new ResourceNotFoundException("Student not found for ID: "+id);
    }
}
