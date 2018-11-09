package com.pj.weixin.util;

import com.pj.weixin.bean.BaseMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jack
 * @create 2018-11-08 17:30
 */
public class MessageUtil {
    /**
     * 将xml转化为Map
     * @param request
     * @return
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request){
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            Document doc = reader.read(inputStream);
            Element root = doc.getRootElement();
            List<Element> elements = root.elements();
            for (Element element:elements) {
                map.put(element.getName(),element.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
        return map;
    }

    /**
     * 将BaseMessage类型转化为对应的xml
     * @param message
     * @return
     */
    public static String ObjectToXml(BaseMessage message){
        XStream xStream = new XStream();
        xStream.alias("xml",message.getClass());
        return xStream.toXML(message);
    }
}
