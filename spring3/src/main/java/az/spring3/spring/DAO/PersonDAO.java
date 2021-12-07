package az.spring3.spring.DAO;

import az.spring3.spring.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {

        return jdbcTemplate.query("SELECT * FROM PERSON",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person showById(int id) {

        return jdbcTemplate.query("SELECT * FROM PERSON WHERE ID = ?", new Object[]{id},new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {

        jdbcTemplate.update("INSERT INTO PERSON VALUES (?, ?, ?, ?)",new Object[]{person.getId(),person.getName(),person.getAge(),person.getEmail()});
    }

    public void update(int id, Person person) {

        jdbcTemplate.update("UPDATE PERSON SET NAME = ?, AGE = ?, EMAIL = ? WHERE ID = ?",new Object[]{person.getName(),person.getAge(),person.getEmail(), id});

    }

    public void delete(int id) {

        jdbcTemplate.update("DELETE FROM PERSON WHERE ID = ?", new Object[]{id});
    }
}

