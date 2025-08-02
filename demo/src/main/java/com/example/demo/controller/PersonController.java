package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.data.PersonDTO;
import com.example.demo.model.data.Post;
import com.example.demo.model.entity.Person;
import com.example.demo.service.PersonService;
import com.example.demo.service.PostService;
import com.example.demo.util.ConvertionUtil;


@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {
	@Autowired
	private  PersonService personService;
	
	@Autowired
	private PostService postService;
	
	@GetMapping("/hello")
	public String getMsg(){
		return "Hi";		
	}
	
	@GetMapping("/allpost")
	public List<Post> getAllPost(){
		return postService.getAllPost();		
	}
	
	
	@GetMapping("/allpost/{id}")
	public Post getPostById(@PathVariable Long id){
		return postService.getPostById(id);		
	}
	@PostMapping("/createpost")
	public Post createPost(@RequestBody Post post) {
		return postService.createPost(post);
	}
	
	@GetMapping("/all")
	public List<Person> getAllPerson(){
		return personService.getAll();		
	}
	
	
	@PostMapping("/save")
	public PersonDTO savePersonDTO(@RequestBody PersonDTO personDTO) {
		
		ConvertionUtil convertionUtil= new ConvertionUtil();
		Person person=convertionUtil.persionDtoToPersion(personDTO);
		Person personSaved = personService.savePerson(person);
		
		PersonDTO personDTORes= convertionUtil.persionToPersionDto(personSaved);
		return personDTORes	;
	}
	
	@GetMapping("/{id}")
	public Optional<Person> getPersonbyid(@PathVariable Long id){
		return personService.getPersonById(id);		
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
		return personService.updatePerson(id, person)	;
	}
	
	@PutMapping("/listupade")
	public List<Person> updatePersonList( @RequestBody List<Person> personList) {
		return personService.updatePersonList(personList);
	}
	

}
