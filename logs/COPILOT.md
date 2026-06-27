# COPILOT.md — Part 3: AI-assisted Unit Testing Session

This log documents the AI-assisted session for **Part 3** of the assignment:
writing the unit tests for `App.java`, verifying full coverage, and wiring up
the coverage tooling.

> Note: `logs/LEARNING.md` (Part 2) is **not** included here — that is Yuval's
> own conversation and still needs to be added by him.

---

## 1. What was asked

> Write unit tests for the functions in `App.java`, in `AppTest.java`.
> Cover every function and every path/branch, including edge cases.
> Verify coverage. Write the tests plainly, like a first-year CS student
> (simple test methods, clear names, minimal comments).

The project is a Gradle Java app:
- `app/src/main/java/org/example/App.java` — the class under test.
- `app/src/test/java/org/example/AppTest.java` — where the tests go.
- Build: `app/build.gradle.kts`, JUnit **Jupiter 5.12.1**, Java toolchain 21.

The generated `AppTest` only had a placeholder test calling `getGreeting()`,
which does not exist on `App` (it would not even compile), so it was replaced
with real tests.

---

## 2. The functions and the branches/paths found

`App` has 11 static utility methods (plus the implicit default constructor).
For each one we listed every branch / edge case that needs a test:

| Function | Branches / paths / edge cases |
|----------|-------------------------------|
| `add(a,b)` | single path; positive, negative, zero |
| `isPrime(n)` | `n < 2` -> false (negative, 0, 1); `n == 2` (loop never runs); composite (`n % i == 0`); prime (loop finishes, returns true) |
| `reverse(s)` | normal, empty string, single char; `null` -> `NullPointerException` |
| `factorial(n)` | `n < 0` -> `IllegalArgumentException`; `n == 0` and `n == 1` (loop body skipped); positive |
| `isPalindrome(s)` | palindrome; palindrome with punctuation/spaces/case; non-palindrome; empty string (cleans to "", equals its own reverse) |
| `fibonacciUpTo(n)` | `n < 0` -> `IllegalArgumentException`; `n == 0` -> `[0]`; positive limit |
| `charFrequency(s)` | normal string (repeated chars hit `getOrDefault`); empty string -> empty map |
| `isAnagram(s1,s2)` | true case; true with spaces + different case; false case |
| `average(arr)` | empty array -> `IllegalArgumentException`; multi-element; single element |
| `filterEvens(list)` | mixed (even branch taken and skipped); empty list; all-odd (branch never taken) |
| `mostCommonWord(text)` | multiple words with a clear winner; single word |
| `App()` constructor | instantiate once so the default constructor is covered |

---

## 3. Test strategy

- **One logical case per test method**, descriptive names like
  `testFactorial_negativeThrows`, `testIsPrime_compositeNumber`.
- **A variety of assertions**, not just `assertEquals`:
  - `assertTrue` / `assertFalse` for the boolean methods (`isPrime`,
    `isPalindrome`, `isAnagram`, empty-collection checks).
  - `assertNull` / `assertNotNull` for the constructor.
  - `assertThrows` for every exception path (`factorial`, `fibonacciUpTo`,
    `average`, and `reverse(null)`).
  - `assertEquals` for the value-returning methods and the collection results.
- **Edge cases first**: nulls, empty input, zero, boundaries (`n < 2`,
  `n == 2`), invalid input, and each exception branch.
- Kept simple and readable — plain JUnit 5, no parameterized tests, no helper
  abstractions.

---

## 4. How sufficiency was checked (coverage)

JaCoCo was added to `app/build.gradle.kts`:
- applied the `jacoco` plugin,
- made `test` run the report (`finalizedBy(jacocoTestReport)`),
- enabled the HTML + XML reports.

Commands:

```
./gradlew.bat test jacocoTestReport
```

The HTML report lives at:

```
app/build/reports/jacoco/test/html/index.html
```

### First run

Branch coverage was already **100% (26/26)**, but one method / one line was
missed. The report showed the uncovered item was the **implicit default
constructor** of `App` — every real method is `static`, so the constructor was
never exercised.

### Fix

Added `testConstructor_createsInstance()` which does `new App()` and asserts the
instance is not null.

### Final run — full coverage

From `jacocoTestReport.xml`:

```
INSTRUCTION  missed=0  covered=277   (100%)
BRANCH       missed=0  covered=26    (100%)
LINE         missed=0  covered=46    (100%)
METHOD       missed=0  covered=12    (100%)
```

Every line, every branch, and every method of `App` is now covered. This is how
we know all paths are tested — the coverage report leaves nothing missed.

---

## 5. Environment note (local build fix)

The only JDK on this machine was a bundled **Java 25** runtime, which the
Gradle 8.14 Kotlin DSL cannot parse (it failed with `IllegalArgumentException:
25.0.2` while compiling `build.gradle.kts`). To build without changing the
committed Gradle wrapper, a local **Temurin JDK 21** was used only for the
build by setting `JAVA_HOME` for the `gradlew` invocation. No repo files were
changed for this; it is purely a local run detail.

---

## 6. Files changed in this session

- `app/src/test/java/org/example/AppTest.java` — full unit test suite.
- `app/build.gradle.kts` — added the `jacoco` plugin + report wiring.
- `logs/COPILOT.md`, `chats/` — this documentation.
- `README.md` — team members + run instructions.

## 7. Still needed (Yuval, Part 2)

- `logs/LEARNING.md` — Yuval's own part-2 conversation. Intentionally left out.
- Push to GitHub — must be done by Yuval per the PAT rule (no token is ever
  entered in this session).
