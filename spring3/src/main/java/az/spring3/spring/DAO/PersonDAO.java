package az.spring3.spring.DAO;

import az.spring3.spring.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private List<Person> people;
    private static int PEOPLE_ID_SEQUENCE;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_ID_SEQUENCE, "Person_" + PEOPLE_ID_SEQUENCE, 20, "tes@mail"));
        people.add(new Person(++PEOPLE_ID_SEQUENCE, "Person_" + PEOPLE_ID_SEQUENCE, 20, "tes@mail"));
        people.add(new Person(++PEOPLE_ID_SEQUENCE, "Person_" + PEOPLE_ID_SEQUENCE, 20, "tes@mail"));
        people.add(new Person(++PEOPLE_ID_SEQUENCE, "Person_" + PEOPLE_ID_SEQUENCE, 20, "tes@mail"));
        people.add(new Person(++PEOPLE_ID_SEQUENCE, "Person_" + PEOPLE_ID_SEQUENCE, 20, "tes@mail"));
    }

    public List<Person> index() {
        return people;
    }

    public Person showById(int id) {
        return people.stream().filter(pers -> pers.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_ID_SEQUENCE);
        people.add(person);
    }

    public void update(int id, Person person){
        Person oldPerson = showById(id);
        oldPerson.setName(person.getName());
        oldPerson.setAge(person.getAge());
        oldPerson.setEmail(person.getEmail());
    }

    public void delete(int id){
        people.removeIf(person -> person.getId()==id);
    }
}
