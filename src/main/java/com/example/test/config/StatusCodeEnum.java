package com.example.test.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 接口返回状态枚举
 *
 * @author huangyf
 */
@Getter
@AllArgsConstructor
public enum StatusCodeEnum {

    OK(200, "OK"),
    PROCESSING(102, "处理中"),
    ALREADY_REPORTED(208, "已重复/已存在"),
    PERMISSION_DENIED(400, "权限不足"),
    UNAUTHORIZED(401, "授权失败/失效"),
    PAYMENT_REQUIRED(402, "缺少必须参数"),
    FORBIDDEN(403, "禁用（包含非法字符）"),
    NOT_FOUND(404, "资源不存在"),
    REQUEST_TIMEOUT(408, "请求过时/超时"),
    PRECONDITION_FAILED(412, "参数错误"),
    REQUEST_PARAM_TOO_LONG(413, "请求参数过长"),
    EXPECTATION_FAILED(417, "期望错误/逻辑错误"),
    SIGN_FAILURE(420, "签名错误/验签失败"),
    INTERNAL_SERVER_ERROR(500, "其他错误"),

    /* 自定义code > 10000 */
    FLOW_LIMITING(10010, "限流"),
    SERVICE_FAILED(10011, "微服务异常"),
    NOT_FOUND_USER(10020, "账号不存在"),
    PASSWORD_FAILED(10021, "密码不正确"),
    INVALID_ACCOUNT(10023, "账号已失效"),
    NOT_FOUND_DEPT(10024, "部门不存在"),
    INVALID_DEPT(10025, "部门已失效"),
    REPEAT_DEPT(10026, "部门已存在"),
    INVALID_ROLE(10027, "用户角色异常"),
    IMPORT_USER_FAIL(10027, "导入员工失败"),
    USER_RETREAT(10030, "该账号已在其他地方登录，如非本人操作，请修改密码"),
    CALL_BINDING_REQUEST_FAILED(10040, "预约失败，请重新预约"),
    NOT_VALIDATE_PHONE(10050, "请先进行手机验证"),
    NOT_VALIDATE_CERTIFICATION(10051, "请先进行实名认证"),
    SEND_CODE_FAIL(10052, "发送验证码失败"),
    CHECK_CODE_FAIL(10053, "验证码错误"),
    CHECK_CODE_NULL(10054, "验证码失效"),
    NOT_EXECUTE_CONTRACT(10060, "支付租金后可退租"),
    NOT_FOUND_BILL(10070, "账单不存在"),
    PAID_BILL(10071, "账单已缴费，请务重复缴费"),
    SIGNED_WAIT(10080, "已申请签约,请等待房东处理"),
    NEXT_PAY_TIME_FAILED(10090, "下期交租日不正确"),
    CONTRACT_SIGN_REJECT(10100, "房源信息变更，自动签约/补录失败"),
    CHANGE_PERMISSION(10110, "权限被更改，请重新登录"),
    CHANGE_PHONE(10111, "修改成功，请使用新手机号重新登录"),
    LOGIN_INVALID(10112, "登陆失效，请重新登录"),
    NOT_EXIT_PHONE(10120, "手机号不存在"),
    PHONE_REPEAT(10121, "手机号重复"),
    NOT_OPERATE_FREQUENTLY(10130, "请勿频繁操作"),
    BAD_PEOPLE(10140, "经核查，该租客存在不良记录，轻租提示您需谨慎签约"),
    OVER_CONPON_MAX_MONEY(10150, "卡券面值超过系统预设值,非法操作！"),
    HOUSE_ALREADY_SIGNED(10160, "该房源已出租"),
    VISITOR_ALREADY_EXIT(10601, "请等待访客确认或该访客已存在!"),
    IMPERFECT_DATA(10602, "房源信息不完整，请先编辑再发布"),
    NOT_AUDITING_STATUS(10603, "该房源并没有在审核中"),
    INFORMATION_MODIFICATION(10700, "签约信息已修改，请重新签约"),
    CONTRACTOR_INFORMATION(240006, "签约人信息有误，请修改后重新签约"),
    IMPERFECT_INFORMATION(10701, "信息错误或者信息不完善"),
    CONTRACT_NOT_PERFECT(10702, "您有合同没有签完"),
    NOT_FOUND_CONTACTS(10801, "联系人不存在"),
    INVALID_CONTACTS(10802, "联系人已失效"),
    NOT_FOUND_CUSTOMER(10901, "客户不存在"),
    INVALID_CUSTOMER(10902, "客户已失效"),
    PINYIN_EXCEPTION(11000, "拼音转化异常"),
    MESSAGE_INVALID_WITHDRAW(11001, "消息已撤回或者已失效"),
    REFUND_MONEY_WRONG(11002, "退款金额不可大于订单金额"),
    CHANCE_STAGE_IN_AFTER(12001, "当前阶段不可修"),
    CHANCE_STAGE_INVALID(12002, "无效的销售阶段"),
    CHANCE_DATE_INVALID(12003, "无效日期"),
    EMPLOYEE_IN_TEMPORARY(12004, "由于该员工在临时部门或者该员工不存在,您暂时无法操作"),
    PRODUCTS_NOT_EMPTY(12005, "请选择产品"),
    HOUSE_NOT_NULL(12006, "请选择房源"),
    COMMUNITY_BIND_REPEAT(13001, "已绑定无需添加"),
    COMMUNITY_LOGIN_FAIL(13002, "登录错误"),
    COMMUNITY_HOUSE_REPEAT(13003, "房源名称重复"),
    COMMUNITY_NOTCAN_ME(13003, "不能添加自己"),
    COMMUNITY_FOLLOW_REPEAT(13003, "不能重复添加"),
    COMMUNITY_INVALID_BILL(13004, "无效账单"),
    COMMUNITY_PAYED_BILL(13005, "已支付"),
    COMMUNITY_DEVICE_NOT_FIND(13006, "请扫描正确的设备码"),
    COMMUNITY_DEVICE_BIND_ED(13007, "设备已存在，请勿重复绑定"),
    COMMUNITY_DEVICE_BIND_ORDER(13008, "该设备已被其他房源绑定"),
    COMMUNITY_DEVICE_BIND_ONE_L(13009, "每套房源只能绑定1个智能门锁"),
    COMMUNITY_DEVICE_BIND_ONE_W(13010, "每套房源只能绑定1个智能水表"),
    COMMUNITY_DEVICE_BIND_ONE_A(13011, "每套房源只能绑定1个智能电表"),
    COMMUNITY_DEVICE_LOCK_TYPE_ERROR(13012, "门锁类型错误"),
    COMMUNITY_FINGER_NOT_FIND(13013, "无效指纹"),
    COMMUNITY_FINGER_ADD_ERROR(13014, "请先安装门锁"),
    COMMUNITY_UNBIND_ERROR(13015, "该设备已被物业系统绑定请联系物业处理解绑"),
    COMMUNITY_PMS_BILL_REPEAT(13016, "物业账单已支付，请勿重复推送"),
    TEMP_INVALID(14001, "该房屋开锁权已失效"),
    RENT_ARREARS(16001, "您有租房费尚未结清,结算完毕才可以发起转租"),
    UNABLE_TO_RENT_OUT(16002, "退租日无法转租"),
    DONOT_TO_OWN(16003, "不允许转租给自己"),
    ONCE_TO_EVERYDAY(16004, "每天最多只能对同一用户发起一次转租"),
    NOT_AIM(16005, "您不是对方邀请转租的租客"),
    CHOICE_TENANCY(16006, "请选择租期"),
    SUBLET_invitation_INVALID(16007, "该转租邀请已失效"),
    RENTER_CANCEL_SUBLET(16008, "签约失败,租客已取消转租"),
    LANDLORD_AGREE_SUBLET(16009, "取消签约失败，房东已同意转租"),
    SUBLET_INVALID(16010, "转租已失效"),
    ;

    private int code;
    private String name;

    public static StatusCodeEnum from(Integer code) {
        if (code == null) {
            return null;
        }
        for (StatusCodeEnum e : StatusCodeEnum.values()) {
            if (e.code == code) {
                return e;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        StatusCodeEnum e = from(code);
        return e == null ? "" : e.getName();
    }
}
