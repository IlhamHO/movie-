package eu.epfc.movie;

import eu.epfc.movie.entities.Movie;
import eu.epfc.movie.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MovieApplication implements CommandLineRunner {
	private MovieRepository movieRepository;

	public MovieApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Movie> movies = new ArrayList<>();
		movieRepository.saveAll(movies);
	}
}

