package com.example.saurabh.smc.ListModels;

/**
 * Created by user on 6/8/2016.
 */
public class comment_item {
    private String name_of_commentator;
    private String time_of_comment;
    private String comment_text;

    public comment_item(String name_of_commentator, String time_of_comment, String comment_text) {
        this.name_of_commentator = name_of_commentator;
        this.time_of_comment = time_of_comment;
        this.comment_text = comment_text;
    }

    public String getName_of_commentator() {
        return name_of_commentator;
    }
    public String getTime_of_comment() {
        return time_of_comment;
    }
    public String getComment_text() { return comment_text;}

    public void setName_of_commentator(String name_of_commentator) {
        this.name_of_commentator = name_of_commentator;
    }
    public void setTime_of_comment(String time_of_comment) {
        this.time_of_comment = time_of_comment;
    }
    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

}
