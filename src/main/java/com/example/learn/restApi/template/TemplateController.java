package com.example.learn.restApi.template;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @GetMapping(value = "/test")
    public String test() throws ParseException, IOException {
        String tempString = "你好，$name。再见，$time。";

        RuntimeServices rs = RuntimeSingleton.getRuntimeServices();
        StringReader reader = new StringReader(tempString);
        Template t = new Template();
        t.setRuntimeServices(rs);
        t.setData(rs.parse(reader,t));
        t.initDocument();

        VelocityContext ctx = new VelocityContext();
        ctx.put("name","tom");
        ctx.put("time",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        StringWriter result = new StringWriter();
        t.merge(ctx,result);
        return result.toString();
    }
}
