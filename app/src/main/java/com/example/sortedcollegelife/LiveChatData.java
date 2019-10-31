package com.example.sortedcollegelife;


public class LiveChatData {
    private int sedRec;
    private String data;

    public LiveChatData(int sedRec, String data, String time) {
        this.sedRec = sedRec;
        this.data = data;
    }

    public LiveChatData() {
    }

    public int getSedRec() {
        return sedRec;
    }

    public void setSedRec(int sedRec) {
        this.sedRec = sedRec;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "LiveChatData{" +
                "sedRec=" + sedRec +
                ", data='" + data + '\'' +
                '}';
    }
}


