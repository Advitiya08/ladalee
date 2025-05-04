# Spring Web Request Flow: Filters, Interceptors, and AOP

This document summarizes key concepts and differences between Filters, Interceptors, and AOP in a Spring Boot web application.

---

## 🚦 DispatcherServlet

- Core router in Spring MVC.
- One per Spring context (not per controller).
- Maps HTTP requests to controller methods.
- Created and registered automatically by Spring Boot.

---

## 🧭 HandlerInterceptor

- Intercepts requests **after DispatcherServlet**, **before controller method**.
- Not based on AOP; part of Spring MVC.
- Lifecycle methods:
  - `preHandle()` – before controller method
  - `postHandle()` – after controller method
  - `afterCompletion()` – after view rendering or error
- Skipped for unmatched routes.
- Works only on Spring-handled requests.

---

## 🔁 Spring AOP

- Used for cross-cutting concerns (logging, metrics, transactions, etc.).
- Operates on Spring-managed beans (`@Service`, `@Controller`).
- Uses proxies + reflection (`Method.invoke()`).
- Advice types: `@Before`, `@After`, `@Around`, etc.
- Pointcut expressions parsed at startup; advice logic runs at runtime.
- Cannot intercept raw HTTP or lambda-based logic (e.g., in Spark, big data).

---

## 🔒 Servlet Filter

- Runs **before DispatcherServlet**.
- Works at Tomcat/Servlet level (not Spring-specific).
- Lifecycle methods:
  - `init()` – called once at startup
  - `doFilter()` – called on every request
  - `destroy()` – called once at shutdown
- Sees all URLs, including static files, `/error`, and Spring routes.
- Used for authentication, logging, compression, rate limiting, etc.

---

## ⚙️ Filter Registration

| Method                  | Mapping Scope | Specific URLs? | Spring Bean Aware? |
|------------------------|----------------|----------------|---------------------|
| `@Component`           | `"/*"`         | ❌ No          | ✅ Yes              |
| `FilterRegistrationBean` | Custom         | ✅ Yes         | ✅ Yes              |

- `@Component` filters are auto-registered and apply to all requests.
- Use `FilterRegistrationBean` to target specific paths like `/api/*`.

---

## 🛑 Blocking Requests in Filter

To stop request flow inside a filter:

```java
if (unauthorized) {
    response.setStatus(401);
    response.getWriter().write("Unauthorized");
    return; // 🔥 Don't call chain.doFilter → request is blocked
}
