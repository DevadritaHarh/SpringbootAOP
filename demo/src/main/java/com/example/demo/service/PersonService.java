package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.entity.Person;
import com.example.demo.repository.PersonRepository;



@Service
public class PersonService {

	
	@Autowired
	private PersonRepository personRepository;
 
	public List<Person> getAll() {
		return personRepository.findAll();
	}

	public Optional<Person> getPersonById(Long id) {
		return personRepository.findById(id);
	}

	public Person savePerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person updatePerson(Long id, Person person) {
		Person originalPerson= personRepository.findById(id).orElseThrow();
		originalPerson.setName(person.getName());
		originalPerson.setAge(person.getAge());
		return personRepository.save(originalPerson);
	}
	
	public List<Person> updatePersonList( List<Person> personList) {
		List<Person> updatedPersonList= new ArrayList<>();
		personList.forEach(Person->{
			Person originalPerson= personRepository.findById(Person.getId()).orElseThrow(()-> new UserNotFoundException("Persion Not Found"));
			originalPerson.setName(Person.getName());
			originalPerson.setAge(Person.getAge());
			Person updatedPerson=personRepository.save(originalPerson);
			updatedPersonList.add(updatedPerson);
		});
		
		return updatedPersonList;
	}
	

}
