package cn.bdqn.service;

import cn.bdqn.pojo.Person;
import java.util.List;

public interface PersonService {
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
     * @param currNo
     * @param pageSize
     * @return
     */
    List<Person> findPersonsByPageAndContion(Person person, Integer currNo, Integer pageSize);

    /**
     * 获取总条数
     * @param person
     * @return
     */
    Long findCount(Person person);
}
