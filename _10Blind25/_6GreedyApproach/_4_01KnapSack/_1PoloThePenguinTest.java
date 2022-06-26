package _10Blind25._6GreedyApproach._4_01KnapSack;

import java.util.ArrayList;
import java.util.List;

//  THIS IS NOT A GREEDY EXAMPLE
//  https://youtu.be/cVK62OqHOfE?list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&t=2254
//  https://www.youtube.com/watch?v=cVK62OqHOfE&list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&index=5&ab_channel=CodeChef
//  https://www.codechef.com/submit/PPTEST
public class _1PoloThePenguinTest {

  private static class Question {

    int noOfTests;
    int points;
    int prepTime;

    public Question(int noOfTests, int points, int prepTime) {
      this.noOfTests = noOfTests;
      this.points = points;
      this.prepTime = prepTime;
    }

    @Override
    public String toString() {
      return "Question{" +
          "noOfTests=" + noOfTests +
          ", points=" + points +
          ", prepTime=" + prepTime +
          '}';
    }
  }

  private static int maxPointsAchieved() {
    int maxTimeToPrepare = 7; //  7 mins
    int questionCount = 3;  //  1..N
    int[] questions = {1, 2, 3};
    int[] questionPoints = {2, 3, 3};
    int[] questionPrepTime = {3, 5, 3};
    List<Question> questionList = new ArrayList<>();
    for (int i = 0; i < questionCount; i++) {
      questionList.add(new Question(questions[i], questionPoints[i], questionPrepTime[i]));
    }
    return _01KnapSack(questionList, questionList.size(), maxTimeToPrepare);
  }

  private static int _01KnapSack(
      List<Question> questionList,
      int questionPos,
      int maxTimeToPrepare) {
    if (questionPos == 0 || maxTimeToPrepare <= 0) {
      return 0;
    }
    Question question = questionList.get(questionPos - 1);
    //  I can choose or not choose the question to get the max points
    if (question.prepTime <= maxTimeToPrepare) {
      return Math.max(
          //  choosing
          (question.noOfTests * question.points) +
              _01KnapSack(questionList, questionPos - 1, maxTimeToPrepare - question.prepTime),
          //  not choosing
          _01KnapSack(questionList, questionPos - 1, maxTimeToPrepare));
    }
    //  not choosing the question
    return _01KnapSack(questionList, questionPos - 1, maxTimeToPrepare);
  }

  public static void main(String[] args) {
    System.out.println("max points: " + maxPointsAchieved()); //  max points: 11
  }
}
