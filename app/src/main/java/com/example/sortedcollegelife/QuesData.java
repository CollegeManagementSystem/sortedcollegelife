package com.example.sortedcollegelife;

public class QuesData {
    private String ques;
    private String number;

    public QuesData(String ques, String number) {
        this.ques = ques;
        this.number = number;
    }
    public String getQues(){return ques;}

    public void setques(String ques){this.ques=ques;}

    public String getnumber(){return number;}

    public void setNumber(String number){this.number=number;}
}
