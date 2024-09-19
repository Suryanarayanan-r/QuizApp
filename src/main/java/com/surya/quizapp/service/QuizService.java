package com.surya.quizapp.service;

import com.surya.quizapp.dao.QuestionDao;
import com.surya.quizapp.dao.QuizDao;
import com.surya.quizapp.model.Question;
import com.surya.quizapp.model.QuestionWrapper;
import com.surya.quizapp.model.Quiz;
import com.surya.quizapp.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizdao;
    @Autowired
    QuestionDao questiondao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

        List<Question> questions=questiondao.findRandomQuestionsByCategory(category,numQ);
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizdao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
      Optional<Quiz> quiz= quizdao.findById(id);
      List<Question> questionsFromDb=quiz.get().getQuestions();
      List<QuestionWrapper> questionsForUser=new ArrayList<>();
      for(Question q:questionsFromDb){
          QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
          questionsForUser.add(qw);
      }
      return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz=quizdao.findById(id).get();
        List<Question> questions=quiz.getQuestions();
        int right=0;
        int i=0;
        for(Response response:responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;

            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
