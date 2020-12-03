package cn.huhu.web.service.impl;

import cn.huhu.web.service.RetryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author huhu.shi @hand-china.com
 */
@Service
public class RetryServiceImpl implements RetryService {

    private static final Logger log = LoggerFactory.getLogger(RetryServiceImpl.class);

    @Retryable(maxAttempts = 5, backoff=@Backoff(delay=100, maxDelay=500), value = RuntimeException.class)
    public void doRetry(boolean isRetry) {
        log.info("开始执行A操作");
        log.info("通知执行B操作");
        if (isRetry) {
            throw new RuntimeException("B系统异常");
        }
    }


    public void doRecover(Throwable e, boolean isRetry) throws RuntimeException{
        log.info("全部重试失败，执行doRecover");
    }



}
