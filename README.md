# Basic: Java Practice Exercises (HackerRank, LeetCode & Core Java)

A collection of small, self-contained **Java** programs written while practising for coding
challenges and the HackerRank Java certification. Each file is one exercise with its own
`main` method, so you can run them one at a time.

| Folder | What's inside |
| --- | --- |
| [`src/HackerRank`](#hackerrank) | Solutions to HackerRank Java challenges: strings, regex, arrays, dates, linked lists, HTTP + JSON |
| [`src/HackerRank/Java_Basic_Certification`](#java-basic-certification) | Practice questions for the HackerRank *Java (Basic)* certificate |
| [`src/LeetCode`](#leetcode) | Classic LeetCode problems: Two Sum, Median of Two Sorted Arrays, Roman to Integer, … |
| [`src/switch_case`](#switch_case) | An interactive console menu built with `switch`, plus sorting and date helpers |
| [`src/Encryption`](#encryption) | RSA encryption and decryption with `javax.crypto`, written as JUnit 5 tests |

## Table of contents

- [Requirements](#requirements)
- [Running in IntelliJ IDEA](#running-in-intellij-idea)
- [Running from the command line](#running-from-the-command-line)
- [Exercise catalogue](#exercise-catalogue)
- [Notes](#notes)
- [Project structure](#project-structure)

## Requirements

- **JDK 8 or newer.** The project is set up for JDK 11, and everything also compiles on JDK 21
  (see the [note on `IntToString`](#notes)).
- **Two external jars**, needed by only two files:
  - [`org.json`](https://mvnrepository.com/artifact/org.json/json) for `HackerRank/HTTPRequest.java`
  - [JUnit 5](https://junit.org/junit5/) for `Encryption/EncryptionExample.java`
- Optional: [IntelliJ IDEA](https://www.jetbrains.com/idea/). The repository includes its project
  files (`.idea/`, `JavaDose.iml`).

## Running in IntelliJ IDEA

1. **File → Open** and select the repository folder.
2. Set the project SDK: **File → Project Structure → Project → SDK** (JDK 11 or newer).
3. Fix the `org.json` library path. The project expects the jar at `C:/Library/org.json.jar`.
   Either put the jar there, or open **Project Structure → Libraries → org.json** and point it
   to wherever you downloaded it. IntelliJ downloads JUnit 5 on its own from the module settings.
4. Open any exercise and click the green ▶ next to its `main` method (or next to a `@Test`
   method in `EncryptionExample`).
5. Type the input into the **Run** window, since most HackerRank exercises read from the keyboard.

## Running from the command line

The commands below are for macOS and Linux. On Windows, see the note after them.

```bash
# 1. Download the two jars into lib/ (ignored by git)
mkdir -p lib
curl -L -o lib/json-20231013.jar \
  https://repo1.maven.org/maven2/org/json/json/20231013/json-20231013.jar
curl -L -o lib/junit-platform-console-standalone-1.10.2.jar \
  https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar

# 2. Compile everything into out/ (also ignored by git)
javac -d out -cp "lib/*" $(find src -name "*.java")

# 3. Run one exercise: java -cp "out:lib/*" <package>.<ClassName>
echo "anagram margana" | java -cp "out:lib/*" HackerRank.Anagram      # → Anagrams
java -cp "out:lib/*" LeetCode.RomanToInteger                           # no input needed

# 4. Run the JUnit tests
java -jar lib/junit-platform-console-standalone-1.10.2.jar -cp out --select-class Encryption.EncryptionExample
```

**Windows (Command Prompt):** use `;` instead of `:` in the classpath, and pass the source list
through a file:

```bat
dir /s /b src\*.java > sources.txt
javac -d out -cp "lib/*" @sources.txt
java -cp "out;lib/*" HackerRank.Anagram
```

The class to run is the file's package plus its class name. Files without a package (`Main.java`)
are run by class name only: `java -cp out Main`.

## Exercise catalogue

Each row shows the class to run and a sample input with its expected output. The input goes to
standard input (type it, or pipe it with `echo` / `printf`).

### HackerRank

| Class | Topic | Sample input → output |
| --- | --- | --- |
| `HackerRank.Anagram` | Two words are anagrams if they have the same letters (case-insensitive). Uses a hand-written sort | `anagram margana` → `Anagrams` |
| `HackerRank.DateAndTime` | Day of the week for a date, with `Calendar` | `08 05 2015` → `WEDNESDAY` |
| `HackerRank.EndOfFile` | Read lines until end of input, numbering them | `Hello world` ⏎ `I am a file` → `1 Hello world` ⏎ `2 I am a file` |
| `HackerRank.Growth2Dimensions` | After operations `r c` that each add 1 to rows 1..r × columns 1..c, how many cells hold the maximum? Answer: smallest r × smallest c | *(built-in examples)* → `1`, `2` |
| `HackerRank.HTTPRequest` | Calls the HackerRank mock API and collects article titles with `org.json` (needs internet access) | *(no input)* → list of titles |
| `HackerRank.IntToString` | Convert an `int` to a `String` (HackerRank boilerplate that blocks `System.exit`) | `100` → `Good job` |
| `HackerRank.JavaCurrencyFormatter` | Format a number as US, Indian, Chinese and French currency with `NumberFormat` | `12324.134` → `US: $12,324.13`, … |
| `HackerRank.JavaSubstringComparisons` | Lexicographically smallest and largest substring of length *k* | *(built-in: `welcometojava`, 3)* → `ava` ⏎ `wel` |
| `HackerRank.OneDArray` | Read *n* numbers into an array and print them | `5` ⏎ `10 20 30 40 50` → one per line |
| `HackerRank.PatternSyntaxChecker` | Is each line a valid regular expression? | `3` ⏎ `([A-Z])(.+)` ⏎ `[AZ[a-z](a-z)` ⏎ `batcatpat(nat` → `Valid` ⏎ `Invalid` ⏎ `Invalid` |
| `HackerRank.PlusMinus` | Ratio of positive, negative and zero values | `6` ⏎ `-4 3 -9 0 4 1` → `0.5` ⏎ `0.333…` ⏎ `0.166…` |
| `HackerRank.PrintReverse` | Print a singly linked list in reverse, recursively | `1` ⏎ `5` ⏎ `16 12 4 2 5` (one per line) → `5 2 4 12 16` (one per line) |
| `HackerRank.SingletonPattern` | The Singleton design pattern | *(no input)* → `test` |
| `HackerRank.StaticInitializerBlock` | A `static { }` block that reads input before `main` runs | `1` ⏎ `3` → `3`; `-1` ⏎ `2` → `java.lang.Exception: Breadth and height must be positive` |
| `HackerRank.StringIntroduction` | Length, lexicographic comparison and capitalising two strings | *(built-in: `java`, `java`)* → `8` ⏎ `No` ⏎ `Java Java` |
| `HackerRank.StringReverse` | Is the word a palindrome? | `madam` → `Yes` |
| `HackerRank.StringTokens` | Split a sentence into words on `[!,?._'@ ]` and count them | `He is a very very good boy, isn't he?` → `10` then the words |
| `HackerRank.SubString` | Substring from *start* (inclusive) to *end* (exclusive) | `Helloworld` ⏎ `3 7` → `lowo` |
| `HackerRank.ValidUsernameRegularExpression` | Validate usernames with a regex: 8–30 characters, starting with a letter | `3` ⏎ `Julia` ⏎ `Samantha` ⏎ `Samantha_21` → `Invalid` ⏎ `Valid` ⏎ `Valid` |
| `HackerRank.CanYouAccess` | *Unfinished:* the whole solution is commented out | – |

### Java Basic Certification

| Class | Topic | Sample input → output |
| --- | --- | --- |
| `HackerRank.Java_Basic_Certification.ImplC` | A class inherits an interface method from its superclass (`BaseC.java`) | *(no input)* → `Inside BaseC::method` |
| `HackerRank.Java_Basic_Certification.FloatNumber` | Wrapper conversions: `Float` → `int` + `byte` + `double` | *(no input)* → `9.0` |
| `HackerRank.Java_Basic_Certification.MultiSum` | Sum the numbers on a line; if anything isn't a number, join the words instead | `1 2 3` → `6`; `a b c` → `abc` |
| `HackerRank.Java_Basic_Certification.Shape` | Multiply two numbers (area of a rectangle) | `3 4` → `3 4` ⏎ `12` |
| `HackerRank.Java_Basic_Certification.TestThread` | Two threads printing in parallel (`SampleDemo.java`). **Runs forever**: stop it with Ctrl+C | *(no input)* → `A`, `B`, … |

### LeetCode

All of them use built-in examples, so no input is needed.

| Class | Problem | Output |
| --- | --- | --- |
| `LeetCode.TwoSum` | [1. Two Sum](https://leetcode.com/problems/two-sum/): indices of two numbers that add up to a target | `0` ⏎ `1` |
| `LeetCode.TwoNumbers` | [2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/): simplified with arrays instead of linked lists; prints the sum 342 + 465 | `807` |
| `LeetCode.MedianOfTwoSortedArrays` | [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/): merge and sort | `2.5` |
| `LeetCode.ReverseInteger` | [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/): returns 0 on overflow | `-123` |
| `LeetCode.Palindrome` | [9. Palindrome Number](https://leetcode.com/problems/palindrome-number/) | `false` (for 456) |
| `LeetCode.RomanToInteger` | [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/) | `1994` for MCMXCIV, `799` for DCCXCIX |
| `LeetCode.NumberOfSteps` | [1342. Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/): recursive | `6` |

### switch_case

| Class | What it does |
| --- | --- |
| `switch_case.App` | **Interactive menu.** Type `Y`, then pick an option. `1` says whether a number is even or odd, `5` prints its factorial (exact up to 20!). Options 2, 3, 4 and 6 are placeholders ("Nothing To Do") |
| `switch_case.SortingArray` | Bubble sort, printing three sorted examples |
| `switch_case.Holiday_Date.FindHolidayDate` | Date helpers (`Calendar`, `SimpleDateFormat`). `main` prints today's date at midnight |

Example session with the menu:

```text
$ java -cp out switch_case.App
Wanna Try ? ( Type Y / yes if want to try )
Y
...
Choose Number :
5
Input Variable : 5
Factorial of 5 is 120
Wanna Try Again ? (Y/YES)
N
Thank you for trying
```

### Encryption

`Encryption.EncryptionExample` is a **JUnit 5 test class**, so it runs with the test runner, not
`java`. It shows how to:

1. rebuild an RSA **public key** (X.509) and **private key** (PKCS#8) from Base64 strings with `KeyFactory`;
2. encrypt a message with the public key using `RSA/ECB/PKCS1Padding`;
3. decrypt it with the private key and check that the result matches the original text.

> ⚠️ The key pair in this file is a **demo key** that is public on GitHub. Never reuse it, and
> never commit real private keys to a repository.

## Notes

- **`IntToString` on Java 18 or newer.** HackerRank's boilerplate uses `System.setSecurityManager`,
  which newer JDKs block by default (`UnsupportedOperationException`). Run it on JDK 11/17, or add
  `-Djava.security.manager=allow`:
  `echo 100 | java -Djava.security.manager=allow -cp out HackerRank.IntToString`
- **`HTTPRequest` needs internet access** to `https://jsonmock.hackerrank.com`. When an article
  has no `title`, its `story_title` is used, and articles with neither are skipped.
- **`DateAndTime`** writes to the file in the `OUTPUT_PATH` environment variable when it is set
  (as on HackerRank), and to the console otherwise.
- The compiler prints a deprecation *note* for `FloatNumber` (`new Float(String)`). That's
  expected, because the exercise is about that constructor.

## Project structure

```text
.
├── src/
│   ├── Main.java                         # Hello World
│   ├── Encryption/                       # RSA example (JUnit 5)
│   ├── HackerRank/                       # HackerRank solutions
│   │   └── Java_Basic_Certification/     # Certification practice
│   ├── LeetCode/                         # LeetCode solutions
│   └── switch_case/                      # Console menu, sorting, date helpers
│       └── Holiday_Date/
├── .idea/, JavaDose.iml                  # IntelliJ IDEA project files
├── lib/                                  # Downloaded jars (not in git)
└── out/                                  # Compiled classes (not in git)
```
