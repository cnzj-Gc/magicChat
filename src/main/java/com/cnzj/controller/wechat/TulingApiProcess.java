package com.cnzj.controller.wechat;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class TulingApiProcess {

    public TulingApiProcess() {
    }

    public String getTulingResult(String content) {
        String apiUrl = "http://www.tuling123.com/openapi/api?key=1a9271751bea41789e276937e019eff1&info=";
        String param = "";

        try {
            param = apiUrl + URLEncoder.encode(content, "utf-8");
        } catch (UnsupportedEncodingException var10) {
            var10.printStackTrace();
        }

        HttpGet request = new HttpGet(param);
        String result = "";

        try {
            HttpResponse response = HttpClients.createDefault().execute(request);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity());
            }
        } catch (ClientProtocolException var8) {
            var8.printStackTrace();
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        if (result == null) {
            return "对不起，你说的话真是太高深了……";
        } else {
            try {
                JSONObject json = new JSONObject(result);
                if (100000 == json.getInt("code")) {
                    result = json.getString("text");
                }
            } catch (JSONException var7) {
                var7.printStackTrace();
            }

            return result;
        }
    }
}
