package com.edu.entity;

import java.util.Date;
import java.util.List;

public class InfoContent {
    private Integer conId;

    private String conNo;

    private String plateNo;

    private String conTitle;

    private String subTitle;

    private String author;

    private String publisher;

    private String editor;

    private Byte statu;

    private Date pubTime;

    private Date modifyTime;

    private Byte istop;

    private String conHtml;

    private String conPath;

    private Integer visitCount;

    private String comment;
    
    private List<InfoSlave> slaves;

    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConNo() {
        return conNo;
    }

    public void setConNo(String conNo) {
        this.conNo = conNo == null ? null : conNo.trim();
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo == null ? null : plateNo.trim();
    }

    public String getConTitle() {
        return conTitle;
    }

    public void setConTitle(String conTitle) {
        this.conTitle = conTitle == null ? null : conTitle.trim();
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    public Byte getStatu() {
        return statu;
    }

    public void setStatu(Byte statu) {
        this.statu = statu;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Byte getIstop() {
        return istop;
    }

    public void setIstop(Byte istop) {
        this.istop = istop;
    }

    public String getConHtml() {
        return conHtml;
    }

    public void setConHtml(String conHtml) {
        this.conHtml = conHtml == null ? null : conHtml.trim();
    }

    public String getConPath() {
        return conPath;
    }

    public void setConPath(String conPath) {
        this.conPath = conPath == null ? null : conPath.trim();
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

	public List<InfoSlave> getSlaves() {
		return slaves;
	}

	public void setSlaves(List<InfoSlave> slaves) {
		this.slaves = slaves;
	}

	@Override
	public String toString() {
		return "InfoContent [conId=" + conId + ", conNo=" + conNo + ", plateNo=" + plateNo + ", conTitle=" + conTitle
				+ ", subTitle=" + subTitle + ", author=" + author + ", publisher=" + publisher + ", editor=" + editor
				+ ", statu=" + statu + ", pubTime=" + pubTime + ", modifyTime=" + modifyTime + ", istop=" + istop
				+ ", conHtml=" + conHtml + ", conPath=" + conPath + ", visitCount=" + visitCount + ", comment="
				+ comment + ", slaves=" + slaves + "]";
	}
    
}