package com.jade.controller;


import com.jade.annotation.ExtAPIToken;
import com.jade.annotation.ExtApiIdempotent;
import com.jade.common.ConstantUtils;
import com.jade.entity.IndentInfoEntity;
import com.jade.service.IndentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/indentUpdate/")
public class IndentUpdateController {

    @Autowired
    private IndentInfoService indentInfoService;

    @RequestMapping("go")
    @ExtAPIToken
    public String goIndentPage(HttpServletRequest request) {
        return "indent";
    }


    @RequestMapping("addUpdate")
    @ExtApiIdempotent(type = ConstantUtils.EXTAPIFROM)
    @ResponseBody
    public Object IndentAdd(IndentInfoEntity indentInfoEntity) {
        int count = indentInfoService.insert(indentInfoEntity);
        return count > 0 ? "success" : "failure";
    }


}
