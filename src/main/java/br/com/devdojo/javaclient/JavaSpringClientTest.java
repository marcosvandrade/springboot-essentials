package br.com.devdojo.javaclient;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.devdojo.model.Student;

/**
 * @author William Suane for DevDojo on 7/5/17.
 */
public class JavaSpringClientTest {
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplateBuilder()
                        .rootUri("http://localhost:8081/v1/protected/students")
                        .basicAuthorization("toyo", "devdojo").build();
        // Student student = restTemplate.getForObject("/{id}", Student.class, 15);
        // System.out.println(student);

        // Student student = restTemplate.getForObject("/{id}", Student.class, 12);
        // ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 14);
        
        // System.out.println(student);
        // System.out.println(forEntity.getBody());
        
        // Student[] students = restTemplate.getForObject("/", Student[].class);
        // System.out.println(Arrays.toString(students));
        
        ResponseEntity<List<Student>> exchange =  restTemplate.exchange("/", HttpMethod.GET, null,
                                                                                new ParameterizedTypeReference<List<Student>>() { });
        
        System.out.println(exchange.getBody());

//         Student studentPost = new Student();
//         studentPost.setName("John Wick 2");
//         studentPost.setEmail("john@pencil.com");
// //        studentPost.setId(29L);
//         JavaClientDAO dao = new JavaClientDAO();
// //        System.out.println(dao.findById(111));
// //        List<Student> students = dao.listAll();
// //        System.out.println(students);
// //        System.out.println(dao.save(studentPost));
// //        dao.update(studentPost);
//         dao.delete(29);

    }

}
