package blog.sample.spring.refactor1

import java.time.LocalDate

class NormalDayGenerator {

    companion object {
        fun push(date: LocalDate): LocalDate {
            var result = date
            while (SpecialDateChecker.isSpecialDay(result)) {
                result = result.plusDays(1)
            }
            return result
        }

        fun pull(date: LocalDate): LocalDate {
            var result = date
            while (SpecialDateChecker.isSpecialDay(result)) {
                result = result.minusDays(1)
            }
            return result
        }
    }
}