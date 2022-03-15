package com.company;

public class CSGO {
    private String name;
    private String team;
    private int price;
    private int rof;
    private int damage;

    public CSGO(String name, String team, int price, int rof, int damage) {
        this.name = name;
        this.team = team;
        this.price = price;
        this.rof = rof;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getPrice() {
        return price;
    }

    public int getRof() {
        return rof;
    }

    public int getDamage() {
        return damage;
    }
}
