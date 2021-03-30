package org.client;

import org.client.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private RestTemplate restTemplate;
    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    private String URL = "http://localhost:8080/RestSpringMVC/api/people";

    public List<People> getAllPeople(){
        ResponseEntity<List<People>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<People>>() {});

        return responseEntity.getBody();
    }
    public People getPerson(int id){

        return restTemplate.getForObject(URL + "/" + id, People.class);

    }
    public void savePerson(People person) {
        int id = person.getPeopleId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(URL, person, String.class);

            System.out.println("New person was added.");
            System.out.println(responseEntity.getBody());
        }
        else {
            restTemplate.put(URL,HttpMethod.PUT,person);

            System.out.println("Person with ID = " + id + " was updated.");
        }
    }


    public void deletePerson(int id){
        restTemplate.delete(URL + "/" + id);
        System.out.println("Person with ID = " + id + " was deleted");
    }
}
