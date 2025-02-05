package com.nirvana.travel.patternDesign.arainLearn.behaviour.state_biz.entity;

import java.util.Arrays;
import java.util.List;

/**
 * @author arainliu
 * @date 2023/2/18
 */
public enum StateEnum {

    /**
     * 通用状态
     */
    INIT("已创建"),

    PAYING("支付中"),

    PAY_FAILED("支付失败"), EXCEPTION("异常"), CLOSED("关闭"),

    PAY_SUCCEEDED("支付成功"),

    SUBMITTING("充值中"), SUBMIT_FAILED("充值失败"),

    SUBMIT_SUCCEEDED("充值成功"),

    REFUNDING("退款中"),

    REFUND_SUCCEEDED("退款成功"), //PARTIAL_REFUND("部分退款成功"),

    REFUND_FAILED("退款失败"), // 充值失败、返销处理。

    FINISH("交易结束"),
    ;

    private String description;

    StateEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }


    /**
     * 审批中
     */
    public static final List<StateEnum> LIST_PAGE_STATUS = Arrays.asList(PAYING,SUBMITTING, SUBMIT_FAILED, SUBMIT_SUCCEEDED,FINISH,
            REFUNDING, REFUND_SUCCEEDED, REFUND_FAILED, PAY_SUCCEEDED);

    /**
     * 交易成功订单
     */
    public static final List<StateEnum> LIST_SUCCESS_STATUS = Arrays.asList(SUBMITTING,PAY_SUCCEEDED, SUBMIT_FAILED, SUBMIT_SUCCEEDED, REFUND_SUCCEEDED);

}
