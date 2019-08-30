package utility;/*
 * @author atulyadav on 2019-08-28 12:49
 *
 * class for getting bean from application context
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceFactory implements ApplicationContextAware{

    private static ApplicationContext applicationContext;
    private static final Map<String, Object> CLASS_TO_SERVICE_MAP = new ConcurrentHashMap<>();

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        System.out.println("[*** setting application context ***]");
        applicationContext = context;
    }

    public static Object getService(String fqn) {
        ApplicationContext applicationContext = getApplicationContext();
        if (CLASS_TO_SERVICE_MAP.get(fqn) != null) {
            return CLASS_TO_SERVICE_MAP.get(fqn);
        } else {
            final Object bean = applicationContext.getBean(fqn);
            CLASS_TO_SERVICE_MAP.put(fqn, bean);
            return bean;
        }
    }

    public static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new IllegalStateException("Application context not set");
        }
        return applicationContext;
    }
}
