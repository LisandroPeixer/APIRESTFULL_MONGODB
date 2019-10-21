package com.apiRestful.mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.apiRestful.mongodb.domain.Post;
import com.apiRestful.mongodb.domain.User;
import com.apiRestful.mongodb.dto.AuthorDto;
import com.apiRestful.mongodb.dto.ComentDto;
import com.apiRestful.mongodb.repository.PostRepository;
import com.apiRestful.mongodb.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User anita = new User(null, "Anita Hemp", "anita@gmail.com"); 
		User alex = new User(null, "Alex Green", "alex@gmail.com"); 
		User bob = new User(null, "Bob Grey", "bob@gmail.com"); 
		
		userRepository.saveAll(Arrays.asList(anita, alex, bob));	
		
		Post post1 = new Post (null, sdf.parse("20/10/2019"), "Vou Viajar", "Estou indo pra Nova York", new AuthorDto(alex));
		Post post2 = new Post (null, sdf.parse("18/10/2019"), "Começando em novo Emprego", "Começo amanha as 8:00hs", new AuthorDto (bob));
		 
		ComentDto c1 = new ComentDto("Posso ir junto?", sdf.parse("21/10/2019"), new AuthorDto(anita));
		ComentDto c2 = new ComentDto("Inveja!!!", sdf.parse("22/10/2019"), new AuthorDto(bob));
		ComentDto c3 = new ComentDto("Traz um Iphone", sdf.parse("21/10/2019"), new AuthorDto(anita));

		post1.getComents().addAll(Arrays.asList(c1, c2, c3));
		
		 postRepository.saveAll(Arrays.asList(post1, post2));

		 alex.getPosts().addAll(Arrays.asList(post1));
		 bob.getPosts().addAll(Arrays.asList(post2));
		 userRepository.save(alex);
		 userRepository.save(bob);
	}

}
