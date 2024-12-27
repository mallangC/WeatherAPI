package zerobase.weather.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Schema(description = "날씨, 날짜, 일기 데이터")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Diary {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String weather;
  private String icon;
  private double temperature;
  private String text;
  private LocalDate date;

  public void setDateWeather(DateWeather dateWeather) {
    this.date = dateWeather.getDate();
    this.weather = dateWeather.getWeather();
    this.icon = dateWeather.getIcon();
    this.temperature = dateWeather.getTemperature();
  }
}
