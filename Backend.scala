/**
 * The functions that will be displayed as output
 *
 * @author Justin Kocur
 */
object Backend {
  /**
   * Compares two characters on either side of the string
   *
   * @param myString  the String to test for being a palindrome
   * @param i1        the left index
   * @param i2        the right index
   * @return          true if characters match, false if not
   */
  private def palidromeCompare(myString: String, i1: Integer, i2: Integer): Boolean = {
    if(i1 >= i2)
      return true

    val b = palidromeCompare(myString, i1 + 1, i2 - 1)

    b && myString.charAt(i1) == myString.charAt(i2); // abcba
  }

  /**
   * Returns a String representation of whether or not a given string is a palindrome
   *
   * @param myString the string to check
   * @return  a string specifiying whether or not the String is a palindrome
   */
  def isPalindrome(myString: String): String = {
    if(palidromeCompare(myString, 0, myString.length() - 1))
      "This text is a palindrome!"
    else
      "This text is NOT a palindrome!"
  }

  /**
   *  Returns the first character in the string that only occurs once as a string
   *
   * @param myString  the string to check
   * @return   the first character as a string that only occurs once in the string
   */
  def firstNonRepeatedChar(myString: String): String = {
    val map = scala.collection.mutable.Map[Character, Integer]()

    // Find number of occurrences for each character
    var i = 0
    for(i <- 0 until myString.length()) {
      var current = 0
      if(map.contains(myString.charAt(i)))
        current += 1

      map(myString.charAt(i)) = current + 1
    }

    // For each character, in order, find the first one whose occurrence count
    // is greater than one (1)
    i = 0
    for(i <- 0 until myString.length()) {
      if(map(myString.charAt(i)) <= 1)
        return "The first character that only appears once is: " + myString.charAt(i)
    }

    "All characters were repeated."
  }

  /** my name is dunkaccino
   *  Returns the character(s) that appear most often in a string
   *
   * @param myString  the string to check
   * @return   the characters that appear most frequently in a string
   */
  def highestOccurringChar(myString: String): String = {
    val map = scala.collection.mutable.Map[Character, Integer]()
    val list = scala.collection.mutable.ListBuffer[Character]()
    val builder = new StringBuilder("The characters with the highest frequencies are: ")

    // Find number of occurrences for each character
    var i = 0
    for(i <- 0 until myString.length()) {
      var current = 0
      if(map.contains(myString.charAt(i)))
        current = map(myString.charAt(i))

      if(myString.charAt(i) != ' ') // no need to include spaces
        map(myString.charAt(i)) = current + 1
    }

    // Find the highest frequency
    var highestFrequency = 0
    for ((key, value) <- map) {
      val freq = value
      if(freq > highestFrequency)
        highestFrequency = freq
    }

    // Find all characters with the highest frequency and put them in the list
    for ((key, value) <- map) {
      val c = key
      if(value == highestFrequency)
        list += c
    }

    // Place all of these characters in the StringBuilder
    for(i <- list.indices) {
      builder += list(i)

      if(i != list.length - 1) {
        builder += ','
        builder += ' '
      }
    }

    builder.toString()
  }
}
