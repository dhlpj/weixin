package com.pj.weixin;

import com.pj.weixin.util.MenuUtil;
import com.pj.weixin.util.TokenUtil;
import com.pj.weixin.util.TraslateUtil;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeixinApplicationTests {
    @Autowired
    private TokenUtil tokenUtil;
    @Autowired
    private MenuUtil menuUtil;
    @Autowired
    private TraslateUtil traslateUtil;
    @Test
    public void contextLoads() {
        //生成自定义菜单
        String accessToken = tokenUtil.getAccessToken();
        String menu = menuUtil.initMenu();
        JSONObject result = menuUtil.createMenu(accessToken, menu);
        if(result.getInt("errcode")!=0){
            System.out.println("创建自定义菜单失败！");
        }else{
            System.out.println("创建自定义菜单成功！");
        }
    }
    @Test
    public void testTranslate(){
        String query = "英语";
        String from = "auto";
        String to = "en";
        String transResult = traslateUtil.getTransResult(query, from, to);
        System.out.println(transResult);
    }

}
