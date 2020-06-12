package cn.bdqn.service;

import cn.bdqn.dao.DeptMapper;
import cn.bdqn.pojo.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
    @Resource
    private DeptMapper DeptMapper;
    @Override
    public List<Dept> findDepts() {
        return DeptMapper.findDepts();
    }
}
