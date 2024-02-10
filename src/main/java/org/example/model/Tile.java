package org.example.model;

public class Tile {
    private int x;
    private int y;
    private String tileNum;

    public Tile(int x, int y, String tileNum) {
        this.x = x;
        this.y = y;
        this.tileNum = tileNum;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getTileNum() {
        return tileNum;
    }

    public void setTileNum(String tileNum) {
        this.tileNum = tileNum;
    }
}
