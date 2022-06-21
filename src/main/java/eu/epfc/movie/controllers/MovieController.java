package eu.epfc.movie.controllers;

import eu.epfc.movie.entities.Movie;
import eu.epfc.movie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieController{
    @Autowired
    private MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("index")
    public String getMovie(Model model){
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("moviesList", movies);
        return "movies";
    }

    @GetMapping("form")
    public String createForm(Model model){
        List<Movie> movies = movieRepository.findAll();
        model.addAttribute("movie", new Movie());
        return "movie-create";
    }

    @PostMapping("form")
    public String updateForm(Movie movie){
        movieRepository.save(movie);
        return "redirect:index";
    }

    @GetMapping("edit")
    public String editForm(Model model, Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        model.addAttribute("movie",movie.get());
        return "movie-edit";
    }

    @GetMapping("delete")
    public String delete(Long id){
        movieRepository.deleteById(id);
        return "redirect:index";
    }
}
