fun main()
{
    for (i in 0 .. 10 step 2)
    {

        println(i)
    }
}

infix fun Int.sum(other : Int) = this + other


fun runDigitCountTest()
{
    while (true)
    {
        print("Enter the number: ")
        val value = readln().toInt()

        println("$value digit number is: ${countDigits(value)}")

        if (value == 0)
            break
    }
}

fun palindromeTest()
{
    while (true)
    {
        print("Enter the number: ")
        val value = readln().toInt()

        println(if (isPalindrome(value)) "$value is palindrome" else "$value is not palindrome")

        if (value == 0)
            break
    }
}
fun countDigits(value : Int) : Int
{
    var value = value

    var count = 0

    do {
        ++count
        value /= 10
    } while(value != 0)

    return count
}


fun runSUmDigitTest()
{
    while (true)
    {
        print("Enter the number: ")
        val value = readln().toInt()

        println("$value digits of sum is: ${reversed(value)}")

        if (value == 0)
            break
    }
}

fun sumDigits(value : Int) : Int
{
    var temp = value

    var sum = 0

    do
    {
        sum += temp % 10
        temp /= 10
    } while (temp != 0)

    return sum
}

fun reversed(value : Int) : Int
{
    var temp = value

    var reverseNumber = 0

    while (temp != 0)
    {
        reverseNumber = temp % 10 + reverseNumber * 10
        temp /= 10

    }

    return reverseNumber
}

fun isPalindrome(value : Int) : Boolean
{
    return value == reversed(value)
}