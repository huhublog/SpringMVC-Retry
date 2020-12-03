package cn.huhu.web.service;

import org.springframework.retry.annotation.Recover;

/**
 * @author huhu.shi @hand-china.com
 */
public interface RetryService {

    void doRetry(boolean isRetry);

    @Recover
    void doRecover(Throwable e, boolean isRetry);
}
