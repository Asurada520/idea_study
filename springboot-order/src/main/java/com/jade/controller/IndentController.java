package com.jade.controller;


import com.jade.entity.IndentInfoEntity;
import com.jade.utils.RedisToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/indent/")
public class IndentController {


    @Autowired
    private RedisToken redisToken;


    @RequestMapping("token")
    public Object getRedisToken(){
        String token = redisToken.getToken();
        return token;
    }


    /**
     * -- 订货单信息
     * CREATE TABLE indent_info(
     * 	id VARCHAR(64) COMMENT '表主键',
     * 	indent_code VARCHAR(64) COMMENT '订货单编号',
     * 	indent_desc VARCHAR(64) COMMENT '订货单描述',
     * 	PRIMARY KEY(id)
     * )ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='订货单信息';
     */

    /**
     *
     * @param indentInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public Object addIndent(@RequestBody IndentInfoEntity indentInfoEntity, HttpServletRequest request) {



        return null;
    }

}
