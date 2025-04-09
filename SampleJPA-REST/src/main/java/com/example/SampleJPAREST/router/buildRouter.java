package com.example.SampleJPAREST.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.builder.RouteBuilder;

public class buildRouter extends RouteBuilder {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void configure() throws Exception {

        from("direct:executeSqlQuery")
                .log("body- ${body}")
                .toD("sql:${body}")
                .log("Query result- ${body}")
                .process(process -> {
                    Object response = process.getIn().getBody();

                    log.info("response "+ response);
                    process.getIn().setBody(mapper.writeValueAsString(response));
                    log.info("Data parsed.");
                })
                .end();
    }
}
