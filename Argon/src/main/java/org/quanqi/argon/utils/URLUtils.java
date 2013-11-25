package org.quanqi.argon.utils;

import java.lang.String;import java.lang.StringBuilder;import java.net.URLEncoder;
import java.util.Map;

/**
 * By jingquanqi on 10/14/13.
 */
public class URLUtils  {

    /**
     * Encode url
     * @param base
     * @param params
     * @return
     */
    public static String constructURL(String base, Map<String, String> params) {
        StringBuilder url = new StringBuilder(base);
        if(params != null && params.size() > 0) {
            url.append("?");
            for(Map.Entry<String, String> entry : params.entrySet()) {
                url.append(entry.getKey());
                url.append("=");
                url.append(URLEncoder.encode(entry.getValue()));
                url.append("&");   //not for the last one (but should be OK)
            }
        }
        return url.substring(0, url.length()-1);
        //return url.toString();
    }
}
