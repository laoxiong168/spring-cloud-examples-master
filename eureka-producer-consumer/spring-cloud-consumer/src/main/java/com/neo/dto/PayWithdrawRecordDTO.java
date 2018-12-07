package com.neo.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.NotEmpty;

public class PayWithdrawRecordDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pageNum;
    private Integer pageSize;

    /**
     * 提现流水号
     */
    @NotEmpty(message = "流水号不能为空")
    private String withdrawNo;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getWithdrawNo() {
        return withdrawNo;
    }

    public void setWithdrawNo(String withdrawNo) {
        this.withdrawNo = withdrawNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getWithdrawalPlatform() {
        return withdrawalPlatform;
    }

    public void setWithdrawalPlatform(Integer withdrawalPlatform) {
        this.withdrawalPlatform = withdrawalPlatform;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getWithdrawStatus() {
        return withdrawStatus;
    }

    public void setWithdrawStatus(Integer withdrawStatus) {
        this.withdrawStatus = withdrawStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountsReceivable() {
        return accountsReceivable;
    }

    public void setAccountsReceivable(String accountsReceivable) {
        this.accountsReceivable = accountsReceivable;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }

    public Integer getCreatedUserId() {
        return createdUserId;
    }

    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    public String getUpdatedUserName() {
        return updatedUserName;
    }

    public void setUpdatedUserName(String updatedUserName) {
        this.updatedUserName = updatedUserName;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    public Integer getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(Integer isCheck) {
        this.isCheck = isCheck;
    }

    public String getTranscationNum() {
        return transcationNum;
    }

    public void setTranscationNum(String transcationNum) {
        this.transcationNum = transcationNum;
    }

    /**
     * 用户订单号
     */
    private String customerNo;

    /**
     * 支付类型 1：连连支付 2：微信支付
     */
    private Integer paymentType;

    /**
     * 提现平台：1：用户 2：骑手 3：回收员
     */
    private Integer withdrawalPlatform;

    /**
     * 提现金额
     */
    private BigDecimal amount;

    /**
     * 提现状态  1：待审核 2：提现处理中 3：提现失败 4：提现成功 5：拒绝提现
     */
    private Integer withdrawStatus;

    /**
     * 用户手机号
     */
    private String phone;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 收款账户：如果是连连支付则为银行卡号，如果是微信支付则为微信openid
     */
    private String accountsReceivable;

    /**
     * 收款人真实姓名（选填）
     */
    private String realName;

    /**
     * 订单描述
     */
    private String orderRemark;

    /**
     * 创建人ID
     */
    private Integer createdUserId;

    /**
     * 更新人ID
     */
    private Integer updatedUserId;

    /**
     * 创建人姓名
     */
    private String createdUserName;

    /**
     * 更新人姓名
     */
    private String updatedUserName;


    /**
     * 审核备注：如果没有触发审核或者还没有进行审核
     */
    private String checkRemark;

    /**
     * 是否需要审核：1 需要 2 不需要
     */
    private Integer isCheck;

    /**
     * 第三方交易流水号
     */
    private String transcationNum;


}

