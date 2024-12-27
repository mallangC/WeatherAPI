package zerobase.weather.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional //데이터베이스 테스트를 할때 많이 사용됨
class JdbcMemoRepositoryTest {
  @Autowired
  JdbcMemoRepository jdbcMemoRepository;

  @Test
  void insertMomoTest() {
    //given
    Memo memo = new Memo(1, "this is new memo~");
    //when
    jdbcMemoRepository.save(memo);
    //then
    Optional<Memo> result = jdbcMemoRepository.findById(1);
    assertEquals("this is new memo~", result.get().getText());
  }

  @Test
  void findAllMemosTest() {
    //given
    Memo memo = new Memo(1, "this is new memo~");
    jdbcMemoRepository.save(memo);
    memo = new Memo(2, "this is new memo~2");
    jdbcMemoRepository.save(memo);
    //when

    List<Memo> memos = jdbcMemoRepository.findAll();
    for (Memo m : memos) {
      System.out.println(m.getId() +" : "+ m.getText());
    }
    //then
    assertNotNull(memos);
  }

}