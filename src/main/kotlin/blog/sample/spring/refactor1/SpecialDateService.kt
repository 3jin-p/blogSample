package blog.sample.spring.refactor1

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class SpecialDateService(
    val specialDateRepository: SpecialDateRepository
) {

    fun isSpecialDay(date: LocalDate): Boolean {
        val specialDays = specialDateRepository.findAll()
        return specialDays.any { s -> s.date.isEqual(date) }
    }

    fun push(date: LocalDate): LocalDate {
        var result = date
        while (isSpecialDay(result)) {
            result = result.plusDays(1)
        }
        return result
    }

    fun pull(date: LocalDate): LocalDate {
        var result = date
        while (isSpecialDay(result)) {
            result = result.minusDays(1)
        }
        return result
    }
}