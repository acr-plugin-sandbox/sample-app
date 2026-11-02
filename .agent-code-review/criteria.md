# sample-app review criteria

- No blocking calls on the main thread: `runBlocking` in production code is a BLOCKER.
- Coroutines are launched from a lifecycle-aware scope, never from `GlobalScope`.
- Avoid `!!` on values that can be null at runtime.
- Flavor-specific code lives in `src/free` and `src/paid`, never behind runtime checks.
