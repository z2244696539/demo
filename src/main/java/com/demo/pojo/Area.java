package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(description = "area")
@TableName("area")
public class Area {

	private static final long serialVersionUID = 1L;


	@ApiModelProperty(value = "id")
	@TableId(type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "名称")
	@TableField("area_name")
	private String areaName;

	@ApiModelProperty(value = "包含城市")
	@TableField(exist = false)
	private List<City> areaCity;

	@ApiModelProperty(value = "地址")
	@TableField("address")
	private List<String> address;

	@ApiModelProperty(value = "创建时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("create_time")
	private Date createTime;

	@ApiModelProperty(value = "更新时间")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@TableField("update_time")
	private Date updateTime;

	@ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
	@JsonIgnore
	@TableLogic
	@TableField("is_deleted")
	private Integer isDeleted;
}



