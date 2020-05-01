package cn.manager.model;

import java.util.HashMap;

/**
 * @author Wangyl
 * @date 2019/9/26
 */

public class ResponseModel extends HashMap<String, Object> {

    public ResponseModel(Object res) {
        put("res", res);
    }

    public ResponseModel() {

    }
}
