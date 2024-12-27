package zerobase.weather.repository;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zerobase.weather.domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class JpaMemoRepositoryTest {

  @Autowired
  JpaMemoRepository jpaMemoRepository;

  @Test
  void insertMemoTestJpa() {
    //given
    Memo memo = new Memo(1, "test");
    //when
    jpaMemoRepository.save(memo);
    //then
    List<Memo> memoList = jpaMemoRepository.findAll();
    assertEquals(1, memoList.size());
  }

  @Test
  void findMemoById() {
    //given
    Memo memo = new Memo(1, "test");
    //then
    jpaMemoRepository.save(memo);

    Optional<Memo> result = jpaMemoRepository.findById(1);
    assertEquals(result.get().getText(), "test");
  }

}