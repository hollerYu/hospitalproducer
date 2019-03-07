/**
 * <pre>项目名称:weekend_demo 
 * 文件名称:Tree.java 
 * 包名:com.jk.pojo 
 * 创建日期:2018年12月30日下午3:35:29 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */
package com.jk.bean;

import java.io.Serializable;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 项目名称：weekend_demo    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：yjm   
 * 创建时间：2018年12月30日 下午3:35:29    
 * 修改人：yjm    
 * 修改时间：2018年12月30日 下午3:35:29    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
@Data
public class Tree implements Serializable{

	private Integer id;

	private String text;

	private String pid;

	private String iconCls;

	private String href;

	private List nodes;


}
