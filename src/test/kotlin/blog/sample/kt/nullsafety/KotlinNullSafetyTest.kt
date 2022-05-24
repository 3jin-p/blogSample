package blog.sample.kt.nullsafety

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class KotlinNullSafetyTest {
    @Test
    fun test() {
        val person1 = Person("이지은", null, 30)
        val person2 = Person(createName("황")!!, "아이유", 30)
    }

    @Test
    fun testTypeSafeCall() {
        Assertions.assertThat(createName("황")?.length).isNull()
        Assertions.assertThat(createName("이")?.length).isEqualTo(3)
    }

    @Test
    fun testElvis() {
        Assertions.assertThat(createName("황") ?: "황지은").isEqualTo("황지은")
        Assertions.assertThat(createName("이") ?: "황지은").isEqualTo("이지은")
        Assertions.assertThat(createName("황") ?: createName("이")).isEqualTo("이지은")
    }

    @Test
    fun testTypeParameter() {
        printClass(null)
        println(5)
    }

    fun <T> printClass(value: T) {
        println(value?:Void::class.java)
    }

    private fun createName(firstName: String): String? {
        return when (firstName) {
            "김" -> "김지은"
            "박" -> "박지은"
            "이" -> "이지은"
            else -> null
        }
    }
}