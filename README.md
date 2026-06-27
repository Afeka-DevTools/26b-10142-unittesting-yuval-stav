# 26B-10142 — Unit Testing (Afeka HW2)

A small Gradle Java project that demonstrates unit testing with JUnit 5 and
test coverage with JaCoCo. The class under test, `org.example.App`, contains a
set of utility methods (math, string, and collection helpers). `AppTest`
provides unit tests that cover every method, branch, and edge case.

## Team members

- Yuval Peles
- Stav

## Project structure

```
app/src/main/java/org/example/App.java      # the code under test
app/src/test/java/org/example/AppTest.java  # the unit tests
app/build.gradle.kts                         # build config (JUnit 5 + JaCoCo)
logs/COPILOT.md                              # AI-assisted session log (Part 3)
chats/                                       # chat transcripts
```

## Requirements

- A JDK (Java 17 or 21 recommended). The Gradle build uses a Java 21 toolchain.
- No global Gradle install needed — use the bundled wrapper (`gradlew`).

## Running from scratch

1. Clone the repository:

   ```
   git clone https://github.com/Afeka-DevTools/26b-10142-unittesting-yuval-stav.git
   cd 26b-10142-unittesting-yuval-stav
   ```

2. Run all the unit tests:

   - Windows:

     ```
     ./gradlew.bat test
     ```

   - macOS / Linux:

     ```
     ./gradlew test
     ```

   The test result report is written to:
   `app/build/reports/tests/test/index.html`

## Test coverage (JaCoCo)

To run the tests and generate the coverage report:

- Windows:

  ```
  ./gradlew.bat jacocoTestReport
  ```

- macOS / Linux:

  ```
  ./gradlew jacocoTestReport
  ```

(`test` already triggers the coverage report automatically, so
`./gradlew test` also produces it.)

The HTML coverage report is written to:

```
app/build/reports/jacoco/test/html/index.html
```

Open that file in a browser to inspect line and branch coverage. The current
test suite reaches **100% instruction, branch, line, and method coverage** of
`App`.
