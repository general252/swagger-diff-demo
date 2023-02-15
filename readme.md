

#### 新建工程

![](.\src\res\project.jpg)
![](.\src\res\maven.jpg)


#### 工程
pom.xml
```
<!-- https://mvnrepository.com/artifact/org.slf4j/slf4j-simple -->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>1.7.30</version>
    <scope>compile</scope>
</dependency>


<!-- https://mvnrepository.com/artifact/com.deepoove/swagger-diff -->
<dependency>
    <groupId>com.deepoove</groupId>
    <artifactId>swagger-diff</artifactId>
    <version>1.2.2</version>
</dependency>
```


App.java
```
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

```


#### 导出
![](.\src\res\export1.jpg)
![](.\src\res\export2.jpg)
![](.\src\res\export3.jpg)

#### 使用

```
cd out/artifacts/swagger_diff_demo_jar
java -jar aswagger-diff-demo.jar
```

