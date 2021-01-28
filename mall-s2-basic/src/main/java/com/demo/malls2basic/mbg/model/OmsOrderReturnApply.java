package com.demo.malls2basic.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OmsOrderReturnApply implements Serializable {
    private Long id;

    /**
     * 订单id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="订单id")
    private Long orderId;

    /**
     * 收货地址表id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="收货地址表id")
    private Long companyAddressId;

    /**
     * 退货商品id
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="退货商品id")
    private Long productId;

    /**
     * 订单编号
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="订单编号")
    private String orderSn;

    /**
     * 申请时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="申请时间")
    private Date createTime;

    /**
     * 会员用户名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="会员用户名")
    private String memberUsername;

    /**
     * 退款金额
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="退款金额")
    private BigDecimal returnAmount;

    /**
     * 退货人姓名
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="退货人姓名")
    private String returnName;

    /**
     * 退货人电话
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="退货人电话")
    private String returnPhone;

    /**
     * 申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="申请状态：0->待处理；1->退货中；2->已完成；3->已拒绝")
    private Integer status;

    /**
     * 处理时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="处理时间")
    private Date handleTime;

    /**
     * 商品图片
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="商品图片")
    private String productPic;

    /**
     * 商品名称
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="商品名称")
    private String productName;

    /**
     * 商品品牌
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="商品品牌")
    private String productBrand;

    /**
     * 商品销售属性：颜色：红色；尺码：xl;
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="商品销售属性：颜色：红色；尺码：xl;")
    private String productAttr;

    /**
     * 退货数量
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="退货数量")
    private Integer productCount;

    /**
     * 商品单价
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="商品单价")
    private BigDecimal productPrice;

    /**
     * 商品实际支付单价
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="商品实际支付单价")
    private BigDecimal productRealPrice;

    /**
     * 原因
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="原因")
    private String reason;

    /**
     * 描述
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="描述")
    private String description;

    /**
     * 凭证图片，以逗号隔开
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="凭证图片，以逗号隔开")
    private String proofPics;

    /**
     * 处理备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="处理备注")
    private String handleNote;

    /**
     * 处理人员
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="处理人员")
    private String handleMan;

    /**
     * 收货人
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="收货人")
    private String receiveMan;

    /**
     * 收货时间
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="收货时间")
    private Date receiveTime;

    /**
     * 收货备注
     *
     * @mbggenerated
     */
    @ApiModelProperty(value="收货备注")
    private String receiveNote;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getReturnAmount() {
        return returnAmount;
    }

    public void setReturnAmount(BigDecimal returnAmount) {
        this.returnAmount = returnAmount;
    }

    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    public String getReturnPhone() {
        return returnPhone;
    }

    public void setReturnPhone(String returnPhone) {
        this.returnPhone = returnPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductAttr() {
        return productAttr;
    }

    public void setProductAttr(String productAttr) {
        this.productAttr = productAttr;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public BigDecimal getProductRealPrice() {
        return productRealPrice;
    }

    public void setProductRealPrice(BigDecimal productRealPrice) {
        this.productRealPrice = productRealPrice;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProofPics() {
        return proofPics;
    }

    public void setProofPics(String proofPics) {
        this.proofPics = proofPics;
    }

    public String getHandleNote() {
        return handleNote;
    }

    public void setHandleNote(String handleNote) {
        this.handleNote = handleNote;
    }

    public String getHandleMan() {
        return handleMan;
    }

    public void setHandleMan(String handleMan) {
        this.handleMan = handleMan;
    }

    public String getReceiveMan() {
        return receiveMan;
    }

    public void setReceiveMan(String receiveMan) {
        this.receiveMan = receiveMan;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getReceiveNote() {
        return receiveNote;
    }

    public void setReceiveNote(String receiveNote) {
        this.receiveNote = receiveNote;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", companyAddressId=").append(companyAddressId);
        sb.append(", productId=").append(productId);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", createTime=").append(createTime);
        sb.append(", memberUsername=").append(memberUsername);
        sb.append(", returnAmount=").append(returnAmount);
        sb.append(", returnName=").append(returnName);
        sb.append(", returnPhone=").append(returnPhone);
        sb.append(", status=").append(status);
        sb.append(", handleTime=").append(handleTime);
        sb.append(", productPic=").append(productPic);
        sb.append(", productName=").append(productName);
        sb.append(", productBrand=").append(productBrand);
        sb.append(", productAttr=").append(productAttr);
        sb.append(", productCount=").append(productCount);
        sb.append(", productPrice=").append(productPrice);
        sb.append(", productRealPrice=").append(productRealPrice);
        sb.append(", reason=").append(reason);
        sb.append(", description=").append(description);
        sb.append(", proofPics=").append(proofPics);
        sb.append(", handleNote=").append(handleNote);
        sb.append(", handleMan=").append(handleMan);
        sb.append(", receiveMan=").append(receiveMan);
        sb.append(", receiveTime=").append(receiveTime);
        sb.append(", receiveNote=").append(receiveNote);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}