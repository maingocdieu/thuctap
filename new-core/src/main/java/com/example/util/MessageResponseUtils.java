package com.example.util;

import com.example.constant.SystemConstant;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageResponseUtils {

    public Map<String, String> getMessageResponse(String message) {
        Map<String, String> maps = new HashMap<>();
        if (message != null) {
            if (message.equals(SystemConstant.INSERT_ACTION)) {
                maps.put(SystemConstant.ALERT, "success");
                maps.put(SystemConstant.MESSAGE_RESPONSE, "Thêm thành công");
            } else if (message.equals(SystemConstant.UPDATE_ACTION)) {
                maps.put(SystemConstant.ALERT, "success");
                maps.put(SystemConstant.MESSAGE_RESPONSE, "Cập nhật thành công");
            } else if (message.equals(SystemConstant.DELETE_ACTION)) {
                maps.put(SystemConstant.ALERT, "success");
                maps.put(SystemConstant.MESSAGE_RESPONSE, "Xóa thành công");
            } else if (message.equals(SystemConstant.ERROR_SYSTEM)) {
                maps.put(SystemConstant.ALERT, "danger");
                maps.put(SystemConstant.MESSAGE_RESPONSE, "Lỗi hệ thống");
            }
        }
        return maps;
    }
}
