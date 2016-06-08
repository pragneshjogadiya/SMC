package com.example.saurabh.smc.ListModels;

/**
 * Created by Saurabh on 5/27/2016.
 */
public class ActionModel {

    private String title;
    private String due_date;
    private String type;
    private String owner;
    private boolean status;

    public ActionModel(String title,String date, String type, String owner, boolean status) {
        this.title = title;
        this.due_date = date;
        this.type=type;
        this.owner = owner;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getdate() {
        return due_date;
    }
    public void setdate(String date) {
        this.due_date = date;
    }

    public String gettype() {
        return type;
    }
    public void settype(String title) {
        this.type = title;
    }

    public String getowner() {
        return owner;
    }
    public void setowner(String title) {
        this.owner = title;
    }

    public boolean getstatus() {
        return status;
    }
    public void setsatatus(boolean status) {
        this.status = status;
    }
}
