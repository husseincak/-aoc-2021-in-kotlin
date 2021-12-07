import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

fun readInput(name: String) = File("txt", "$name.txt").readLines()
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

fun main() {
    fun calculate_sum(number: Int): Int{
        var i = 1
        var sum = 0 

        while (i <= number) {
            sum += i
            i++
        }

        return sum
    }

    fun calculate_median(l: List<Int>): Int{
        return l.sorted().let { (it[it.size/2] + it[(it.size - 1)/2])/2 }
    }

    fun calculate_fuel1(numbers: List<Int>, final_n: Int): Int {
        return numbers.fold(0, { acc, i -> acc + Math.abs(i - final_n) })
    }

    fun part1(input: List<String>): Int {
        val numbers = input.map { string -> string.toInt() }
        val median = calculate_median(numbers)

        return calculate_fuel1(numbers, median)
    }


    fun calculate_fuel2(numbers: List<Int>, final_n: Int): Int {
        return numbers.fold(0, { acc, i -> acc + calculate_sum(Math.abs(i - final_n)) })
    } 

    fun part2(input: List<String>): Int {
        val numbers = input.map { string -> string.toInt() }

        val average = numbers.average()
        val median = calculate_median(numbers)
        val final_n = if(Math.abs(average - median) < median) Math.floor(average) else Math.ceil(average)

        return calculate_fuel2(numbers, final_n.toInt())
    }

    val input = readInput("Day07")

    println(part1(input))
    println(part2(input))
 }
