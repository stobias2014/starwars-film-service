package com.tobias.saul.starwarsfilmservice.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tobias.saul.starwarsfilmservice.model.Film;
import com.tobias.saul.starwarsfilmservice.web.response.FilmsResponse;

@RestController
@RequestMapping("/films")
public class FilmWebService {
	
	private final String BASE_URL = "https://swapi.dev/api/films/";
	private final RestTemplate restTemplate;
	
	@Autowired
	public FilmWebService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@GetMapping
	public List<Film> getAllFilms() {
		
		ResponseEntity<FilmsResponse> response = restTemplate.getForEntity(BASE_URL, FilmsResponse.class);
		
		List<Film> films = response.getBody().getFilms();
		
		return films;
	}
	
	@GetMapping("{filmId}")
	public Film getFilm(@PathVariable("filmId") Integer filmId) {
		ResponseEntity<FilmsResponse> response = restTemplate.getForEntity(BASE_URL, FilmsResponse.class);
		
		List<Film> films = response.getBody().getFilms();
		
		Film film = films.get(filmId - 1);
		
		return film;
	}

}
