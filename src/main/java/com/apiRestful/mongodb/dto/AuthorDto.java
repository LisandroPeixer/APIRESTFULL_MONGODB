package com.apiRestful.mongodb.dto;

import java.io.Serializable;

import com.apiRestful.mongodb.domain.User;

public class AuthorDto implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	
	public AuthorDto() {
	}

	public AuthorDto(User obj) {
		id = obj.getId();
		name = obj.getName();
	}
			
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	
}
