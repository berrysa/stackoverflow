package com.samlikescode.stackoverflow.questions.q31264303;

import com.google.common.base.Objects;

//@JsonDeserialize(using = AnimalDeserializer.class)
public class Animal {
    private int id;
    private String food;
    private String comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("food", food)
                .add("comment", comment)
                .toString();
    }
}
