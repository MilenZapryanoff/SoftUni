package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.model.enums.CategoryNames;
import bg.softuni.pathfinder.model.enums.Level;

import java.util.Set;

public class AddRouteBindingModel {

    private String name;
    private String description;
    private Level level;
    private String videoUrl;
    private User author;
    private Set<CategoryNames> categories;

    public AddRouteBindingModel () {

    }

    public User getAuthor () {

        return author;
    }

    public AddRouteBindingModel setAuthor (User author) {

        this.author = author;
        return this;
    }

    public String getName () {

        return name;
    }

    public AddRouteBindingModel setName (String name) {

        this.name = name;
        return this;
    }

    public String getDescription () {

        return description;
    }

    public AddRouteBindingModel setDescription (String description) {

        this.description = description;
        return this;
    }

    public Level getLevel () {

        return level;
    }

    public AddRouteBindingModel setLevel (Level level) {

        this.level = level;
        return this;
    }

    public String getVideoUrl () {

        return videoUrl;
    }

    public AddRouteBindingModel setVideoUrl (String videoUrl) {

        this.videoUrl = videoUrl;
        return this;
    }

    public Set<CategoryNames> getCategories () {

        return categories;
    }

    public AddRouteBindingModel setCategories (Set<CategoryNames> categories) {

        this.categories = categories;
        return this;
    }

}
