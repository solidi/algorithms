package main.kotlin.realfizzbuzz

fun main(args: Array<String>) {
    val fizzbuzz = RealFuzzBuzzStep3()
    println(fizzbuzz.createWith(IntRange(1, 20)))
    println(fizzbuzz.lastCount())
}
