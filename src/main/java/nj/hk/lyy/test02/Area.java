/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package nj.hk.lyy.test02;

import java.util.Date;

/**
 * 区域Entity
 * @author ThinkGem
 * @version 2013-05-15
 */
public class Area {
	private Long id;
	private Long parent_id;
	private String parent_code;
	private String parent_ids;
	private String name;
	private String sort;
	private String code;
	private String type;
	private String create_by;
	private Date update_by;
	private String remarks;
	private String del_flag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	public String getParent_code() {
		return parent_code;
	}
	public void setParent_code(String parent_code) {
		this.parent_code = parent_code;
	}
	public String getParent_ids() {
		return parent_ids;
	}
	public void setParent_ids(String parent_ids) {
		this.parent_ids = parent_ids;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public Date getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(Date update_by) {
		this.update_by = update_by;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}
	
	

//	`id` BIGINT(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
//	`parent_id` BIGINT(11) NULL DEFAULT NULL COMMENT '父级编号',
//	`parent_code` VARCHAR(100) NULL DEFAULT NULL COMMENT '父级code' COLLATE 'utf8_bin',
//	`parent_ids` VARCHAR(2000) NULL DEFAULT NULL COMMENT '所有父级编号' COLLATE 'utf8_bin',
//	`name` VARCHAR(100) NOT NULL COMMENT '名称' COLLATE 'utf8_bin',
//	`sort` DECIMAL(10,0) NULL DEFAULT NULL COMMENT '排序',
//	`code` VARCHAR(100) NULL DEFAULT NULL COMMENT '区域编码' COLLATE 'utf8_bin',
//	`type` CHAR(1) NULL DEFAULT NULL COMMENT '区域类型 1:省 2：市 3：区' COLLATE 'utf8_bin',
//	`create_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '创建者' COLLATE 'utf8_bin',
//	`create_date` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
//	`update_by` VARCHAR(64) NULL DEFAULT NULL COMMENT '更新者' COLLATE 'utf8_bin',
//	`update_date` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
//	`remarks` VARCHAR(255) NULL DEFAULT NULL COMMENT '备注信息' COLLATE 'utf8_bin',
//	`del_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '删除标记' COLLATE 'utf8_bin',
}