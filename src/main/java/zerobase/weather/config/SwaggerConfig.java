package zerobase.weather.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI api() {
    return new OpenAPI()
            .components(new Components())
            .info(this.apiInfo());
  }


  private Info apiInfo(){
    String description = "날씨 일기를 CRUD 할 수 있는 백엔드 API입니다!";
    return new Info()
            .title("날씨 일기 프로젝트 :)")
            .description(description)
            .version("1.0");
  }
}
