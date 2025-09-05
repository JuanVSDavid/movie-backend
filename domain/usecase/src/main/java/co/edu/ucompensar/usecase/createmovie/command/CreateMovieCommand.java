package co.edu.ucompensar.usecase.createmovie.command;

import java.util.Set;

public class CreateMovieCommand {
    private final String title;
    private final Set<Long> genresId;

    public CreateMovieCommand(String title, Set<Long> genresId) {
        this.title = title;
        this.genresId = genresId;
    }

    public String getTitle() {
        return title;
    }

    public Set<Long> getGenresId() {
        return genresId;
    }
}
