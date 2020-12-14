package com.yuxiong.tech.logincomponent;

import com.yuxiong.tech.logincomponent.dao.UserMapper;
import com.yuxiong.tech.logincomponent.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws Exception{
        // 1、读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        // 2、创建 SqlSessionFactory 工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);       // 接口无法创建实例，需要工厂构建器

        // 3、使用工厂产生 SqlSession 对象
        SqlSession session = factory.openSession();

        // 4、使用 SqlSession 创建 Dao 接口代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);

        // 5、使用代理对象执行方法
        List<User> users = userMapper.findAll();
        System.out.println(Arrays.toString(users.toArray()));

        // 6、释放资源
        session.close();
        in.close();
    }
}
