package org.acme.hibernate.orm.panache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
    public class Joke extends PanacheEntity {

    // The ID field is already provided by PanacheEntity, no need to define it again
    @Column(nullable = false)
    public String question;

    @Column(nullable = false)
    public String answer;

    public Joke(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // Default constructor
    public Joke() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
