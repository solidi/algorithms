package main.kotlin.realfizzbuzz

const val LUCKY = "lucky"
const val FIZZ = "fizz"
const val BUZZ = "buzz"
const val FIZZBUZZ = "fizzbuzz"
const val INTEGER = "integer"

class RealFuzzBuzzStep3 {

    // TODO: ticket #1; decouple stats counter when there are more use cases.
    //       for now, counts reflect the last range given.
    private val counter = hashMapOf<String, Int>()

    fun createWith(range: IntRange): String {
        var result = ""
        counter.clear()

        range.forEach { number ->
           when {
               "$number".contains("3") -> {
                    result += LUCKY
                    counter.incrementByOne(LUCKY)
                } number % 15 == 0 -> {
                    result += FIZZBUZZ
                    counter.incrementByOne(FIZZBUZZ)
                } number % 3 == 0 -> {
                    result += FIZZ
                    counter.incrementByOne(FIZZ)
                } number % 5 == 0 -> {
                    result += BUZZ
                    counter.incrementByOne(BUZZ)
                } else -> {
                    result += number
                    counter.incrementByOne(INTEGER)
                }
            }
            result += " "
        }

        return result.trimEnd()
    }

    fun lastCount(): String = "$FIZZ: ${counter[FIZZ]} " +
            "$BUZZ: ${counter[BUZZ]} " +
            "$FIZZBUZZ: ${counter[FIZZBUZZ]} " +
            "$LUCKY: ${counter[LUCKY]} " +
            "$INTEGER: ${counter[INTEGER]}"

}

// TODO: ticket #2; decide as a team on how to organize extension functions.
fun HashMap<String, Int>.incrementByOne(key: String) {
    this[key] = this.getOrDefault(key, defaultValue = 0) + 1
}
