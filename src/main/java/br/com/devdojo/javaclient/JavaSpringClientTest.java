package br.com.devdojo.javaclient;

import br.com.devdojo.model.Student;

/**
 * @author William Suane for DevDojo on 7/5/17.
 */
public class JavaSpringClientTest {
    public static void main(String[] args) {

        // RestTemplate restTemplate = new RestTemplateBuilder()
        //                 .rootUri("http://localhost:8081/v1/protected/students")
        //                 .basicAuthorization("toyo", "devdojo").build();

        // RestTemplate restTemplateAdmin = new RestTemplateBuilder()
        // .rootUri("http://localhost:8081/v1/admin/students")
        // .basicAuthorization("toyo", "devdojo").build();
        // // Student student = restTemplate.getForObject("/{id}", Student.class, 15);
        // // System.out.println(student);

        // Student student = restTemplate.getForObject("/{id}", Student.class, 12);
        // ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 14);
        
        // System.out.println(student);
        // System.out.println(forEntity.getBody());
        
        // // Student[] students = restTemplate.getForObject("/", Student[].class);
        // // System.out.println(Arrays.toString(students));
        
        // ResponseEntity<PageableResponse<Student>> exchange =  restTemplate.exchange("/?sort=id,desc&sort=name,asc", HttpMethod.GET, null,
        //                                                                         new ParameterizedTypeReference<PageableResponse<Student>>() { });
        
        // System.out.println(exchange);
        Student studentPost = new Student();
        studentPost.setName("John Wick 3");
        studentPost.setEmail("john@pencil.com");
        // ResponseEntity<Student> exchangePost =  restTemplateAdmin.exchange("/", HttpMethod.POST, new HttpEntity<>(studentPost,createJSONHeader()), Student.class);
        //studentPost.setId(46L);
        JavaClientDAO dao = new JavaClientDAO();
        //System.out.println(dao.findById(142));
        // System.out.println(dao.listAll());
        // List<Student> students = dao.listAll();
        // System.out.println(students);
        // Student studentPostForObject = restTemplateAdmin.postForObject("/", studentPost, Student.class);
        // ResponseEntity<Student> studentResponseEntity = restTemplateAdmin.postForEntity("/", studentPost, Student.class);
        // System.out.println(exchangePost);
        // System.out.println(studentPostForObject);
        // System.out.println(studentResponseEntity);
        // System.out.println(dao.save(studentPost));
        //dao.update(studentPost);
         dao.delete(43);
         
    }

    // private static HttpHeaders createJSONHeader(){
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);
    //     return headers;
    // }

}
