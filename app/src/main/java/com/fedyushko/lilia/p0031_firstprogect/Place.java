package com.fedyushko.lilia.p0031_firstprogect;
import android.content.Intent;
import android.graphics.PointF;


public class Place extends PointF{

    String name;
    String info;
    String longInfo;
    int photoId;
    int addId;



    Place(String name, String info, int photoId, float x, float y) {
        super(x, y);
        this.name = name;
        this.info = info;
        this.photoId = photoId;
        addId=R.drawable.ic_add;

    }

    public String getLongInfo() {
        return longInfo;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getName() {
        return name;
    }

    public float getX() {
        return (float) x;
    }

    public float getY() {
        return (float) y;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }


    public void setLongInfo(String longInfo) {
        this.longInfo = longInfo;
    }

    public double distance(Place pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        return Math.sqrt(px * px + py * py);
    }

}
