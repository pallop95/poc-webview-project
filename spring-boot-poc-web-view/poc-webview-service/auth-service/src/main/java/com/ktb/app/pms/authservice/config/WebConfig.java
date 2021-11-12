package com.ktb.app.pms.authservice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
//@ComponentScan({"com.ktb.app.pms.authservice", "com.ktb.app.pms.commonlibrary.security", "com.ktb.app.pms.commonlibrary.config.swagger"})
@ComponentScan({
	"com.ktb.app.pms.commonlibrary.config.jdbc",
	"com.ktb.app.pms.commonlibrary.security",
	"com.ktb.app.pms.commonlibrary.config.swagger"
})
public class WebConfig implements WebMvcConfigurer {

//    @Value("${app.database.schema:}")
//    private String schema;
//
//    @Bean
//    @Scope("singleton")
//    public DBConst setDbSchema() throws Exception {
//        DBConst dbConst = new DBConst();
//        if (schema != null && !"".equals(schema) && schema.length() > 0) {
//            Field[] fields = dbConst.getClass().getDeclaredFields();
//            for (int i = 0; i < fields.length; i++) {
//                Field field = fields[i];
//                if (field.getType() == String.class && schema.length() > 0) {
//                    field.set(dbConst, new StringBuilder().append(schema).append(".").append(field.get(dbConst)).toString());
//                }
//            }
//        }
//        return dbConst;
//    }

}
