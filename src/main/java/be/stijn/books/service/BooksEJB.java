package be.stijn.books.service;

import javax.ejb.Stateless;

@Stateless
public class TestEJB {
	public String getTest() {
		return "Test Success!";
	}
}
