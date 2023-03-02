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
        if (user.getId() == reviewer) {
          continue;
        }
        int simScore = getSimilarityScore(user, reviewer);
        if (simScore < similarityScore) {
          similarityScore = simScore;
          bestMovie = recommendUnWatched(user, reviewer);
        }
      }
      return bestMovie != null ? bestMovie.getTitle() : null;
    }

    private Movie recommendUnWatched(User user, int reviewerId) {
      int bestRating = 0;
      Movie bestMovie = null;
      for (Movie movie : ratingRegistry.getUserMoviesMap().get(reviewerId)) {
        Map<Integer, Rating> rating = ratingRegistry.getMovieRatingsMap().get(movie.getId());
        //  yet user unwatched this movie
        if (!rating.containsKey(user.getId()) && rating.get(reviewerId).ordinal() > bestRating) {
          bestRating = rating.get(reviewerId).ordinal();
          bestMovie = movie;
        }
      }
      return bestMovie;
    }

    private int getSimilarityScore(User user, Integer reviewerId) {
      int score = Integer.MAX_VALUE;
      for (Movie movie : ratingRegistry.getUserMoviesMap().get(reviewerId)) {
        Map<Integer, Rating> rating = ratingRegistry.getMovieRatingsMap().get(movie.getId());
        //  if user also rated the movie
        if (rating.containsKey(user.getId())) {
          score = (score == Integer.MAX_VALUE) ? 0 : score;
          score += Math.abs(rating.get(user.getId()).ordinal() - rating.get(reviewerId).ordinal());
        }
      }
      return score;
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

  public static void main(String[] args) {
    User user1 = new User(1, "User 1");
    User user2 = new User(2, "User 2");
    User user3 = new User(3, "User 3");

    Movie movie1 = new Movie(1, "Batman Begins");
    Movie movie2 = new Movie(2, "Liar Liar");
    Movie movie3 = new Movie(3, "The Godfather");

    RatingRegistry ratings = new RatingRegistry();
    ratings.addMovieRating(user1.getId(), movie1, Rating.FIVE);
    ratings.addMovieRating(user1.getId(), movie2, Rating.TWO);
    ratings.addMovieRating(user2.getId(), movie2, Rating.TWO);
    ratings.addMovieRating(user2.getId(), movie3, Rating.FOUR);

    MovieRecommendation recommender = new MovieRecommendation(ratings);

    System.out.println(recommender.recommendMovie(user1)); // The Godfather
    System.out.println(recommender.recommendMovie(user2)); // Batman Begins
    System.out.println(recommender.recommendMovie(user3)); // Batman Begins
  }
}
