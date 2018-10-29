package io.smart.sample.mongodb;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * PersonService Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2018-10-29 14:50
 */
@Service
public class PersonService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private PersonRepository personRepository;

    public Optional<Person> getT(String id){
        return  personRepository.findById(id);
    }

    public void removeTById(String id){
        Query q = new Query(new Criteria("id").is(id));
        mongoTemplate.remove(q,Person.class);
    }

    private void updateT(Person person){
        Query q = new Query(new Criteria("id").is(person.getId()));
        Update update = new Update().set("lastName",person.getLastName());
        mongoTemplate.updateMulti(q,update,Person.class);
    }
}
