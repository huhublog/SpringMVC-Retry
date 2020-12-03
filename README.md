# SpringMVC-Retry

## 集成步骤:

### 添加pom

```xml
<dependency>
	<groupId>org.springframework.retry</groupId>
	<artifactId>spring-retry</artifactId>
	<version>1.2.0.RELEASE</version>
	<exclusions>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
		</exclusion>
		<exclusion>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
		</exclusion>
	</exclusions>
</dependency>

<dependency>
	<groupId>org.springframework</groupId>
	<artifactId>spring-aspects</artifactId>
	<version>5.2.8.RELEASE</version>
</dependency>
```

### applicationContext.xml

```xml
<!--开启代理-->
<aop:aspectj-autoproxy />
```

### 编写配置文件

```java
@Configuration
@EnableRetry(proxyTargetClass = true)
@Order(Integer.MIN_VALUE)
public class RetryConfig {

}
```

## 使用步骤

```java
// 加在需要retry的方法上
@Retryable(maxAttempts = 5, backoff=@Backoff(delay=100, maxDelay=500), value = RuntimeException.class)
```

```java
//加载需要处理Retryable异常的**接口**方法上
@Recover
```

## 坑

使用JDK动态代理(接口 + 实现)的时候注意:

@Retryable或者@Recover修饰的方法一定要在接口中声明

@Retryable可以修饰在接口的方法声明上，也可以修饰在方法实现上

@Recover注解只能修饰在接口的方法声明中
