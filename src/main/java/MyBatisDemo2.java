import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MyBatis代理开发
 */
public class MyBatisDemo2 {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql 传入名称空间.id
        //List<User> Users = sqlSession.selectList("test.selectAll");

        //System.out.println(Users);

        //3.1获取UserMapper接口代理对象 输入完getMapper后Alt+Enter直接返回对应对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);


        //4.释放资源
        sqlSession.close();

    }
}
