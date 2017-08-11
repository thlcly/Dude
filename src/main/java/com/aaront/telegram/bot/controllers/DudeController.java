package com.aaront.telegram.bot.controllers;

import com.aaront.telegram.bot.request.UserMessageVO;
import com.aaront.telegram.bot.response.MessageReplyVO;
import com.aaront.telegram.bot.services.ExpressQueryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author tonyhui
 * @since 2017/8/10
 */
@Controller
public class DudeController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExpressQueryService expressQueryService;

    @RequestMapping(value = "/telegram", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public MessageReplyVO telegram(HttpServletRequest request) throws IOException {
        UserMessageVO userMessageVO = _encapsulateJsonRequestToObj(request, UserMessageVO.class);
        String expressTracks = expressQueryService.getExpressTracks(userMessageVO.getMessage().getText());
        MessageReplyVO messageReplyVO = new MessageReplyVO();
        messageReplyVO.setChatId(userMessageVO.getMessage().getChat().getId().toString());
        messageReplyVO.setMethod("sendMessage");
        messageReplyVO.setText(expressTracks);
        return messageReplyVO;
    }

    private <T> T _encapsulateJsonRequestToObj(HttpServletRequest request, Class<T> type) throws IOException {
        String json = _readJsonFromRequest(request);
        return _encapsulateJsonToObj(json, type);
    }

    private <T> T _encapsulateJsonToObj(String json, Class<T> type) throws IOException {
        return objectMapper.readValue(json, type);
    }

    private String _readJsonFromRequest(HttpServletRequest request) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = request.getReader()) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }

}
