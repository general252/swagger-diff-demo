package org.demo;

import com.deepoove.swagger.diff.SwaggerDiff;
import com.deepoove.swagger.diff.output.HtmlRender;
import com.deepoove.swagger.diff.output.MarkdownRender;

import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");

        String a = "a.json";
        String b = "b.json";

        SwaggerDiff diff = SwaggerDiff.compareV2(a, b);
        String renderHtml = new HtmlRender("Changelog",
                "http://deepoove.com/swagger-diff/stylesheets/demo.css")
                .render(diff);

        FileWriter fw1 = new FileWriter("diffAPI.html");
        fw1.write(renderHtml);
        fw1.close();

        String renderMarkdown = new MarkdownRender().render(diff);
        FileWriter fw2 = new FileWriter("diffAPI.md");
        fw2.write(renderMarkdown);
        fw2.close();
    }
}
