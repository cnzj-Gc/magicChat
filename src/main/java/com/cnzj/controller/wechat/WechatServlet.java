package com.cnzj.controller.wechat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class WechatServlet extends HttpServlet {

    public WechatServlet() {
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String echostr = request.getParameter("echostr");
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

        PrintWriter out = response.getWriter();
        out.print(result);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
