package com.example.androidfunctionality.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private String title;
    private String subTitle;

    public Item(String title, String subTitle) {
        this.title = title;
        this.subTitle = subTitle;
    }

    protected Item(Parcel in) {
        title = in.readString();
        subTitle = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getSubTitle() {
        return subTitle;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subTitle);
    }
}
