package com.nirvana.travel.bizCode.tblistener;

import com.nirvana.travel.bizCode.Result;
import com.nirvana.travel.bizCode.tblistener.common.GoodsInfoReq;
import org.springframework.stereotype.Component;

/**
 * @author arainliu
 * @date 2023/2/20
 */
@Component
public class TBGoodsInfoSyncHandler implements TaobaoHandler<GoodsInfoReq>{

    @Override
    public Result handler(GoodsInfoReq goodsInfoReq) {

        // TODO: 2023/2/20 biz
        return null;
    }
}
