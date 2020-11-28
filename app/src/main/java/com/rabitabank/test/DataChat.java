package com.rabitabank.test;


public class DataChat {

//    private boolean mine;
    private String content;
//    private Integer from;

    private String url;






    public DataChat(String text,  String url) {
        this.content = text;
        this.url = url;
   //     this.mine = mine;
   //     this.from = from;

    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}




