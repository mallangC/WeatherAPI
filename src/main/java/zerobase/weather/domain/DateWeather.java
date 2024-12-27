package zerobase.weather.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Schema(description = "날씨 데이터")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class DateWeather {
  @Id
  private LocalDate date;
  private String weather;
  private String icon;
  private Double temperature;
}
