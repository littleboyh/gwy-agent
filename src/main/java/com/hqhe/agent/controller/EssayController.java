package com.hqhe.agent.controller;

import com.hqhe.agent.ai.EssayAiAssistant;
import com.hqhe.agent.common.web.vo.Result;
import com.hqhe.agent.entity.dto.EssayReviewDTO;
import com.hqhe.agent.entity.dto.EssayPolishDTO;
import com.hqhe.agent.entity.vo.EssayPolishVO;
import com.hqhe.agent.entity.vo.EssayReviewVO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/agent/essay")
public class EssayController {
    @Autowired
    private EssayAiAssistant essayAiAssistant;

    /**
     * AI 评审
     */
    @PostMapping("/review")
    public Result<EssayReviewVO> review(@Valid @RequestBody EssayReviewDTO dto) {
        return Result.success(essayAiAssistant.reviewEssay(dto.getQuestion(), dto.getEssay()));
    }

    /**
     * 一键润色
     */
    @PostMapping("/polish")
    public Result<EssayPolishVO> polish(@Valid @RequestBody EssayPolishDTO dto) {
        return Result.success(essayAiAssistant.polishEssay(dto.getQuestion(), dto.getEssay()));

    }
}
