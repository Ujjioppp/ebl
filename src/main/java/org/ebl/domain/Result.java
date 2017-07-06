package org.ebl.domain;

/**
 * Created by yeli on 05/07/2017.
 */
public class Result {
    private boolean suc;

    private String msg;

    private Object data;

    public Result() {
    }

    public Result(boolean suc, String msg, Object data) {
        this.suc = suc;
        this.msg = msg;
        this.data = data;
    }

    public static Result buildSuccessResult(String msg, Object data) {
        Result res = new Result(Boolean.TRUE, msg, data);
        return res;
    }

    public static Result buildSuccessResult(Object data) {
        Result res = new Result(Boolean.TRUE, "success", data);
        return res;
    }

    public static Result buildFailResult(String msg, Object data) {
        Result res = new Result(Boolean.FALSE, msg, data);
        return res;
    }

    public static Result buildFailResult(Object data) {
        Result res = new Result(Boolean.FALSE, "fail", data);
        return res;
    }

    public boolean isSuc() {
        return suc;
    }

    public void setSuc(boolean suc) {
        this.suc = suc;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
