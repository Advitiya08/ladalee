# 🧠 Spring AOP - Quick Notes & Example

---

## 🔹 What is AOP?

Aspect-Oriented Programming (AOP) is used in Spring to modularize cross-cutting concerns like logging, security, and transactions without cluttering business logic.

---

## 🔧 Common Pointcut Expressions

| Expression            | What It Matches                                       |
|------------------------|-------------------------------------------------------|
| `execution(...)`       | Method execution                                      |
| `within(...)`          | Methods within a package or class                     |
| `@annotation(...)`     | Methods annotated with a specific annotation          |
| `@within(...)`         | Classes annotated with a specific annotation          |
| `@args(...)`           | Method arguments annotated with a specific annotation |

---

## 🔁 Advice Types

| Annotation           | Timing                          |
|----------------------|----------------------------------|
| `@Before`            | Before method execution          |
| `@After`             | After method execution           |
| `@AfterReturning`    | After method returns successfully|
| `@AfterThrowing`     | After method throws exception    |
| `@Around`            | Wraps the method call            |

---

## 🔄 How Spring AOP Works Internally

1. Scans for `@Aspect`-annotated beans.
2. Creates advisors based on `@Before`, `@After`, etc.
3. Matches pointcut expressions to target beans.
4. Creates a proxy (JDK or CGLIB) for matched beans.
5. On method call → proxy intercepts → advice applied.

---

## 🧪 Example Classes

### 1️⃣ LoggingAspect.java

```java
package com.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterReturning;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("➡️ Entering method: " + joinPoint.getSignature().getName());
    }

    @AfterReturning("execution(* com.example.service.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("✅ Exiting method: " + joinPoint.getSignature().getName());
    }
}


Spring AOP utilizes AspectJ's pointcut language to define where advice should be applied. Here are some commonly used pointcut designators:

execution: Matches method execution join points.
Example: execution(* com.example.service.*.*(..)) matches all methods in classes within the com.example.service package.​

within: Matches join points within certain types.
Example: within(com.example.service.*) matches all methods within classes in the com.example.service package.​

@within: Matches join points within types annotated with a specific annotation.
Example: @within(org.springframework.transaction.annotation.Transactional) matches all methods within classes annotated with @Transactional.​

@args: Matches join points where the runtime type of the arguments passed have annotations.
Example: @args(com.example.security.Secured) matches methods where the arguments are annotated with @Secured.​

@annotation: Matches join points where the subject of the join point has the given annotation.
Example: @annotation(org.springframework.transaction.annotation.Transactional) matches methods annotated with @Transactional.​

🔄 Spring AOP Workflow: Step-by-Step
Aspect Detection: Spring scans for classes annotated with @Aspect during the application context initialization.​

Advisor Creation: For each advice method (e.g., methods annotated with @Before, @After, @Around), Spring creates an Advisor that encapsulates the advice and the associated pointcut expression.​


Proxy Creation: Spring determines which beans match the pointcut expressions. For these beans, Spring creates proxies:

JDK Dynamic Proxies: Used when the target bean implements at least one interface.

CGLIB Proxies: Used when the target bean does not implement any interfaces.​

+4

Advice Application: When a method on a proxied bean is invoked, the proxy intercepts the call and applies the relevant advice in the following order:

@Around advice

@Before advice

Method execution

@After advice

@AfterReturning or @AfterThrowing advice, depending on the method outcome​



Method Execution: If @Around advice is present, it controls whether the actual method executes by invoking proceed().

🧵 Understanding Proxies in Spring AOP
Spring AOP is proxy-based, meaning it creates proxies for beans to apply aspects. Here's how it works:

JDK Dynamic Proxies: Used when the target bean implements interfaces. The proxy implements the same interfaces and delegates method calls to the target bean, applying advice as configured.​

CGLIB Proxies: Used when the target bean does not implement interfaces. CGLIB creates a subclass of the target bean at runtime, overriding methods to apply advice.​
Home

The choice between JDK and CGLIB proxies is determined by the presence of interfaces and can be configured explicitly if needed.​
Home
+2
Home
+2
Home
+2

🧠 Summary
Spring AOP uses AspectJ's pointcut expressions to define where advice should be applied.​


During application context initialization, Spring scans for aspects and creates Advisors based on the defined advice and pointcuts.​
Home

Spring creates proxies for beans that match the pointcut expressions, using JDK dynamic proxies or CGLIB proxies as appropriate.​
Home
+2
Home
+2
Home
+2

When methods on proxied beans are invoked, the proxies intercept the calls and apply the configured advice in the correct order.​

This mechanism allows for modularizing cross-cutting concerns like logging, transaction management, and security, keeping the core business logic clean and focused.​


