package io.smart.sample.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * PersonRepository Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2018-10-29 14:46
 */
public interface PersonRepository extends MongoRepository<Person,String> {

    List<Person> findByLastName(String name);
}
