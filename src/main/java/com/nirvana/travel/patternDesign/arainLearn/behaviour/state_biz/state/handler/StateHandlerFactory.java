package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.state.handler;

import com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity.IStateEntity;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author arainliu
 * @date 2023/2/18
 */
@Slf4j
@Component
public class StateHandlerFactory {
    @Autowired
    private ApplicationContext springContext;

    private static Map<Class<IStateEntity>, Map<String, IStateHandler>> stateHandlers = new HashMap<>();

    @Constructor
    public void init() {
        Collection states = this.springContext.getBeansWithAnnotation(StateHandler.class).values();
        for (Object object : states) {
            if (!(object instanceof IStateHandler)) {
                continue;
            }
            Type[] interfaceTypes = object.getClass().getGenericInterfaces();
            for (Type interfaceType : interfaceTypes) {
                Type[] parameterTypes = ((ParameterizedType) interfaceType).getActualTypeArguments();
                for (Type parameterType : parameterTypes) {
                    Class clazz = (Class) parameterType;
                    if (IStateEntity.class.isAssignableFrom(clazz)) {
                        Map<String, IStateHandler> entityStates = stateHandlers.get(clazz);
                        if (entityStates == null) {
                            entityStates = new HashMap<String, IStateHandler>();
                            stateHandlers.put(clazz, entityStates);
                        }
                        IStateHandler stateHandler = (IStateHandler) object;
                        StateHandler stateHandlerAnnotation = stateHandler.getClass().getAnnotation(StateHandler.class);
                        entityStates.put(stateHandlerAnnotation.name().name(), stateHandler);
//                        log.debug("状态实体：[{}]，状态类型：[{}]，状态处理类：[{}]", clazz.getSimpleName(),
//                                stateHandlerAnnotation.name(), stateHandler.getClass());
                    }
                }
            }
        }

    }

    public IStateHandler instance(String state, Class<? extends IStateEntity> clazz) {
        Map<String, IStateHandler> entityStates = stateHandlers.get(clazz);
        if (entityStates != null) {
            return entityStates.get(state);
        }
        log.debug("状态机类型[{}]没有匹配的处理器", clazz);
//        throw new HandlerNoneException("状态机类型" + clazz + "没有匹配的处理器");
        return null;
    }

}
