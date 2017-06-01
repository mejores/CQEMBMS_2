package com.edu.entity;

public class InfoSlide {
    private Integer slideId;

    private String imgPath;

    private String conNo;

    private String imgCon;

    private String comment;

    public Integer getSlideId() {
        return slideId;
    }

    public void setSlideId(Integer slideId) {
        this.slideId = slideId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getConNo() {
        return conNo;
    }

    public void setConNo(String conNo) {
        this.conNo = conNo == null ? null : conNo.trim();
    }

    public String getImgCon() {
        return imgCon;
    }

    public void setImgCon(String imgCon) {
        this.imgCon = imgCon == null ? null : imgCon.trim();
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}