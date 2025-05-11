# Spring @Async and Executor Configuration Summary

## 1. How Spring Picks Executor for `@Async`

| Scenario                                               | Executor Used                                 |
|--------------------------------------------------------|-----------------------------------------------|
| One `@Bean` of type `Executor`                         | ✅ That one is used by default                 |
| Multiple `Executor` beans                              | ❌ Error unless one is `@Primary` or `@Async("name")` is used |
| `@Bean` returns `ThreadPoolTaskExecutor` only          | ❌ Not used unless named with `@Async("name")` |
| `@Async("beanName")` used                              | ✅ That exact bean is used                     |
| `AsyncConfigurer` implemented                          | ✅ Overrides all others via `getAsyncExecutor()` |

---

## 2. Key Concepts

- `@Async` enables background task execution via AOP.
- If no executor is defined, Spring uses `SimpleAsyncTaskExecutor`.
- Use `ThreadPoolTaskExecutor` for better control (Spring-managed).
- Java’s `ThreadPoolExecutor` can be used, but must be returned as type `Executor` and referenced by name.

---

## 3. Thread Pool Parameters

| Parameter           | Description                                       |
|---------------------|---------------------------------------------------|
| `corePoolSize`      | Minimum threads always alive                      |
| `maxPoolSize`       | Max threads allowed during heavy load             |
| `queueCapacity`     | Number of tasks to queue before scaling threads   |
| `keepAliveSeconds`  | Idle timeout for non-core threads                 |
| `threadNamePrefix`  | Custom prefix for threads for easy debugging      |

---

## 4. Best Practices for Async Tasks

- Use `@Async` for non-blocking or background operations.
- Avoid `@Async` for heavy CPU-bound tasks without tuning pool size.
- Use custom thread name prefixes for easy tracking.
- Monitor thread and CPU usage in production.

---

## 5. Logging Which Executor Is Used

- Log `Thread.currentThread().getName()` inside `@Async` methods.
- Use unique `threadNamePrefix` in each executor.
- Optionally wrap executor in a logging proxy to intercept `execute()`.

---

## 6. Debug & Monitoring Tips

- Use `AsyncConfigurer` for consistent global async configuration.
- If using breakpoints, remember the debugger may pause all threads by default.
- Adjust debugger settings to suspend only one thread if needed.