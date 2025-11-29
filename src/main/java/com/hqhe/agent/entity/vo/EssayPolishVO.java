package com.hqhe.agent.entity.vo;

import dev.langchain4j.model.output.structured.Description;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class EssayPolishVO {
    @Description("润色后的完整文章内容，保持原意不变但表达更规范、严谨、流畅")
    private String polishedEssay;

    @Description("对本次润色的总体说明，1-3 句话，概括整体风格变化和提升方向")
    private String overallPolishComment;

    @Description("""
            本次润色的主要思路，使用 Map 结构，键为润色维度标题，值为该维度下的若干具体说明。
            若干说明不大于5条，如果超过5条，请将最重要的5条修改列出。
            示例：
            {
              "提升政治站位和理论深度": [
                "将“数字化探索”提升为“城市数字化转型”等更具战略高度的表述。",
                "强调“人民群众获得感、幸福感、安全感”，与政府工作目标对齐。"
              ],
              "语言规范与精炼": [
                "使用“蓬勃发展”“积极部署”等规范政务用语，避免口语化表达。",
                "将长句拆分、合并同类表述，使语言更加紧凑有力。"
              ]
            }
            """)
    private Map<String, List<String>> polishAspects;
}
