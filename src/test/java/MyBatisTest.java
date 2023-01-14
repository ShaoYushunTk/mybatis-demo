import mapper.BrandMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import pojo.Brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MyBatisTest {

    /**
     * 查询所有
     * @throws IOException
     */
    @Test
    public void testSelectAll() throws IOException {
        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放
        sqlSession.close();
    }

    /**
     * 根据id查询
     * @throws IOException
     */
    @Test
    public void testSelectById() throws IOException {
        //网页获取id
        int id=1;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放
        sqlSession.close();
    }

    /**
     * 根据条件查询
     * @throws IOException
     */
    @Test
    public void testSelectByCondition() throws IOException {
        //网页获取参数
        int status = 1;
        String companyName = "huawei";
        String brandName = "huawei";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName +"%";

        //封装对象
        /*Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);*/

        Map map = new HashMap<>();
        //map.put("status",status);
        map.put("brandName",brandName);
        //map.put("companyName",companyName);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        //List<Brand> brands = brandMapper.selectByCondition(status, brandName, companyName);
        //List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5.释放
        sqlSession.close();
    }


    /**
     * 单条件动态查询(从status,companyName,brandName选一个条件查询)
     * @throws IOException
     */
    @Test
    public void testSelectByConditionSingle() throws IOException {
        //网页获取参数
        int status = 1;
        String companyName = "huawei";
        String brandName = "huawei";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName +"%";

        //封装对象
        /*Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setStatus(status);*/

        Map map = new HashMap<>();
        //map.put("status",status);
        //map.put("brandName",brandName);
        //map.put("companyName",companyName);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        List<Brand> brands = brandMapper.selectByConditionSingle(map);
        System.out.println(brands);

        //5.释放
        sqlSession.close();
    }

    /**
     * 插入数据
     * @throws IOException
     */
    @Test
    public void testInsert() throws IOException {
        //参数
        int status = 1;
        String companyName = "google company";
        String brandName = "google";
        String description = "766";
        int ordered = 10;

        //封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //true自动提交事务，false需要手动提交 sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        brandMapper.add(brand);

        //提交事务 增删改需要提交事务
        //sqlSession.commit();

        //5.释放
        sqlSession.close();
    }

    /**
     * 插入数据 并返回id
     * @throws IOException
     */
    @Test
    public void testInsert2() throws IOException {
        //参数
        int status = 1;
        String companyName = "google company";
        String brandName = "google";
        String description = "766";
        int ordered = 10;

        //封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //true自动提交事务，false需要手动提交 sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        brandMapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);

        //提交事务 增删改需要提交事务
        //sqlSession.commit();

        //5.释放
        sqlSession.close();
    }

    /**
     * update 修改
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        //参数
        int status = 1;
        String companyName = "google company";
        String brandName = "google111";
        String description = "888";
        int ordered = 10;
        int id = 8;

        //封装对象
        Brand brand = new Brand();
        brand.setBrandName(brandName);
        brand.setStatus(status);
        brand.setCompanyName(companyName);
/*        brand.setDescription(description);
        brand.setOrdered(ordered);*/
        brand.setId(id);

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //true自动提交事务，false需要手动提交 sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        brandMapper.update(brand);

        //提交事务 增删改需要提交事务
        //sqlSession.commit();

        //5.释放
        sqlSession.close();
    }

    /**
     * delete by id
     * @throws IOException
     */
    @Test
    public void testDeleteById() throws IOException {
        //参数
        int id = 7;

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //true自动提交事务，false需要手动提交 sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        brandMapper.deleteById(id);

        //提交事务 增删改需要提交事务
        //sqlSession.commit();

        //5.释放
        sqlSession.close();
    }

    /**
     * delete by ids
     * @throws IOException
     */
    @Test
    public void testDeleteByIds() throws IOException {
        //参数
        int[] ids = {6,8};

        //1.获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlSession
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //true自动提交事务，false需要手动提交 sqlSession.commit();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取mapper代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行sql
        brandMapper.deleteByIds(ids);

        //提交事务 增删改需要提交事务
        //sqlSession.commit();

        //5.释放
        sqlSession.close();
    }
}
