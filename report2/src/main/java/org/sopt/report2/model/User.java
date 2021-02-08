package org.sopt.report2.model;

public class User {
    private int user_idx;
    private String name;
    private String part;

    public User(){}

    public int getUser_idx(){
        return user_idx;
    }
    public void setUser_idx(final int idx){
        this.user_idx=idx;
    }

    public String getName(){
        return name;
    }
    public void setName(final String name){
        this.name = name;
    }

    public String getPart(){
        return part;
    }
    public void setPart(final String part){
        this.part=part;
    }

    @Override
    public String toString(){
        return "User{"+"\n"+
                "user_idx= "+user_idx+"\n"+
                ", name= "+name+"\n"+
                ", part= "+part+"\n"+
                "}";
    }
}
