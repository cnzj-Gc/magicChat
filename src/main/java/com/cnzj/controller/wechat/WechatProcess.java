package com.cnzj.controller.wechat;

public class WechatProcess {

    public WechatProcess() {
    }

    public String processWechatMag(ReceiveXmlEntity xmlEntity) {
        String result = (new TulingApiProcess()).getTulingResult(xmlEntity.getContent());
        result = (new FormatXmlProcess()).formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), result);
        return result;
    }
}
