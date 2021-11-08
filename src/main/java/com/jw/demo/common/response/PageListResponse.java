//package com.jw.demo.common.response;
//
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * 列表查询类响应实体
// *
// * @author hongyuhao
// * @version 0.0.1
// */
//public class PageListResponse<T> extends Response {
//    /**
//     * uuid
//     */
//    private static final long serialVersionUID = 3579336554342949826L;
//
//    /**
//     * 返回结果列表
//     */
//    private List<T> list = Collections.emptyList();
//    /**
//     * 分页信息
//     */
//    private PageTurn pageTurn;
//
//    /**
//     * 获取返回结果列表
//     *
//     * @return 返回结果列表
//     */
//    public List<T> getList() {
//        return list;
//    }
//
//    /**
//     * 设置返回结果列表
//     *
//     * @param list 返回结果列表
//     */
//    public void setList(List<T> list) {
//        this.list = list;
//    }
//
//    /**
//     * 获取分页信息
//     *
//     * @return 分页信息
//     */
//    public PageTurn getPageTurn() {
//        return pageTurn;
//    }
//
//    /**
//     * 设置分页信息
//     *
//     * @param pageTurn 分页信息
//     */
//    public void setPageTurn(PageTurn pageTurn) {
//        this.pageTurn = pageTurn;
//    }
//
//    /**
//     * 重写tostring
//     *
//     * @return 相应结果json字符串
//     */
//    @Override
//    public String toString() {
//        return super.toString();
//    }
//
//}
