package com.example.fitforever;

public class Mealplanmodal {
    private int id;
    private String name,description,menus_1,menus_3;
    private long started,finished;

    public Mealplanmodal(){

    }

    public Mealplanmodal(int id,String name,String description,String menus_1,String menus_3,long started,long finished) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.menus_1 = menus_1;
        this.menus_3 = menus_3;
        this.started = started;
        this.finished = finished;
    }

    public Mealplanmodal(String name,String description,String menus_1,String menus_3,long started,long finished) {

        this.name = name;
        this.description = description;
        this.menus_1 = menus_1;
        this.menus_3 = menus_3;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMenus_1() {
        return menus_1;
    }

    public void setMenus_1(String menus_1) {
        this.menus_1 = menus_1;
    }

    /*public String getMenus_2() {
        return menus_2;
    }

    public void setMenus_2(String menus_2) {
        this.menus_2 = menus_2;
    }*/

    public String getMenus_3() {
        return menus_3;
    }

    public void setMenus_3(String menus_3) {
        this.menus_3 = menus_3;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;


    }
}



