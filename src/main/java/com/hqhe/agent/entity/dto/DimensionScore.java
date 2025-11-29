package com.hqhe.agent.entity.dto;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

@Data
public class DimensionScore {

    @Description("该维度的得分，0-100")
    private int score;

    @Description("一句话点评")
    private String comment;
}
