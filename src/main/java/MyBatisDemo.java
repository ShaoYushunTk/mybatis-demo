import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * MyBatis入门
 */
public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.执行sql 传入名称空间.id
        List<User> Users = sqlSession.selectList("test.selectAll");

        System.out.println(Users);

        //4.释放资源
        sqlSession.close();

    }
}
