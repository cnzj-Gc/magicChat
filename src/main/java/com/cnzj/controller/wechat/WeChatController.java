package com.cnzj.controller.wechat;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@RestController
@RequestMapping(value = "/wechat")
public class WeChatController {

    @RequestMapping(value = "/check.do", method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String checkOut(HttpServletRequest request, HttpServletResponse response,String echostr) throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String result = "";
        StringBuffer sb = new StringBuffer();
        InputStream is = request.getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String s = "";

        while((s = br.readLine()) != null) {
            sb.append(s);
        }

        String xml = sb.toString();

        if (echostr != null && echostr.length() > 0) {
            result = echostr;
        } else {
            ReceiveXmlEntity xmlEntity = (new ReceiveXmlProcess()).getMsgEntity(xml);
            if (xmlEntity != null) {
                if ("text".endsWith(xmlEntity.getMsgType())) {
                    result = (new WechatProcess()).processWechatMag(xmlEntity);
                } else if ("image".endsWith(xmlEntity.getMsgType())) {
                    result = (new FormatXmlProcess()).formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), "我们还是打字吧。。");
                } else {
                    result = (new FormatXmlProcess()).formatXmlAnswer(xmlEntity.getFromUserName(), xmlEntity.getToUserName(), "我们还是打字吧。。");
                }
            }
        }

        return result;
    }
}
