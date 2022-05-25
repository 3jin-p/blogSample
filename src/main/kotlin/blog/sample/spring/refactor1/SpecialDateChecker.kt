package blog.sample.spring.refactor1

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class SpecialDateChecker() {

    companion object {
        var specialDays: List<SpecialDate> = listOf()
        fun isSpecialDay(date: LocalDate) = specialDays.any { s -> s.date.isEqual(date) }
    }

    constructor(specialDateRepository: SpecialDateRepository): this() {
        specialDays = specialDateRepository.findAll()
    }
}