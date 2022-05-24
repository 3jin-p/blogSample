package blog.sample.spring.refactor1

import org.springframework.data.jpa.repository.JpaRepository

interface SpecialDateRepository: JpaRepository<SpecialDate, String> {
}