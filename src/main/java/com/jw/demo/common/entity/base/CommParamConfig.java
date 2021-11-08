package com.jw.demo.common.entity.base;

import java.util.Date;

/**
 * Database Table Remarks:
 *   base.t_comm_param_config: 参数配置表
 *
 * @mbg.generated do_not_delete_during_merge 2021-10-13 17:08:51
 */
public class CommParamConfig {
    /**
     * Database Column Remarks:
     *   base.t_comm_param_config.id: 主键
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   base.t_comm_param_config.name: 参数名称
     */
    private String name;

    /**
     * Database Column Remarks:
     *   base.t_comm_param_config.code: 参数编码
     */
    private String code;

    /**
     * Database Column Remarks:
     *   base.t_comm_param_config.content: 参数内容
     */
    private String content;

    /**
     * Database Column Remarks:
     *   base.t_comm_param_config.status: 状态：1-有效 2-无效
     */
    private Integer status;

    /**
     * Database Column Remarks:
     *   base.t_comm_param_config.create_time: 创建时间
     */
    private Date createTime;

    /**
     * @return the value of base.t_comm_param_config.id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the value for base.t_comm_param_config.id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the value of base.t_comm_param_config.name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the value for base.t_comm_param_config.name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return the value of base.t_comm_param_config.code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the value for base.t_comm_param_config.code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return the value of base.t_comm_param_config.content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the value for base.t_comm_param_config.content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return the value of base.t_comm_param_config.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the value for base.t_comm_param_config.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the value of base.t_comm_param_config.create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the value for base.t_comm_param_config.create_time
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", content=").append(content);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}