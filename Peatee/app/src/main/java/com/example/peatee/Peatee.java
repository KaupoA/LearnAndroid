package com.example.peatee;

import android.os.Parcel;
import android.os.Parcelable;

public class Peatee implements Parcelable {

    private int peateeDrawableImage;
    private String peateeName;
    private int peateeAge;
    private String peateeCarOne;
    private String peateeCarTwo;

    Peatee(int peateeDrawableImage, String peateeName, int peateeAge, String peateeCarOne, String peateeCarTwo) {

        this.peateeDrawableImage = peateeDrawableImage;
        this.peateeName = peateeName;
        this.peateeAge = peateeAge;
        this.peateeCarOne = peateeCarOne;
        this.peateeCarTwo = peateeCarTwo;

    }


    private Peatee(Parcel in) {
        peateeDrawableImage = in.readInt();
        peateeName = in.readString();
        peateeAge = in.readInt();
        peateeCarOne = in.readString();
        peateeCarTwo = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(peateeDrawableImage);
        dest.writeString(peateeName);
        dest.writeInt(peateeAge);
        dest.writeString(peateeCarOne);
        dest.writeString(peateeCarTwo);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Peatee> CREATOR = new Creator<Peatee>() {
        @Override
        public Peatee createFromParcel(Parcel in) {
            return new Peatee(in);
        }

        @Override
        public Peatee[] newArray(int size) {
            return new Peatee[size];
        }
    };

    int getPeateeDrawableImage() {
        return peateeDrawableImage;
    }

    String getPeateeName() {
        return peateeName;
    }

    int getPeateeAge() {
        return peateeAge;
    }

    String getPeateeCarOne() {
        return peateeCarOne;
    }

    String getPeateeCarTwo() {
        return peateeCarTwo;
    }
}
