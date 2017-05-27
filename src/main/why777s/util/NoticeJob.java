package util;

import entity.OrderStu;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import service.impl.EmployeeServiceImpl;

import java.util.Date;

/**
 * Created by why777s on 2017/5/24.
 */

// 调度作业
public class NoticeJob  {
    private EmployeeServiceImpl employeeService;

    public void setEmployeeService(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }


    public void test(){
        System.out.println(new Date().toString());
    }

}
