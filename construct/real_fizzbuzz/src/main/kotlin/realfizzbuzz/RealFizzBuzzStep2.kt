package main.kotlin.realfizzbuzz

class RealFuzzBuzzStep2 {
    fun createWith(range: IntRange): String {
        var result = ""
        range.forEach { number ->
            result += when {
                "$number".contains("3") -> "lucky"
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> number
            }
            result += " "
        }
        return result.trimEnd()
    }
}
