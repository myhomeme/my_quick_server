package com.huangzb.paas.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author huangzb
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan("com.huangzb.paas")
public class MyQuickServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyQuickServerApplication.class, args);
        System.out.println(
                        "########                             ###### #\n" +
                        " ##     #                           #     ###\n" +
                        " ##     #    ######      ######     #       #\n" +
                        " ##     #         ##          ##     ####    \n" +
                        " #######     #######     #######         ####\n" +
                        " ##         #     ##    #     ##    #       #\n" +
                        " ##         #     ##    #     ##    ###     #\n" +
                        "#####        ###### #    ###### #   # ###### ");
    }

}
