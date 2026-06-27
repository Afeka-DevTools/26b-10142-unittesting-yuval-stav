# Chat transcript — Part 3: Unit testing session

This is a copy/transcript of the AI-assisted session that produced the unit
tests for `App.java`. The full write-up is in `logs/COPILOT.md`.

## Request

> Write unit tests for every function in `App.java`, covering every branch and
> edge case. Verify coverage. Keep the tests simple and readable, like a
> first-year CS student would write them.

## What the assistant did

1. Confirmed the repo and Git identity, ran `git pull`.
2. Read `App.java` and listed all 11 static methods plus their branches:
   `add`, `isPrime`, `reverse`, `factorial`, `isPalindrome`, `fibonacciUpTo`,
   `charFrequency`, `isAnagram`, `average`, `filterEvens`, `mostCommonWord`.
3. Checked `build.gradle.kts` / `libs.versions.toml` -> JUnit Jupiter 5.12.1.
4. Replaced the placeholder `AppTest` (it called a non-existent `getGreeting()`)
   with a full test suite, using a mix of `assertEquals`, `assertTrue`,
   `assertFalse`, `assertNull`, `assertNotNull`, and `assertThrows`.
5. Added the `jacoco` plugin and report wiring to `build.gradle.kts`.
6. Ran `./gradlew test jacocoTestReport`.
   - First run: 100% branch coverage, but the implicit default constructor was
     uncovered (all methods are static).
   - Added `testConstructor_createsInstance()`.
   - Final run: 100% instruction / branch / line / method coverage.
7. Wrote `logs/COPILOT.md` and this chat copy, updated `README.md`.

## Coverage result

```
INSTRUCTION  100% (277/277)
BRANCH       100% (26/26)
LINE         100% (46/46)
METHOD       100% (12/12)
```

## Notes

- `logs/LEARNING.md` (Part 2) is intentionally left for Yuval.
- Push to GitHub is left to Yuval per the no-PAT rule.
