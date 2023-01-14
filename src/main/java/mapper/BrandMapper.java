package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.Brand;
import pojo.User;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

    /**
     * 条件查询：注意传入参数的使用
     * 1.@Param 散装参数    @Param("sql参数占位符名称")
     * 2.Brand  对象参数    d对象属性名称要和sql参数占位符名称一致
     * 3.Map    Map集合参数
     *
     * @param status
     * @param brandName
     * @param companyName
     * @return
     */
    //List<Brand> selectByCondition(@Param("status")int status, @Param("brandName")String brandName, @Param("companyName")String companyName);

    //List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);

    /**
     * 单条件查询
     * @param map
     * @return
     */
    List<Brand> selectByConditionSingle(Map map);

    void add(Brand brand);

    void update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids")int[] ids);

}
