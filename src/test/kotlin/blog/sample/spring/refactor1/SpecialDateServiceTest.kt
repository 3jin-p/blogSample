package blog.sample.spring.refactor1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.time.LocalDate

@ExtendWith(MockitoExtension::class)
internal class SpecialDateServiceTest(
    @Mock
    val specialDateRepository: SpecialDateRepository
) {

    lateinit var specialDateService: SpecialDateService

    @BeforeEach
    fun setUp() {
        val specialDays = listOf(SpecialDate("1", "2022현충일", LocalDate.of(2022, 6, 6)),
            SpecialDate("2", "2022창립기념일", LocalDate.of(2022, 6,7)))

        Mockito.`when`(specialDateRepository.findAll()).thenReturn(specialDays)

        // 실제론 컨테이거나 뜨는 과정에서 초기화 될 것이지만, 테스트에서는 강제로 수행
        val specialDateChecker = SpecialDateChecker(specialDateRepository)
//        specialDateService = SpecialDateService(specialDateRepository)
    }

    @Test
    @DisplayName("입력한 날짜가 특별한 날 일 경우 특별한 날이 아닌 날까지 민다")
    fun push2() {
        val date = LocalDate.of(2022, 6, 6)
        assertThat(NormalDayGenerator.push(date).isEqual(LocalDate.of(2022, 6, 8))).isTrue
    }

    @Test
    @DisplayName("입력한 날짜가 특별한 날 일 경우 특별한 날이 아닌 날까지 당긴다")
    fun pull2() {
        val date = LocalDate.of(2022, 6, 7)
        assertThat(NormalDayGenerator.pull(date).isEqual(LocalDate.of(2022, 6, 5))).isTrue
    }


    @Test
    @DisplayName("입력한 날짜가 특별한 날인지 아닌지 여부를 반환")
    fun isSpecialDay() {
        assertAll(
            { assertFalse(specialDateService.isSpecialDay(LocalDate.of(2022, 6, 5))) },
            { assertTrue(specialDateService.isSpecialDay(LocalDate.of(2022, 6, 6))) }
        )
    }
//
//
//    @Test
//    @DisplayName("입력한 날짜가 특별한 날 일 경우 특별한 날이 아닌 날까지 민다")
//    fun push() {
//        val date = LocalDate.of(2022, 6, 6)
//        assertThat(specialDateService.push(date).isEqual(LocalDate.of(2022, 6, 8))).isTrue
//    }
//
//    @Test
//    @DisplayName("입력한 날짜가 특별한 날 일 경우 특별한 날이 아닌 날까지 당긴다")
//    fun pull() {
//        val date = LocalDate.of(2022, 6, 7)
//        assertThat(specialDateService.pull(date).isEqual(LocalDate.of(2022, 6, 5))).isTrue
//    }
//
//
//
//    @Test
//    @DisplayName("입력한 날짜가 특별한 날인지 아닌지 여부를 반환")
//    fun isSpecialDayBySpecialDateChecker() {
//        // 실제론 컨테이거나 뜨는 과정에서 초기화 될 것이지만, 테스트에서는 강제로 수행
//        val specialDateChecker = SpecialDateChecker(specialDateRepository)
//
//        assertAll(
//            { assertFalse(SpecialDateChecker.isSpecialDay(LocalDate.of(2022, 6, 5))) },
//            { assertTrue(SpecialDateChecker.isSpecialDay(LocalDate.of(2022, 6, 6))) }
//        )
//    }
//
//    @Test
//    @DisplayName("입력한 날짜가 특별한 날 일 경우 특별한 날이 아닌 날까지 민다")
//    fun push2() {
//        val date = LocalDate.of(2022, 6, 6)
//        assertThat(NormalDayGenerator.push(date).isEqual(LocalDate.of(2022, 6, 8))).isTrue
//    }
//
//    @Test
//    @DisplayName("입력한 날짜가 특별한 날 일 경우 특별한 날이 아닌 날까지 당긴다")
//    fun pull2() {
//        val date = LocalDate.of(2022, 6, 7)
//        assertThat(NormalDayGenerator.pull(date).isEqual(LocalDate.of(2022, 6, 5))).isTrue
//    }

}