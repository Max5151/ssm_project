package com.ssm.controller.qualityControl;

import com.ssm.bean.ResponseMessage;
import com.ssm.bean.ResponseVO;
import com.ssm.bean.qualityControl.ProcessCountCheck;
import com.ssm.service.qualityControl.ProcessCountCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("p_count_check")
public class ProcessCountCheckController{

    @Autowired
    ProcessCountCheckService service;

    @RequestMapping("find")
    public String find(){
        return "p_count_check_list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseVO<ProcessCountCheck> list(Integer page, Integer rows){
        int offset = (page -1) * rows;
        int allCount = service.findAllCount();
        List<ProcessCountCheck> list = service.findByPage(rows, offset);
        ResponseVO<ProcessCountCheck> vo = new ResponseVO<>();
        vo.setTotal(allCount);
        vo.setRows(list);
        return vo;
    }

    @RequestMapping("update_note")
    @ResponseBody
    public ResponseMessage update_note(String pCountCheckId, String note) {
        int i = service.updateNote(pCountCheckId, note);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("/search_pCountCheck_by_{which}")
    @ResponseBody
    public ResponseVO likequery(@PathVariable("which")String which, String searchValue, Integer page, Integer rows){
        searchValue = "%"+searchValue+"%";
        String target =  which.replaceAll("[A-Z]", "_$0").toLowerCase();
        int offset = (page - 1) * rows;
        List list = service.searchList(target, searchValue, offset, rows);
        int allCount = service.searchAllCount(target, searchValue);
        ResponseVO<Object> vo = new ResponseVO<>();
        vo.setRows(list);
        vo.setTotal(allCount);
        return vo;
    }

    @RequestMapping("edit")
    public String edit(){
        return "p_count_check_edit";
    }

    @RequestMapping("add")
    public String add(){
        return "p_count_check_add";
    }


    @RequestMapping("insert")
    @ResponseBody
    public ResponseMessage insert(ProcessCountCheck un){
        int i = service.insert(un);
        return ResponseMessage.getMessage(i);
    }

    @RequestMapping("update_all")
    @ResponseBody
    public ResponseMessage update_all(ProcessCountCheck un){
        int i = service.updateAll(un);
        return ResponseMessage.getMessage(i);
    }
}
