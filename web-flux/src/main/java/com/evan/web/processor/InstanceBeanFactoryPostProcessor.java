package com.evan.web.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @version 1.0
 * @author: kang Yifan
 * @date 7/24/2022 10:26 AM
 */
@Component
public class InstanceBeanFactoryPostProcessor implements BeanFactoryPostProcessor, Ordered {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("instanceBeanPostProcessor");
        System.out.println(beanDefinition.getBeanClassName());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
