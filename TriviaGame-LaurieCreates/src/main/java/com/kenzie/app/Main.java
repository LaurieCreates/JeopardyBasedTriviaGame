package com.kenzie.app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private final static String GET_URL_API_1 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_2 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_3 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_4 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_5 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_6 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_7 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_8 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_9 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String GET_URL_API_10 = "https://jservice.kenzie.academy/api/clues/" + Main.formatRandomClueURL();
    private final static String nextCategoryUserText = "\n" + "Your next randomly selected Category is:" + "\n\n";
    public final static String nextClueUserText = "\n" + "Let's take a look at your next clue:" + "\n\n";
    private final static String displayAnswerTextFormatting = "\n" + "The correct response is:" + "\n\n";
    public static int userScore = 0;

    private static ClueDTO getClueOne() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_1);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueTwo() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_2);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueThree() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_3);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueFour() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_4);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueFive() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_5);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueSix() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_6);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueSeven() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_7);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueEight() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_8);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueNine() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_9);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static ClueDTO getClueTen() throws IOException {
        String jsonString = CustomHttpClient.sendGET(GET_URL_API_10);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, ClueDTO.class);
    }

    private static int formatRandomClueURL() {
        Random rand = new Random();
        int minRange = 1, maxRange = 355237;
        return rand.nextInt(maxRange - minRange) + minRange;
    }

    private static String printAnswerDirections() {
        return "\n" + "DIRECTIONS TO PLAY:" + "\n" +
                "1. Please enter your answer to the clue below." + "\n" +
                "2. Be sure to include proper punctuation AND capitalization of all phrases AND/OR proper nouns." + "\n" +
                "3. Answers entered without correct criteria will be marked incorrect." + "\n";
    }

    private static String getUserText() {
        System.out.println(printAnswerDirections());
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args) throws RuntimeException {

        try {

            System.out.println("Welcome to Jeopardy!" + "\n" + "\n" + "Your first randomly selected Category is:" +
                    "\n\n" + getClueOne().getCategory().getTitle() + "\n" + "Let's take a look at your first clue: " +
                    "\n\n" + getClueOne().getQuestion());
            String userAnswerOne = Main.getUserText().replaceAll("\\s", "");
            //https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
            System.out.println(displayAnswerTextFormatting + (getClueOne().getAnswer()));
            if (Objects.equals(userAnswerOne, getClueOne().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
                        " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points." +
                        "\n\n" + "Your current score is : " + userScore +
                        " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueTwo().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueTwo().getQuestion());
            String userAnswerTwo = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueTwo().getAnswer()));
            if (Objects.equals(userAnswerTwo, getClueTwo().getAnswer().toLowerCase()
                    .replaceAll("\\s", "").replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
                        " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."  + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueThree().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueThree().getQuestion());
            String userAnswerThree = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueThree().getAnswer()));
            if (Objects.equals(userAnswerThree, getClueThree().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueFour().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueFour().getQuestion());
            String userAnswerFour = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueFour().getAnswer()));
            if (Objects.equals(userAnswerFour, getClueFour().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueFive().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueFive().getQuestion());
            String userAnswerFive = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueFive().getAnswer()));
            if (Objects.equals(userAnswerFive, getClueFive().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueSix().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueSix().getQuestion());
            String userAnswerSix = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueSix().getAnswer()));
            if (Objects.equals(userAnswerSix, getClueSix().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueSeven().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueSeven().getQuestion());
            String userAnswerSeven = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueSeven().getAnswer()));
            if (Objects.equals(userAnswerSeven, getClueSeven().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueEight().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueEight().getQuestion());
            String userAnswerEight = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueEight().getAnswer()));
            if (Objects.equals(userAnswerEight, getClueEight().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueNine().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueNine().getQuestion());
            String userAnswerNine = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueNine().getAnswer()));
            if (Objects.equals(userAnswerNine, getClueNine().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!" + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points."
                        + "\n\n" + "Your current score is : " + userScore +
            " points out of 10.");
            }

            System.out.println(nextCategoryUserText + getClueTen().getCategory().getTitle() + "\n" + nextClueUserText +
                    getClueTen().getQuestion());
            String userAnswerTen = Main.getUserText().replaceAll("\\s", "");
            System.out.println(displayAnswerTextFormatting + (getClueTen().getAnswer()));
            if (Objects.equals(userAnswerTen, getClueTen().getAnswer().toLowerCase()
                    .replaceAll("\\s", ""))) {
                userScore += 1;
                System.out.println("\n" + "Correct!");
            } else {
                System.out.println("\n" + "Sorry, that answer is incorrect, but you will not lose points. ");
            }

            System.out.println("\n" + "Your final score is " + userScore + " out of 10 possible points." + "\n");
            if (userScore==10) {
                System.out.println("CONGRATULATIONS...you are an official JEOPARDY WHIZ and YOU WON!");
            }
            if (userScore>=5) {
                System.out.println("Not bad, you scored more than the average bear!" );
            }
            if (userScore>=1 && userScore<5) {
                System.out.println("\n" + "Your score was less than average!" + "\n" +  "*NOTE* Some answers may have " +
                        "been correct, but did not match our answer database :(" );
            }
            if (userScore==0) {
                System.out.println("Oh no, you scored zero! Try taking a break and playing again! :)" + "\n" +
                        "*NOTE* Some answers may have been correct, but did not match our answer database :(" );
            }

        } catch (RuntimeException | IOException e) {
            e.getMessage();
        }
    }
}
