package com.tobias.saul.starwarsfilmservice.web.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tobias.saul.starwarsfilmservice.model.Film;

public class FilmsResponse {
	
	@JsonProperty(value = "results")
	private List<Film> films;

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((films == null) ? 0 : films.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilmsResponse other = (FilmsResponse) obj;
		if (films == null) {
			if (other.films != null)
				return false;
		} else if (!films.equals(other.films))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FilmsResponse [films=" + films + "]";
	}
	
	

}
