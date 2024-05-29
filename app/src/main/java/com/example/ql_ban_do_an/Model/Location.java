package com.example.ql_ban_do_an.Model;

public class Location {


    public Location(int id, String loc) {
        Id = id;
        Loc = loc;
    }

    private int Id;
    private String Loc;
    public Location() {
    }

    public int getId() {
        return Id;
    }

    @Override
    public String toString() {
        return  Loc;
    }

    public void setID(int Id) {
        this.Id = Id;
    }

    public String getLoc() {
        return Loc;
    }

    public void setLoc(String loc) {
        Loc = loc;
    }
}
