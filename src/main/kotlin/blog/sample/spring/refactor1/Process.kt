package blog.sample.spring.refactor1

import java.time.LocalDate

class Process(
    val processId: String,
    val sequence: Int,
    var dday: LocalDate
): Comparable<Process> {

    init {
        dday = NormalDayGenerator.pull(dday)
    }

    override fun compareTo(other: Process): Int = this.sequence - other.sequence
}