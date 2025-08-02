package com.example.demo.util;

import org.modelmapper.ModelMapper;

import com.example.demo.model.data.PersonDTO;
import com.example.demo.model.entity.Person;

public class ConvertionUtil {
	
	private final ModelMapper modelMapper = new ModelMapper();
		
	public Person persionDtoToPersion(PersonDTO personDTO) {
		Person person = new Person();
		person= modelMapper.map(personDTO, Person.class);
		return person;
	}
	
	public PersonDTO persionToPersionDto(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO = modelMapper.map(person, PersonDTO.class);
		return personDTO;
	}

}
