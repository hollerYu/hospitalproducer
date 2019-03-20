package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Data
public class Vip {

    private Integer id;

    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd")
    private Date startTime;

    @JsonFormat(timezone = "GTM+8",pattern = "yyyy-MM-dd")
    private Date endTime;

    private Integer userId;

    private String sendEmail;
    //临时字段
    private String userName;
}
