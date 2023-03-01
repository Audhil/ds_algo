package _Z_Oops_Sys_Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://neetcode.io/courses/ood-interview/4
public class _4DesignMovieRecommendation {

  //  movie
  private static class Movie {

    private final int id;
    private final String title;

    public Movie(int id, String title) {
      this.id = id;
      this.title = title;
    }

    public int getId() {
      return id;
    }

    public String getTitle() {
      return title;
    }
  }

  //  user
  private static class User {

    private final int id;
    private final String name;

    public User(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }
  }

  //  ratings enum
  private static enum Rating {
    NO_RATING, ONE, TWO, THREE, FOUR, FIVE
  }

  //  rating registry
  private static class RatingRegistry {

    private final Map<Integer, List<Movie>> userMoviesMap;
    private final Map<Integer, Map<Integer, Rating>> movieRatingsMap;

    private final List<Integer> userList;
    private final List<Movie> movieList;

    public RatingRegistry() {
      userMoviesMap = new HashMap<>();
      movieRatingsMap = new HashMap<>();
      userList = new ArrayList<>();
      movieList = new ArrayList<>();
    }

    private void addMovieRating(int userId, Movie movie, Rating rating) {
      if (!userMoviesMap.containsKey(userId)) {
        userMoviesMap.put(userId, new ArrayList<>());
      }
      if (!movieRatingsMap.containsKey(movie.getId())) {
        movieRatingsMap.put(movie.getId(), new HashMap<>());
      }
      userMoviesMap.get(userId).add(movie);
      movieRatingsMap.get(movie.getId()).put(userId, rating);
      userList.add(userId);
      movieList.add(movie);
    }

    private double getMovieAvgRating(Movie movie) {
      if (!movieRatingsMap.containsKey(movie.getId())) {
        return 0;
      }
      double sum = 0;
      Map<Integer, Rating> ratingMap = movieRatingsMap.get(movie.getId());
      for (Rating rating : ratingMap.values()) {
        sum += rating.ordinal();
      }
      return sum / ratingMap.size();
    }

    public Map<Integer, List<Movie>> getUserMoviesMap() {
      return userMoviesMap;
    }

    public Map<Integer, Map<Integer, Rating>> getMovieRatingsMap() {
      return movieRatingsMap;
    }

    public List<Integer> getUserList() {
      return userList;
    }

    public List<Movie> getMovieList() {
      return movieList;
    }
  }

  //  movie recommendation class
  private static class MovieRecommendation {

    private final RatingRegistry ratingRegistry;

    public MovieRecommendation(RatingRegistry ratingRegistry) {
      this.ratingRegistry = ratingRegistry;
    }

    private String recommendMovie(User user) {
      if (!ratingRegistry.getUserList().contains(user.getId())) {
        return recommendNewUserMovie();
      }
      return recommendExistingUserMovie(user);
    }

    private String recommendExistingUserMovie(User user) {
      Movie bestMovie = null;
      int similarityScore = Integer.MAX_VALUE;  //  Lower the better
      for (Integer reviewer : ratingRegistry.getUserList()) {
        int simScore = getSimilarityScore(user, reviewer);
        if (simScore < similarityScore) {
          similarityScore = simScore;
          bestMovie = recommendUnWatched(user);
        }
      }
      return bestMovie != null ? bestMovie.getTitle() : null;
    }

    private Movie recommendUnWatched(User user) {
      return null;
    }

    private int getSimilarityScore(User user, Integer reviewerId) {
//      ratingRegistry.get
      return 0;
    }

    private String recommendNewUserMovie() {
      List<Movie> movieList = ratingRegistry.getMovieList();
      Movie bestMovie = null;
      double bestRating = Integer.MIN_VALUE;
      for (Movie movie : movieList) {
        double rating = ratingRegistry.getMovieAvgRating(movie);
        if (bestRating < rating) {
          bestRating = rating;
          bestMovie = movie;
        }
      }
      return bestMovie != null ? bestMovie.getTitle() : null;
    }
  }
}
