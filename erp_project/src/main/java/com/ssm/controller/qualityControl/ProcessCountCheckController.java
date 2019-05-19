package com.ssm.controller.qualityControl;

import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.ProcessCountCheck;
import com.ssm.service.qualityControl.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_count_check")
public class ProcessCountCheckController{

    @Autowired
    ProcessCountCheckService processCountCheckService;

    @RequestMapping("find")
    public String find(){
        return "p_count_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<ProcessCountCheck> list(Integer page, Integer rows){
        int offset = (page -1) * rows;
        int allCount = processCountCheckService.findAllCount();
        List<ProcessCountCheck> list = processCountCheckService.findByPage(rows, offset);
        ResponseVO<ProcessCountCheck> vo = new ResponseVO<ProcessCountCheck>();
        vo.setTotal(allCount);
        vo.setRows(list);
        return vo;
    }
}
