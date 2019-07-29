package com.yuanpeng;

import com.yuanpeng.BuilderJava.DateUtils;
import com.yuanpeng.congfig.ReadProperties;
import com.yuanpeng.domain.SysUser;
import com.yuanpeng.service.SysUserService;
import jdk.nashorn.internal.ir.annotations.Reference;
import net.bytebuddy.asm.Advice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerManageApplicationTests {
    //记录器
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    DataSource dataSource;
    @Autowired
    ReadProperties readProperties;
    @Autowired
    SysUserService sysUserService;
    @Test
    public void contextLoads() {
    }

    /**
     * 数据库jdbc测试
     * @throws SQLException
     */
    @Test
    public void test2() throws SQLException {
        System.out.println(dataSource.getClass());//1.0版本默认tomcat连接池，2.0使用Hikari连接池（号称java平台最快的，替换druid）
        Connection connection =dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    /**
     *  * 日志使用:SpringBoot底层也是使用slf4j+logback的方式进行日志记录
     * @throws SQLException
     */
    @Test
    public void test3()  {
        //上边有个记录器
        //System.out.println();

        //日志的级别；
        //由低到高   trace<debug<info<warn<error
        //可以调整输出的日志级别；日志就只会在这个级别以以后的高级别生效
        logger.trace("这是trace日志...");
        logger.debug("这是debug日志...");
        //SpringBoot默认给我们使用的是info级别的，没有指定级别的就用SpringBoot默认规定的级别；root级别
        logger.info("这是info日志...");
        logger.warn("这是warn日志...");//警告
        logger.error("这是error日志...");//错误

    }
    /**
     *  * 读取文件路径,只能用来读取resource文件夹下的
     */
    @Test
    public void test4() {
        Thread.currentThread().getContextClassLoader();
        URL l3 = Thread.currentThread().getContextClassLoader().getResource("static/messages/messages_zh_CN.properties");
        String l4=l3.getPath();//加上getPath()则去掉前面的file:
        System.out.println(l3);  //file:/F:/demo/Studying/out/production/Studying/test3.xml
        System.out.println(l4);///F:/demo/Studying/out/production/Studying/test3.xml

    }
    /**
     *  根据路径读取properties文件
     */
    @Test
    public void test5() throws IOException{

        /*这是获取绝对路径D;/xxxxxx
        Thread.currentThread().getContextClassLoader();
        URL url = Thread.currentThread().getContextClassLoader().getResource("static/messages/messages_zh_CN.properties");
        String urlStr=url.getPath();*/
        Properties props = new Properties();
        Map<String,String> map = new HashMap<>();
        InputStream  in = null;
        try {
            //因为InputStream 不能读取中文，所以采取reader把inputStream转换成reader用字符流来读取中文。
            //getResourceAsStream 不能用绝对路径  路径前面加/从根目录读取 不加从此类的包下面找
            in = CustomerManageApplicationTests.class.getClass().getResourceAsStream("/static/messages/messages_zh_CN.properties");
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            props.load(bf);
            Enumeration en = props.propertyNames();
            //在这里遍历
            while (en.hasMoreElements()) {
                String key = en.nextElement().toString();//key值
                String Property = new String(props.getProperty(key));//value值
                System.out.println(key+"====="+Property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != in)
                in.close();
        }
    }
    /**
     *  测试读取配置文件用ConfigurationProperties
     */
    @Test
    public void test6() {

        System.out.println( readProperties.toString());
    }
    @Test
    public void test7() {
        SysUser sysUser = sysUserService.contrastMobile("166785292224");
        logger.info(sysUser.getUsername());
        logger.debug("阿薩德");
    }
    @Test
    public void test8() {
        Date weekStart = DateUtils.getWeekEnd(new Date());
        String reqDate = DateUtils.getReqDate(weekStart);
        String timeStampStr = DateUtils.getTimeStampStr(weekStart);
        Timestamp timestamp = DateUtils.nowTimeStamp();
        long time = weekStart.getTime();
        System.out.println(reqDate+":------------:"+weekStart+":------:"+timeStampStr +":------:"+timestamp+":------:"+time);

    }
}
