package cn.smbms.controller;

import cn.smbms.utils.ReturnFormat;

public abstract class BaseController {
    protected Object retContent(int status,Object data) {
        return ReturnFormat.retParam(status, data);
    }
}
