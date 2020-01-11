package test.kotlin.realfizzbuzz

import main.kotlin.realfizzbuzz.RealFuzzBuzzStep2
import org.junit.Test
import kotlin.test.assertEquals

class RealFizzBuzzStep2Test {
    private val testSubject = RealFuzzBuzzStep2()

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

    @Test fun `Given requirement range of 1 to 20, "lucky", "fizz", "buzz" and "fizzbuzz" should be in their place`() {
        // GIVEN/WHEN
        val result = testSubject.createWith(1..20)

        // THEN
        assertEquals("1 2 lucky 4 buzz fizz 7 8 fizz buzz 11 fizz lucky 14 fizzbuzz 16 17 fizz 19 buzz", result)
    }

}
