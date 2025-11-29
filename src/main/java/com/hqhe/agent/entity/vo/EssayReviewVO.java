package com.hqhe.agent.entity.vo;

import com.hqhe.agent.entity.dto.DimensionScore;
import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class EssayReviewVO {
    @Description("本次申论作文的总分，0-100")
    private int totalScore;

    @Description("整体文字点评，2-4 句话，用于综合得分卡片展示")
    private String overallComment;

    @Description("""
            四个维度的打分与点评，键为维度编码：
            IDEA(观点主旨)、LOGIC(逻辑思维)、LANGUAGE(语言表达)、STRUCTURE(结构层次)
            值为包含 score(0-100) + comment(一句话点评) 的结构
            """)
    private Map<String, DimensionScore> dimensionScores;

    @Description("整体改进建议列表，适配前端“改进建议”模块")
    private List<String> improvementSuggestions;

    @Description("""
            深度点评中的优点部分，使用 Map 结构，键为优点标题，值为具体描述。
            示例：
            {
              \"观点主旨明确\": \"开篇能够明确指出……\",
              \"语言规范得体\": \"全文表达流畅，无口语化……\"
            }
            """)
    private Map<String, String> advantages;

    @Description("""
            深度点评中的不足部分，使用 Map 结构，键为问题标题，值为具体描述。
            示例：
            {
              \"结构层次不完整\": \"文章停留在……缺乏对策……\",
              \"论证深度不足\": \"未能深入剖析原因……\"
            }
            """)
    private Map<String, String> disadvantages;
}
