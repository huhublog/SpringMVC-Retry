package cn.huhu.web.test;

import cn.huhu.web.service.RetryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mvc.xml" })
public class TestRetryService {

    @Autowired
    private RetryService retryService;

    @Test
    public void test1(){
        retryService.doRetry(true);
    }
}