package blog.sample.spring.refactor1

import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class SpecialDate(
    @Id
    var id: String? = null,
    val name: String,
    val date: LocalDate
) {
}