package test.kotlin.realfizzbuzz

import main.kotlin.realfizzbuzz.RealFuzzBuzzStep3
import org.junit.Test
import kotlin.test.assertEquals

class RealFizzBuzzStep3Test {
    private val testSubject = RealFuzzBuzzStep3()

    @Test fun `Given a range of 1 to 2, they should be in place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(1..2)

        // THEN
        assertEquals("1 2", result)
    }

    @Test fun `Given a range of 1 to 3, when the number contains a digit of three, "lucky" should be in its place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(1..3)

        // THEN
        assertEquals("1 2 lucky", result)
    }

    @Test fun `Given a range of 6 to 9, when the number is divisible by three, "fizz" should be in its place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(6..9)

        // THEN
        assertEquals("fizz 7 8 fizz", result)
    }

    @Test fun `Given a range of 1 to 5, when the number is divisible by five, "buzz" should be in its place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(1..5)

        // THEN
        assertEquals("1 2 lucky 4 buzz", result)
    }

    @Test fun `Given a range of 9 to 15, when the number is divisible by three and five, "fizzbuzz" should be in its place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(9..15)

        // THEN
        assertEquals("fizz buzz 11 fizz lucky 14 fizzbuzz", result)
    }

    @Test fun `Given range requirement of 1 to 20, "lucky", "fizz", "buzz" and "fizzbuzz" should be in their place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(1..20)

        // THEN
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", result)
    }

    @Test fun `Given no range, when not created, return null on "fizz", "buzz", "fizzbuzz", "lucky" and "integer" counts`() {
        // WHEN
        val result = testSubject.lastCount()

        // THEN
        assertEquals("fizz: null buzz: null fizzbuzz: null lucky: null integer: null", result)
    }

    @Test fun `Given requirement range of numbers, return "fizz", "buzz", "fizzbuzz", "lucky" and "integer" counts`() {
        // GIVEN
        testSubject.createWith(1..20)

        // WHEN
        val result = testSubject.lastCount()

        // THEN
        assertEquals("fizz: 4 buzz: 3 fizzbuzz: 1 lucky: 2 integer: 10", result)
    }

    @Test fun `Given multiple ranges of numbers, when created more than once, reset stats and recount`() {
        // GIVEN
        testSubject.createWith(1..20)
        testSubject.createWith(9..15)

        // WHEN
        val result = testSubject.lastCount()

        // THEN
        assertEquals("fizz: 2 buzz: 1 fizzbuzz: 1 lucky: 1 integer: 2", result)
    }

}
