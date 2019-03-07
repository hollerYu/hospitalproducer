/**
 * <pre>项目名称:Linuxs_demo 
 * 文件名称:returnPage.java 
 * 包名:com.jk.yjm.util 
 * 创建日期:2018-11-29上午11:16:19 
 * Copyright (c) 2018, All Rights Reserved.</pre> 
 */  
package com.jk.untils;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * <pre>项目名称：Linuxs_demo    
 * 类名称：returnPage    
 * 类描述：    
 * 创建人：yjm   
 * 创建时间：2018-11-29 上午11:16:19    
 * 修改人：yjm    
 * 修改时间：2018-11-29 上午11:16:19    
 * 修改备注：       
 * @version </pre>    
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReturnPage {
	
	private Integer total;
	
	private List rows;

}
