package com.neo.util;


import com.xhg.core.web.exception.BusinessException;
import com.xhg.core.web.vo.ErrorInfo;
import com.xhg.core.web.vo.RequestBean;
import com.xhg.core.web.vo.ResponseBean;
import com.xhg.core.web.vo.RqBody;
import com.xhg.core.web.vo.RsBody;
import com.xhg.core.web.vo.Status;
import org.apache.commons.lang.StringUtils;

public class RqRsUtil {
    private static final String defaultBusiCode = "1";
    private static final String defaultbusiMsg = "操作成功";

    public RqRsUtil() {
    }

    public static <T> ResponseBean<T> getResponseBean() {
        return getResponseBean(null, Status.SUCCESS);
    }

    public static <T> ResponseBean<T> getResponseBean(T data) {
        return getResponseBean(data, Status.SUCCESS);
    }

    public static <T> ResponseBean<T> getResponseBean(Status status) {
        return getResponseBean(null, status, (String)null, (String)null);
    }

    private static <T> ResponseBean<T> getResponseBean(T data, Status status) {
        return getResponseBean(data, status, (String)null, (String)null);
    }

    public static <T> ResponseBean<T> getResponseBean(T data, String busiCode, String busiMsg) {
        return getResponseBean(data, Status.SUCCESS, busiCode, busiMsg);
    }

    public static <T> ResponseBean<T> getResponseBean(T data, Status status, String busiCode, String busiMsg) {
        ResponseBean<T> responseBean = new ResponseBean();
        if (Status.SUCCESS.compareTo(status) == 0 || Status.Bu_SUCCESS.compareTo(status) == 0) {
            RsBody<T> rsBody = getResposeBody(data, busiCode, busiMsg);
            responseBean.setResponseBody(rsBody);
        }

        responseBean.setResult(status);
        return responseBean;
    }

    public static <T> RsBody<T> getResposeBody(T data, String busiCode, String busiMsg) {
        RsBody<T> rsBody = new RsBody();
        rsBody.setData(data);
        rsBody.setCode(busiCode == null ? "1" : busiCode);
        rsBody.setMessage(StringUtils.isBlank(busiMsg) ? "操作成功" : busiMsg);
        return rsBody;
    }

    public static <T> RequestBean<T> getRequestBean(T data) {
        RequestBean<T> requestBean = new RequestBean();
        RqBody<T> body = new RqBody();
        body.setData(data);
        requestBean.setRequestBody(body);
        return requestBean;
    }

    public static <T> T getRequestData(RequestBean<T> requestBean) {
        RqBody<T> body = requestBean.getRequestBody();
        if (null == body) {
            return null;
        } else {
            T data = body.getData();
            return data;
        }
    }

    public static <T> boolean isResponseSuccess(ResponseBean<T> responseBean) {
        if (!"1".equals(responseBean.getCode())) {
            return false;
        } else {
            RsBody<T> body = responseBean.getResponseBody();
            return "1".equals(body.getCode());
        }
    }

    public static <T> ErrorInfo getResponseError(ResponseBean<T> responseBean) {
        if (!"1".equals(responseBean.getCode())) {
            return new ErrorInfo(1, responseBean.getCode(), responseBean.getMessage());
        } else {
            RsBody<T> body = responseBean.getResponseBody();
            return !"1".equals(body.getCode()) ? new ErrorInfo(1, body.getCode(), body.getMessage()) : null;
        }
    }

    public static <T> T getResponseData(ResponseBean<T> responseBean) {
        RsBody<T> body = responseBean.getResponseBody();
        if (null == body) {
            return null;
        } else {
            T data = body.getData();
            return data;
        }
    }

    public static <T> T getSuccessResponseData(ResponseBean<T> responseBean) {
        return getResponseData(responseBean, "", "");
    }

    public static <T> T getResponseData(ResponseBean<T> responseBean, String busiCode, String busiMsg) {
        if (!"1".equals(responseBean.getCode())) {
            throw new BusinessException(StringUtils.isBlank(busiCode) ? responseBean.getCode() : busiCode, StringUtils.isBlank(busiCode) ? responseBean.getMessage() : busiMsg);
        } else {
            RsBody<T> body = responseBean.getResponseBody();
            if (null == body) {
                return null;
            } else if (!"1".equals(body.getCode())) {
                throw new BusinessException(StringUtils.isBlank(busiCode) ? body.getCode() : busiCode, StringUtils.isBlank(busiCode) ? body.getMessage() : busiMsg);
            } else {
                T data = body.getData();
                return data;
            }
        }
    }
}
