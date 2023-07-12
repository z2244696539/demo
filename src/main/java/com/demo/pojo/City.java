package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel(description = "city")
@TableName("city")
public class City {

	private static final long serialVersionUID = 1L;


	@ApiModelProperty(value = "id")
	@TableId(type = IdType.AUTO)
	private Long id;

	@ApiModelProperty(value = "名称")
	@TableField("city_name")
	private String cityName;

	@ApiModelProperty(value = "逻辑删除(1:已删除，0:未删除)")
	@JsonIgnore
	@TableLogic
	@TableField("is_deleted")
	private Integer isDeleted;
}



