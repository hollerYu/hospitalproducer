package com.jk.controller;

import com.jk.bean.Task;
import com.jk.service.SpecialistService;
import com.jk.untils.MyRunnable1;
import com.jk.untils.MyRunnable2;
import com.jk.untils.YouXinConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

@Controller
@RequestMapping("/quartz/task")
public class DynamicTaskController {

    @Autowired
    private YouXinConfiguration youXinConfiguration;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future1;

    private ScheduledFuture<?> future2;

    @Resource
    private SpecialistService specialistService;

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @ResponseBody
    @RequestMapping("/startCron1")
    //@ApiOperation("开始定时任务1")
    public String startCron1() {

        future1 = threadPoolTaskScheduler.schedule(new MyRunnable1(),new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                System.out.println("测试01");
                Date date = new CronTrigger(youXinConfiguration.getCorn1()).nextExecutionTime(triggerContext);
                return date;
            }

        });

        System.out.println("DynamicTask.startCron1()");
        System.out.println("测试03");

        return "startCron1success";

    }

    @ResponseBody
    @RequestMapping("/stopCron1")
    //@ApiOperation("关闭定时任务1")
    public String stopCron1() {
        if (future1 != null) {
            future1.cancel(true);
        }
        System.out.println("DynamicTask.stopCron1()");
        return "stopCron1success";
    }

    Task task1 =new Task();
    @ResponseBody
    @RequestMapping("/startCron2")
    //@ApiOperation("开始定时任务2")
    public String startCron2() {

        future2 = threadPoolTaskScheduler.schedule(new MyRunnable2(),new Trigger(){
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext){
                testupdate(task1);
                return new CronTrigger(youXinConfiguration.getCorn2()).nextExecutionTime(triggerContext);
            }
        });

        System.out.println("1秒刷新一次");
        //System.out.println("DynamicTask.startCron2()");
        //return "startCron2success";
        return "1";
    }


    @RequestMapping("aa")
    @ResponseBody
    public String testupdate(Task task){

        task1=task;
        if(task1 !=null&&task1.getGoTime()!=null){
            System.out.println("发布时间"+task1.getGoTime().getTime());
            System.out.println("系统时间"+System.currentTimeMillis());
        }

        if (task1 !=null&&task1.getGoTime()!=null){
            if (task1.getGoTime().getTime()-System.currentTimeMillis()<=1000  && task1.getGoTime().getTime()-System.currentTimeMillis()>0){
                specialistService.updateStatus(task1.getId());//幂等方法
                System.out.println("发布成功");
            }
        }

        return "1";
    }

    @ResponseBody
    @RequestMapping("/stopCron2")
    //@ApiOperation("关闭定时任务2")
    public String stopCron2() {
        if (future2 != null) {
            future2.cancel(true);
        }
        System.out.println("DynamicTask.stopCron2()");
        //return "stopCron2success";
        return "1";
    }


}
