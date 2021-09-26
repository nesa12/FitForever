package com.example.fitforever.Model;

public class Schedule {

    int id;
    String workout_id;
    String workout_name;
    String reps;
    String sets;
    String date;
    String type;

    public Schedule(int id, String workout_id,String workout_name, String reps, String sets, String date, String type) {
        this.id = id;
        this.workout_id = workout_id;
        this.workout_name = workout_name;
        this.reps = reps;
        this.sets = sets;
        this.date = date;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkout_name() {
        return workout_name;
    }

    public void setWorkout_name(String workout_name) {
        this.workout_name = workout_name;
    }

    public Schedule() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkout_id() {
        return workout_id;
    }

    public void setWorkout_id(String workout_id) {
        this.workout_id = workout_id;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
