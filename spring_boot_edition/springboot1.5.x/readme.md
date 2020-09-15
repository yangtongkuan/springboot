## SpringBoot学习路线

### 说明
    @version:1.5.3.RELEASE
    @data: 2019年12月30日21:04:18
### 一.SpringBoot 入门-hello word 

### 二.SpringBoot 入门-config 配置文件详解
    
##### 1.注入data说明  

    (1). 自定义属性,使用@vaule直接注入  
    (2). 将配置文件的属性赋值给实体类,使用@ConfigurationProperties(prefix = "...") 直接注入整个bean  
    (3). 自定义配置文件,使用外部文件注入@ConfigurationProperties(prefix = "item3")@PropertySource("classpath:item3.properties")引入外部文件的注入

##### 2.多个环境配置文件
    
      (1). 开发说明: 格式为application-{profile}.properties 在applicaton.properties 中使用 spring.profiles.active=prefile,
      表明当使用的是什么环境的配置文件
      (2). 打包说明 mvn package -P dev 打包成dev环境下的jar包
      (3). 文件优先级说明: 
          控制台: java -jar --server.port=8086
          file:./config/ (当前项目路径config目录下);
          file:./ (当前项目路径下);
          classpath:/config/ (类路径config目录下);
          classpath:/ (类路径config下)
          结论:同目录下.properties优先级高于.yml;优先级由高到底,高优先级的配置会覆盖低优先级的配置;
          
##### 3.SpringBoot启动banner

> 说明

    1. 在resources下添加banner.tet 即可
    2. 在application.properties中指定banner的路径 banner.location=classpath:CustomizeBanner.txt 
    
### 三.SpringBoot 入门-jdbcTemplate

> 说明    
    
    使用Springboot 集成 jdbcTemplate 实现简单的增删改查 并使用注解事务保证数据提交与回滚

### 四.SpringBoot 入门-jdbcTemplate-data-source

> 说明    
    
    使用Springboot 集成 jdbcTemplate 集成多个数据源
 
### 五.SpringBoot 入门-集成jpa
 
> 说明 
    
    springboot 使用jpa时间简单的增删改查操作。
    其中包括两种方式 1.jpa自动生成查询   2. 使用@Query(value="")注解进行hql查询   

### 六.SpringBoot 入门-集成QueryDSL
 
 > 说明 
    
    springboot 使用QueryDSL 复杂查询
 
### 七.SpringBoot 入门-集成mongodb

> 说明 
    
    springboot 使用mongodb 查询
 
> 方式
    
    1. 使用mongodbTemplate
    2. 继承MongoRepository接口    

### 八.SpringBoot 入门-集成mongodb querydsl 查询 

### 九.SpringBoot 入门-集成 mybatis -xml版

> 说明
    
    使用springboot 集成maybatis 实现简单的增删改查
 
### 十.SpringBoot 入门-集成 mybatis -注解版
 
> 说明
 
    使用注解实现增删改查
    以及使用mybatis的provider:@SelectProvider   @InsertProvider @DeleteProvider  @UpdateProvider 
    
### 十一.SpringBoot 入门 - 使用Scheduled 定时任务    

> 说明
    
    使用@Scheduled 实现定时任务
    fixedRate: 上一次执行开始时间到本次执行的开始时间-时间差
    fixedDelay: 上一次执行结束时间到本次执行的开始时间-时间差
    initialDelay: 第一执行延迟多少毫米后执行
    cron: 表达式 */5 * * * * *  ---> 秒-分-时-日-月-年
    
### 十二.SpringBoot 入门 - 使用异步任务

> 说明      
    
    使用@EnableAsync 标注项目开启异步任务;
    配置了异步任务线程池
        默认情况下，在创建了线程池后，线程池中的线程数为0，当有任务来之后，就会创建一个线程去执行任务，
        当线程池中的线程数目达到corePoolSize后，就会把到达的任务放到缓存队列当中,
        当队列满了，就继续创建线程，当线程数量大于等于maxPoolSize后，开始使用拒绝策略拒绝,由请求的进程继续执行
        项目中暑使用CountDownLatch 模拟线程占用;

### 十三.SpringBoot 入门 - 集成logback日志

> 说明            
    
    1.springboot 集成的是logback 日志实现 
    2.slf4j 是日志的门面,具体的实现由logback或者log4j2决定
    3.为了统一的日志框架管理,日志门面实现了偷梁换柱的功能,只需要将原来的jar排除掉然后引入替代包,具体参考官网说明
    4.大量的日志数据会影响软件的性能,大量的io操作可能会导致软件大大降低性能。 
    5.为了提高服务器的性能,采用异步的方式输出日志,提高吞吐量

### 十四.SpringBoot 入门 - 集成log4j2日志

> 说明       


### 十五.SpringBoot 入门 - 集成rabbitmq消息中间件

> 说明      
    
     * springboot  自动配置
     * 1. RabbitAutoConfiguration
     * 2. 有自动配置了连接工厂 (ConnectionFactory)
     * 3. RabbitProperties中封装了 RabbitMQ的配置
     * 4. RabbitTemplate : 给rabbitmq发送和接受消息;
     * 5. AmqpAdmin:RabbitMQ系统管理功能组件
     *      AmqpAdmin：创建和删除queue , exchange , binding
     * 6. @EnableRabbit + @RabbitListener 监听消息队列中的消息内容

### 十六.SpringBoot 入门 - 集成activemq消息中间件

> 说明      
  
### 十七.SpringBoot 入门 - 集成activemq消息中间件

> 说明     

### 十八.SpringBoot 入门 - 集成swagger2文档插件

> 说明   
    
    使用swagger2生成文档 简化了前后端分离协作性，注意生产环境已经不能启用swagger2 
    1. 生成html文件需要启动很多组件
    2. 线上环境使用swagger2容易造成接口文档暴露

### 十九.SpringBoot 入门 - 集成knife4j接口文档插件

> 说明   
    
    swagger2的ui性能太差劲，对于中国开发者很不友好
    knif4j增加ui界面功能，新增接口文档排序搜索等功能