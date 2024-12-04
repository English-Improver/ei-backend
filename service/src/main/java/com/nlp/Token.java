package com.nlp;


/**
 * @author yitiansong
 */
public class Token {
    private String name;
    private String word;
    private String pos;
    private String color;
    public Token(String word, String pos) {
        this.word = word;
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Token{" +
                "name='" + name + '\'' +
                ", word='" + word + '\'' +
                ", pos='" + pos + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

