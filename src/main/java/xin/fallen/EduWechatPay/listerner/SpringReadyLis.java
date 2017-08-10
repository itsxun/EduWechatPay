package xin.fallen.EduWechatPay.listerner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import xin.fallen.EduWechatPay.Config.GlobalConfig;
import xin.fallen.EduWechatPay.util.ConfigLoader;
import xin.fallen.EduWechatPay.util.FileFinder;

/**
 * Author: fallen
 * Date: 17-2-14
 * Time: 上午9:45
 * Usage:
 */
public class SpringReadyLis implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger log = LoggerFactory.getLogger("SpringReadyLis");

    public void onApplicationEvent(ContextRefreshedEvent e) {
        ConfigLoader.load(FileFinder.find("config.xml"), GlobalConfig.class);
//        File file = new File("C:\\Users\\itsxu\\Desktop\\EduWechatPay\\src\\main\\resources\\config.xml");
//        ConfigLoader.load(file, GlobalConfig.class);
        log.info("SpringReadyLis：Config Load Complete");
    }
}