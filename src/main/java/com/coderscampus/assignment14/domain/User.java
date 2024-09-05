package com.coderscampus.assignment14.domain;

public class User {
	private Long idCounter = 0L;
	private Long userId;
	private String username;
	
	public User() {
    }
	
	public User(String username) {
		this.userId = generateId();
		this.username = username;
	}
	
	private synchronized Long generateId() {
		return ++idCounter;
	}
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + "]";
	}
}
