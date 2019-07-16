package com.yuanpeng.congfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 此类用来读取properties中不变常亮
 * java静态变量和静态方法会在程序初始化运行时候就加载到内存。
 * 优点：不需要在进行实例化。静态变量的值，直接赋新值即可，不需要参数传递，之后可以直接进行参数引用即可；
 *       静态方法可以直接通过"类名.方法"的形式进行方法调用。通常方法被多次调用，并且方法中没有动态方法引用的时候使用比较方便。
 * 缺点：初始化加载到内存，如果后续没被引用，加大了内存负担和程序运行负担，影响程序运行效率（一般很小），
 *       并且静态变量如果多处被引用赋值，很可能导致参数值混（如果是不变的值，最后加上final修饰，强制不能修改）。
 * final:编译期常数，永远不会改变,在运行期初始化一个值，不希望它发生改变。定义时必须提供一个值。
 */
@PropertySource(value = {"classpath:constant.properties"})//这个注解仅仅支持properties
@Component  //加入到spring容器,想让这个生效必须加入spring容器
@ConfigurationProperties(prefix = "constant")
public class ReadProperties {
    private Map<String,String> language;

    public Map<String, String> getLanguage() {
        return language;
    }

    public void setLanguage(Map<String, String> language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "language="+language;
    }

    public Map<String,String> getLanguageForBeetl(String profile) throws IOException {
        Properties props = new Properties();
        Map<String,String> map = new HashMap<>();
        InputStream in = null;
        try {
            //因为InputStream 不能读取中文，所以采取reader把inputStream转换成reader用字符流来读取中文。
            //getResourceAsStream 不能用绝对路径  路径前面加/从根目录读取 不加从此类的包下面找
            in = ReadProperties.class.getClass().getResourceAsStream("/static/messages/"+profile);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            props.load(bf);
            Enumeration en = props.propertyNames();
            //在这里遍历
            while (en.hasMoreElements()) {
                String key = en.nextElement().toString();//key值
                String Property = new String(props.getProperty(key));//value值
                map.put(key,Property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null != in)
                in.close();
        }
        System.out.println(toString());

        return map;
    }
}
