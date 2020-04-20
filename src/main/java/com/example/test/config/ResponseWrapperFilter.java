package com.example.test.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 利用HttpServletResponseWrapper对reponse进行包装<br/> Spring Boot启动类必须要加@ServletComponentScan才生效
 *
 * @author huangyf
 * @email huangyifei@qingzu.com.cn
 * @date 2019年4月26日 下午1:59:27
 */
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@WebFilter(urlPatterns = {"/*"}, filterName = "responseWrapperFilter")
public class ResponseWrapperFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseWrapperFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        ResponseWrapper wrapper = new ResponseWrapper(response);
        try {
            filterChain.doFilter(request, wrapper);

            String responseStr = new String(wrapper.toByteArray(), response.getCharacterEncoding());
            try {
                Object parse = JSON.parse(responseStr);
                if (parse instanceof JSONObject) {
                    JSONObject resultObject = (JSONObject) parse;
                    if (resultObject.containsKey("code") && resultObject.containsKey("msg") && resultObject
                        .containsKey("data")) {
                        LOGGER.info("response is -> {}",
                            responseStr.length() > 1024 ? responseStr.substring(0, 1024) + "..."
                                : responseStr);

                        // 必须设置ContentLength
                        response.setContentLength(responseStr.getBytes().length);
                        response.setContentType("application/json;charset=utf-8");
                        response.getOutputStream().write(responseStr.getBytes());
                        response.getOutputStream().close();
                        return;
                    }
                }
            } catch (Exception e) {
            }
            if (StringUtils.isNotEmpty(responseStr)) {
                // 必须设置ContentLength
                response.setContentLength(wrapper.toByteArray().length);
                // ContentType不设置，使用上游的
                response.getOutputStream().write(wrapper.toByteArray());
            }
        } catch (Exception e) {
            LOGGER.error("数据包装器执行出错....{}", e);
        }
    }
}
