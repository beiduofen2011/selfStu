package com.fen.dou.hikarietest.entity;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang.StringUtils;

/**
 * @Author: hejis
 * @Description:
 * @Date: Create in 17:37 2019/7/17
 * @Modified By:
 */
@Data
@ToString
public class ResultVo {

    public ResultVo() {
    }

    public ResultVo(Integer status, String error) {
        this.status = status;
        this.error = error;
    }

    public ResultVo(String timestamp, String path, Integer status, String error,
                    String message) {
        this.timestamp = timestamp;
        this.path = path;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    private String timestamp;

    private String path;

    private Integer status;

    private String error;

    private String message;

    public boolean isSuccess(){
        if(status != null && status > 299 && StringUtils.isNotBlank(message)){
            return false;
        } else {
            return true;
        }
    }

}
