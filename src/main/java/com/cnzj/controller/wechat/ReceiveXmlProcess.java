package com.cnzj.controller.wechat;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

public class ReceiveXmlProcess {

    public ReceiveXmlProcess() {
    }

    public ReceiveXmlEntity getMsgEntity(String strXml) {
        ReceiveXmlEntity msg = null;

        try {
            if (strXml.length() <= 0 || strXml == null) {
                return null;
            }

            Document document = DocumentHelper.parseText(strXml);
            Element root = document.getRootElement();
            Iterator<?> iter = root.elementIterator();
            new ReceiveXmlEntity();
            Class<?> c = Class.forName("com.cnzj.controller.wechat.ReceiveXmlEntity");
            msg = (ReceiveXmlEntity)c.newInstance();

            while(iter.hasNext()) {
                Element ele = (Element)iter.next();
                Field field = c.getDeclaredField(ele.getName());
                Method method = c.getDeclaredMethod("set" + ele.getName(), field.getType());
                method.invoke(msg, ele.getText());
            }
        } catch (Exception var10) {
            System.out.println("xml 格式异常: " + strXml);
            var10.printStackTrace();
        }

        return msg;
    }
}
