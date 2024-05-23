package com.example.signup_login_realtime;

import android.os.Parcel;
import android.os.Parcelable;

public class Event implements Parcelable {
    private String name;
    private String sessions;
    private String speakers;
    private String time;
    private String place;

    private String id;

    public Event() {
        // Default constructor required for Firebase Realtime Database
    }

    public Event(String name, String sessions, String speakers, String time, String place) {
        this.name = name;
        this.sessions = sessions;
        this.speakers = speakers;
        this.time = time;
        this.place = place;
    }

    protected Event(Parcel in) {
        name = in.readString();
        sessions = in.readString();
        speakers = in.readString();
        time = in.readString();
        place = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getSessions() {
        return sessions;
    }

    public String getSpeakers() {
        return speakers;
    }

    public String getTime() {
        return time;
    }

    public String getPlace() {
        return place;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(sessions);
        dest.writeString(speakers);
        dest.writeString(time);
        dest.writeString(place);
    }
}