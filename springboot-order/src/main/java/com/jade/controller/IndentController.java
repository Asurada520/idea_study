package com.jade.controller;


import com.jade.annotation.ExtAPIToken;
import com.jade.annotation.ExtApiIdempotent;
import com.jade.common.ConstantUtils;
import com.jade.entity.IndentInfoEntity;
import com.jade.service.IndentInfoService;
import com.jade.utils.RedisToken;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private IndentInfoService indentInfoService;


    @RequestMapping("token")
    public Object getRedisToken() {
        String token = redisToken.getToken();
        return token;
    }

    /**
     * @param indentInfoEntity
     * @param request
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Object addIndent(@RequestBody IndentInfoEntity indentInfoEntity, HttpServletRequest request) {

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            return "参数错误";
        }

        boolean tokenFlag = redisToken.findToken(token);
        if (!tokenFlag) {
            return "请勿重复提交";
        }

        int result = indentInfoService.insert(indentInfoEntity);
        return result > 0 ? "操作成功" : "操作失败";
    }

    /**
     *
     * @param indentInfoEntity
     * @return 操作详情
     */
    @RequestMapping(value = "add2", method = RequestMethod.POST)
    @ExtApiIdempotent(type = ConstantUtils.EXTAPIHEAD)
    public Object addIndentDemo2(@RequestBody IndentInfoEntity indentInfoEntity) {
        int result = indentInfoService.insert(indentInfoEntity);
        return result > 0 ? "操作成功" : "操作失败";
    }

}
