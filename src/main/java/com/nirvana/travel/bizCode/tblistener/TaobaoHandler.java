package com.nirvana.travel.bizCode.tblistener;

import com.nirvana.travel.bizCode.Result;

/**
 * @author arainliu
 * @date 2023/2/20
 */
public interface TaobaoHandler<T> {

    Result handler(T t);
}
