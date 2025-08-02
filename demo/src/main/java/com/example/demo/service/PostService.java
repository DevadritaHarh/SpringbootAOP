package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import com.example.demo.model.data.Post;

import reactor.core.publisher.Mono;

@Service
public class PostService {
	
	public List<Post> getAllPost(){
		WebClient webClient =  WebClient.create();
		List<Post> allPost= webClient.get().uri("https://jsonplaceholder.typicode.com/posts").retrieve().bodyToFlux(Post.class).collectList().block();
		return allPost;
	}
	public Post getPostById(Long id){
		WebClient webClient =  WebClient.create();
		Post post= webClient.get().uri("https://jsonplaceholder.typicode.com/posts/{id}", id).retrieve().bodyToMono(Post.class).block();
		return post;
	}
	
	public Post createPost(Post postRequest){
		WebClient webClient =  WebClient.create();
		Post post= webClient.post().uri("https://jsonplaceholder.typicode.com/posts").bodyValue(postRequest).retrieve().bodyToMono(Post.class).block();
		return post;
	}


}
