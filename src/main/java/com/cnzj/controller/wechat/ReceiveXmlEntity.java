package com.cnzj.controller.wechat;

public class ReceiveXmlEntity {

    private String ToUserName = "";
    private String FromUserName = "";
    private String CreateTime = "";
    private String MsgType = "";
    private String MsgId = "";
    private String Event = "";
    private String EventKey = "";
    private String Ticket = "";
    private String Latitude = "";
    private String Longitude = "";
    private String Precision = "";
    private String PicUrl = "";
    private String MediaId = "";
    private String Title = "";
    private String Description = "";
    private String Url = "";
    private String Location_X = "";
    private String Location_Y = "";
    private String Scale = "";
    private String Label = "";
    private String Content = "";
    private String Format = "";
    private String Recognition = "";

    public ReceiveXmlEntity() {
    }

    public String getRecognition() {
        return this.Recognition;
    }

    public void setRecognition(String recognition) {
        this.Recognition = recognition;
    }

    public String getFormat() {
        return this.Format;
    }

    public void setFormat(String format) {
        this.Format = format;
    }

    public String getContent() {
        return this.Content;
    }

    public void setContent(String content) {
        this.Content = content;
    }

    public String getLocation_X() {
        return this.Location_X;
    }

    public void setLocation_X(String locationX) {
        this.Location_X = locationX;
    }

    public String getLocation_Y() {
        return this.Location_Y;
    }

    public void setLocation_Y(String locationY) {
        this.Location_Y = locationY;
    }

    public String getScale() {
        return this.Scale;
    }

    public void setScale(String scale) {
        this.Scale = scale;
    }

    public String getLabel() {
        return this.Label;
    }

    public void setLabel(String label) {
        this.Label = label;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getUrl() {
        return this.Url;
    }

    public void setUrl(String url) {
        this.Url = url;
    }

    public String getPicUrl() {
        return this.PicUrl;
    }

    public void setPicUrl(String picUrl) {
        this.PicUrl = picUrl;
    }

    public String getMediaId() {
        return this.MediaId;
    }

    public void setMediaId(String mediaId) {
        this.MediaId = mediaId;
    }

    public String getEventKey() {
        return this.EventKey;
    }

    public void setEventKey(String eventKey) {
        this.EventKey = eventKey;
    }

    public String getTicket() {
        return this.Ticket;
    }

    public void setTicket(String ticket) {
        this.Ticket = ticket;
    }

    public String getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(String latitude) {
        this.Latitude = latitude;
    }

    public String getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }

    public String getPrecision() {
        return this.Precision;
    }

    public void setPrecision(String precision) {
        this.Precision = precision;
    }

    public String getEvent() {
        return this.Event;
    }

    public void setEvent(String event) {
        this.Event = event;
    }

    public String getMsgId() {
        return this.MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

    public String getToUserName() {
        return this.ToUserName;
    }

    public void setToUserName(String toUserName) {
        this.ToUserName = toUserName;
    }

    public String getFromUserName() {
        return this.FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return this.CreateTime;
    }

    public void setCreateTime(String createTime) {
        this.CreateTime = createTime;
    }

    public String getMsgType() {
        return this.MsgType;
    }

    public void setMsgType(String msgType) {
        this.MsgType = msgType;
    }
}
