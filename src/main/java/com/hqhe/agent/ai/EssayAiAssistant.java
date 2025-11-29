package com.hqhe.agent.ai;


import com.hqhe.agent.entity.vo.EssayPolishVO;
import com.hqhe.agent.entity.vo.EssayReviewVO;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface EssayAiAssistant {
    @SystemMessage("""
            你是一名资深的上海市申论阅卷老师。
            请严格按照 EssayReviewVO 类的字段含义，
            只生成可被 JSON 解析的结构化内容，由框架自动映射到对象上。
            不要输出多余解释。
            """)
    @UserMessage("""
            下面是题目与作答要求：
            {{question}}
            
            下面是考生的申论作文：
            {{essay}}
            """)
    EssayReviewVO reviewEssay(@V("question") String question, @V("essay") String essay);


    @SystemMessage("""
            你是一名资深的上海市申论写作指导老师，负责在不改变立意的前提下润色文章。
            请严格按照 EssayPolishVO 类的字段含义，只生成可被 JSON 解析的结构化内容。
            输出时不要包含多余解释或 Markdown。
            """)
    @UserMessage("""
            下面是题目与作答要求：
            {{question}}

            下面是需要润色的申论作文：
            {{essay}}
            """)
    EssayPolishVO polishEssay(@V("question") String question, @V("essay") String essay);




}
