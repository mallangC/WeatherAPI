package zerobase.weather.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.weather.domain.Diary;
import zerobase.weather.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "다이어리 API")
@RestController
public class DiaryController {

  private final DiaryService diaryService;

  public DiaryController(DiaryService diaryService) {
    this.diaryService = diaryService;
  }

  @Operation(summary = "다이어리 생성", 
          description = "날짜(LocalDate)와 일기내용(Text)를 DB에 저장한다")
  @PostMapping("/create/diary")
  void createDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                   @Parameter(description = "생성할 날짜",example = "2022-02-01")
                   LocalDate date,
                   @RequestBody
                   @Parameter(description = "일기 내용")
                   String text) {
    diaryService.createDiary(date, text);

  }

  @Operation(summary = "다이어리 확인", 
          description = "해당 날짜(LocalDate)의 다이어리를 불러온다")
  @GetMapping("/read/diary")
  List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                        @Parameter(description = "조회할 날짜",example = "2022-02-01")
                        LocalDate date) {
    return diaryService.readDiary(date);
  }

  @Operation(summary = "다이어리 모두 확인", 
          description = "해당 날짜(LocalDate)의 모든 다이어리를 불러온다")
  @GetMapping("/read/diaries")
  List<Diary> readDiaries(@RequestParam
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                          @Parameter(description = "조회할 기간의 첫번째 날",example = "2022-02-01")
                          LocalDate startDate,
                          @RequestParam
                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                          @Parameter(description = "조회할 기간의 마지막 날",example = "2022-02-30")
                          LocalDate endDate)
  {
    return diaryService.readDiaries(startDate,endDate);

  }

  @Operation(summary = "다이어리 수정", 
          description = "해당 날짜(LocalDate)의 다이어리를 수정한다")
  @PutMapping("/update/diary")
  void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                   @Parameter(description = "수정할 날짜",example = "2022-02-01")
                   LocalDate date,
                   @RequestBody
                   @Parameter(description = "새로운 일기 내용")
                   String text)
  {
    diaryService.updateDiary(date, text);
  }

  @Operation(summary = "다이어리 삭제", 
          description = "해당 날짜(LocalDate)의 다이어리를 삭제한다")
  @DeleteMapping("/delete/diary")
  void deleteDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                   @Parameter(description = "삭제할 날짜",example = "2022-02-01")
                   LocalDate date)
  {
    diaryService.deleteDiary(date);
  }

}
