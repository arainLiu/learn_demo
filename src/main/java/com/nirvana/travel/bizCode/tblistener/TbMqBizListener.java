package com.nirvana.travel.bizCode.tblistener;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.nirvana.travel.bizCode.Result;
import com.taobao.api.internal.tmc.TmcClient;
import com.taobao.api.internal.toplink.LinkException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author arainliu
 * @date 2023/2/20
 */
@Component
public class TbMqBizListener implements ApplicationListener<ApplicationEvent> {

    @Resource
    ApplicationContext applicationContext;

    private static Map<String, Class> handlers = Maps.newConcurrentMap();

    private static TmcClient client = null;

    public TbMqBizListener() {
        handlers.put("message_type_a", TBGoodsInfoSyncHandler.class);
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

        mqListen();
    }

    public void mqListen() {
        if (client == null) {
            client =  new TmcClient("getAppKey()", "getChannelPubKey()", "default");
            client.setMessageHandler((message, status) -> {
                try {
                    JSONObject content = JSONObject.parseObject(message.getContent());
                    Result result =  handleMsg(content);
                } catch (Exception e) {
                    status.fail();
                }
            });

            try {
                if(!client.isOnline()){
                    client.connect("getBaseApiUrl()");
                }
            } catch (LinkException e) {
            }
        }
    }

    public Result handleMsg(JSONObject content) {
        String type = content.getString("message_type") != null ? content.getString("message_type") : content.getString("messageType");
        content.put("message_type",type);
        Class apiClass = handlers.get(type);
        TaobaoHandler taoBaoHandler = (TaobaoHandler) applicationContext.getBean(apiClass);
        Type t = ((ParameterizedType) apiClass.getGenericInterfaces()[0]).getActualTypeArguments()[0];
        Result result = taoBaoHandler.handler(content.toJavaObject(t));
        return result;
    }


}
