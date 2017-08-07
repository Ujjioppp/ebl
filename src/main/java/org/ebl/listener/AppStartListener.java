package org.ebl.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

/**
 * Created by yeli on 02/08/2017.
 */
@Service
public class AppStartListener implements ApplicationListener<ContextRefreshedEvent>{
    private final Logger logger = LoggerFactory.getLogger(AppStartListener.class);

//    @Autowired
//    private RedisService redisService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event.getApplicationContext().getParent() == null) {
//            logger.error("this is starting method!!! {}",redisService.get("key"));
        }
    }
}
