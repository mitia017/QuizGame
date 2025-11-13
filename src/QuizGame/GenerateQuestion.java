package QuizGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GenerateQuestion {
    private static HashMap<String, String> data = GenerateData.getData();
    Random random = new Random();


    public class Question{
        private String question;
        private String response;
        public Question(String question, String response){
            this.question = question;
            this.response = response;
        }
        public String getQuestion(){
            return question;
        }
        public String getAnswers(){
            return response;
        }
    }

    private ArrayList<String> countries = new ArrayList<>(data.keySet());
    private ArrayList<Question> questions = new ArrayList();




    public ArrayList<Question> Generate(int questionNumber){
        for(int i=0;i<questionNumber;i++){
            int countryIndex = random.nextInt(countries.size());
            String country = countries.get(countryIndex);
            countries.remove(countryIndex);
            String capital = data.get(country);

            String questionText = String.format("What is the capital of %s?",country);

            questions.add(new Question( questionText,capital) );
        }
        countries = new ArrayList<>(data.keySet());;
        return questions;
    }



}