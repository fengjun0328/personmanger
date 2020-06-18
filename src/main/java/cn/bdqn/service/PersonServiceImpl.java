package cn.bdqn.service;

import cn.bdqn.dao.PersonMapper;
import cn.bdqn.pojo.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("personService")
public class PersonServiceImpl implements  PersonService {
    @Resource(name = "personMapper")
    private PersonMapper personMapper;
    @Override
    public List<Person> findPersons() {
        return personMapper.findPersons();
    }

    @Override
    public int addPerson(Person person) {
        try{
            return personMapper.addPerson(person);
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Person> findPersonsByPageAndContion(Person person, Integer currNO, Integer pageSize) {
        return personMapper.findPersonsByPageAndContion(person,(currNO-1)*pageSize,pageSize);
    }
    @Override
    public Long findCount(Person person) {
        return personMapper.findCount(person);
    }
}
