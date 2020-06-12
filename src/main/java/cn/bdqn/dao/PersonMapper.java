package cn.bdqn.dao;

import cn.bdqn.pojo.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PersonMapper {

    /**
     * 查询所有的信息
     * @return
     */
    List<Person> findPersons();

    /**
     * 添加的方法
     * @param person
     * @return
     */
    int addPerson(Person person);

    /**
     * 分页显示数据
     * @param person
     * @param start
     * @param pageSize
     * @return
     */
    List<Person> findPersonsByPageAndContion(@Param("person")Person person,
                                             @Param("start")Integer start,
                                             @Param("pageSize")Integer pageSize);

    /**
     * 获取总条数
     * @param person
     * @return
     */
    Long findCount(@Param("person")Person person);
}
