package org.cheng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
// 扫描 mybaits mapper 包路径
@MapperScan(basePackages = "org.cheng.mapper")
// 扫描所有需要的包，包括一些自用的工具类包 所在的路径
@ComponentScan(basePackages = {"org.cheng","org.n3r.idworker"})
public class ChengApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChengApplication.class, args);
	}
}
