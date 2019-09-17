package com.imooc.producter.utils;

import com.imooc.producter.vo.ResultVO;

/**
 * @author zxlei
 * @date 2019/8/21 14:33
 * ----------------------------------------------
 * TODO
 * ----------------------------------------------
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMessage("success");
        resultVO.setData(data);
        return resultVO;
    }

}
