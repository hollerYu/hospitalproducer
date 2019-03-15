package com.jk.bean;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Document(collection="Specialist") //mongodb 自动生成表
public class SpecialistTwo {
   private String  id;
   private String  name;
   private String  address;
   private String  dataimg;
   private int     fenlei; //分类字段
   private String  portion; //标识字段
}

