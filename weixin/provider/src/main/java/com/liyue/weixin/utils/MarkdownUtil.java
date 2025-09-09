package com.liyue.weixin.utils;

import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

public class MarkdownUtil {

    /**
     * 将 Markdown 文本转换为 HTML（适合微信小程序 rich-text 使用的基础 HTML）
     * @param markdown Markdown 原文
     * @return 转换后的 HTML 字符串
     */
    public static String markdownToHtml(String markdown) {
        if (markdown == null || markdown.trim().isEmpty()) {
            return "";
        }

        // 创建解析器和渲染器
        Parser parser = Parser.builder().build();
        HtmlRenderer renderer = HtmlRenderer.builder().build();

        // 解析并渲染为 HTML
        return renderer.render(parser.parse(markdown));
    }
}
