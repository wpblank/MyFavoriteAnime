package cn.lzumi.myfavoriteanime.bean;

public class Anime {
    private Integer id;
    private String name;
    private String comment;
    private String bilibili;
    private String bt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getBilibili() {
        return bilibili;
    }

    public void setBilibili(String bilibili) {
        this.bilibili = bilibili;
    }

    public String getBt() {
        return bt;
    }

    public void setBt(String bt) {
        this.bt = bt;
    }
}
