package com.github.kalininaleksandrv.workwithcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class MyContextRegistrar implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /*
    here we fetch bean definition registry from context, set a property and register bean definition in a registry
     */
    public void registerBean() {

        AutowireCapableBeanFactory factory =
                applicationContext.getAutowireCapableBeanFactory();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
        GenericBeanDefinition gbd = new GenericBeanDefinition();
        gbd.setBeanClass(SomeService.class);
        gbd.getPropertyValues().addPropertyValue("bound", 100);

        registry.registerBeanDefinition("SomeService", gbd);
    }

    /*
    here we fetch context, it must be done only after the creation of context
    we add method registerBean to invoke when context is ready
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MyContextRegistrar.applicationContext = applicationContext;
        registerBean();
    }
}
