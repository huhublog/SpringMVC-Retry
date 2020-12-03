package cn.huhu.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.retry.annotation.EnableRetry;

/**
 * @author huhu.shi @hand-china.com
 */
@Configuration
@EnableRetry(proxyTargetClass = true)
@Order(Integer.MIN_VALUE)
public class RetryConfig {

}
