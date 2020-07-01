package br.com.devdojo.repository;

import br.com.devdojo.model.User1;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author William Suane for DevDojo on 6/27/17.
 */
public interface UserRepository extends PagingAndSortingRepository<User1, Long> {
    User1 findByUsername(String username);
}
