package shan.splan.model;

import java.io.Serializable;

/**
 * Created by chrisweng on 2016/12/3.
 */

public class Question implements Serializable {

    private String question;
    private boolean answer;
    private boolean complete;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
