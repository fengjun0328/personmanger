package cn.bdqn.controller;

import cn.bdqn.pojo.Person;
import cn.bdqn.service.DeptService;
import cn.bdqn.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/person")
public class PersonController {
    @Resource
    private PersonService personService;

    @Resource
    private DeptService deptService;

    /**
     * 加载首页的方法
     * .html的后缀是伪静态命名
     * @return
     */
 /*   @RequestMapping("/main.html")
    public String main(Model model){
        //获取所有的信息
        List<Person> persons=personService.findPersons();
        model.addAttribute("persons",persons);
        return "main";
    }*/

    @RequestMapping("/main.html")
    public String main(Model model,
                       @RequestParam(value = "currNo",defaultValue = "1") Integer currNo,
                       Long total,Person person){
        String name=person.getName();
        System.out.println("==========>"+name);

        int pageSize=2;//每页显示的条数
        //获取所有的信息
        List<Person> persons=personService.findPersonsByPageAndContion(person,currNo,pageSize);
        //总t条数
        Long count=personService.findCount(person);
        //总页数
        total=(count%pageSize==0?count/pageSize:(count/pageSize+1));
        System.out.println("persons的长度："+persons.size());

        model.addAttribute("persons",persons);
        model.addAttribute("currNo",currNo);
        model.addAttribute("total",total);
        model.addAttribute("size",persons.size());
        model.addAttribute("name",name);//查询条件回显
        return "main";
    }

    /**
     * 跳转添加页面的方法
     * @param model
     * @return
     */
    @RequestMapping("/add.html")
    public String add(Model model){
        model.addAttribute("depts",deptService.findDepts());
        return "add";
    }

    @RequestMapping(value = "/add.html" ,method = RequestMethod.POST)
    public String addSava(Person person){
        int result=personService.addPerson(person);
        if(result>0){
            return "redirect:/person/main.html";
        }
        return "add";
    }

}
