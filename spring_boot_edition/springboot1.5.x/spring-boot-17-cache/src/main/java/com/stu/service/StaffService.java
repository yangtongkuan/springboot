package com.stu.service;

import com.stu.bean.StaffInfo;
import com.stu.mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @User: @Created by yangtk
 * @Date: @Date 2020/2/18 11:54
 * @To change this template use File | Settings | File Templates.
 */

/**
 * CacheConfig ： 缓存的公共配置部分  例如使用哪个缓存(cacheNames)  使用哪个缓存管理器(cacheManager)等
 * 如果相同属性同时存在时,个例会覆盖公共的属性
 */
@Service
//@CacheConfig(cacheNames = "staff")
public class StaffService {

    // 将自身注入进来 解决查询方法不查询缓存的问题
    @Resource
    private StaffService _self;

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 将方法的运行结果进行缓存；以后再要相同的数据，直接从缓存中获取，不用调用方法；
     * CacheManager管理多个Cache组件的，对缓存的真正CRUD操作在Cache组件中，每一个缓存组件有自己唯一一个名字；
     * <p>
     * 原理：
     * 1、自动配置类；CacheAutoConfiguration
     * 2、缓存的配置类
     * org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.GuavaCacheConfiguration
     * org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration【默认】
     * org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration
     * 3、哪个配置类默认生效：SimpleCacheConfiguration；
     * 4、给容器中注册了一个CacheManager：ConcurrentMapCacheManager
     * 5、可以获取和创建ConcurrentMapCache类型的缓存组件；他的作用将数据保存在ConcurrentMap中；
     * <p>
     * 运行流程：
     *
     * @param id
     * @return
     * @Cacheable： 1、方法运行之前，先去查询Cache（缓存组件），按照cacheNames指定的名字获取；
     * （CacheManager先获取相应的缓存），第一次获取缓存如果没有Cache组件会自动创建。
     * 2、去Cache中查找缓存的内容，使用一个key，默认就是方法的参数；
     * 3. 由于使用时先查询缓存 所以在key的时候不能使用返回结果的参数作为key
     * key是按照某种策略生成的；默认是使用keyGenerator生成的，默认使用SimpleKeyGenerator生成key；
     * SimpleKeyGenerator生成key的默认策略；
     * 如果没有参数；key=new SimpleKey()；
     * 如果有一个参数：key=参数的值
     * 如果有多个参数：key=new SimpleKey(params)；
     * 3、没有查到缓存就调用目标方法；
     * 4、将目标方法返回的结果，放进缓存中
     * @Cacheable标注的方法执行之前先来检查缓存中有没有这个数据，默认按照参数的值作为key去查询缓存， 如果没有就运行方法并将结果放入缓存；以后再来调用就可以直接使用缓存中的数据；
     * <p>
     * 核心：
     * 1）、使用CacheManager【ConcurrentMapCacheManager】按照名字得到Cache【ConcurrentMapCache】组件
     * 2）、key使用keyGenerator生成的，默认是SimpleKeyGenerator
     * 几个属性：
     * cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     * <p>
     * key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     * 编写SpEL； #i d;参数id的值   #a0  #p0  #root.args[0]
     * getEmp[2]
     * <p>
     * keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     * key/keyGenerator：二选一使用;
     * cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     * <p>
     * condition：指定符合条件的情况下才缓存；
     * 1.condition = "#id>0"  ：参数中id 符合条件才会缓存
     * 2.condition = "#a0>1"：第一个参数符合条件的时候才进行缓存
     * 3.condition 只能对参数做出判断 不能结果做出判断
     * condition 不能判断缓存结果 例如condition = "#result != null" 这样获取到返回值的
     * 4. condition 判断参数时，如果参数不符合条件 则不会去缓存中查 直接去执行方法
     * unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     * 1. unless = "#result == null"
     * 2. unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     * 3. 既能对入参进行判断也能对结果进行判断 一般返回的结果进行判断,  决定是否进行缓存
     * 4. unless 判断参数的时候 不管条件是否符合都会先去缓存中查询
     * 总结：
     * condition:条件缓存 一般用来判断参数
     * unless 条件过滤缓存一般用来对结果的筛选
     * sync：是否使用异步模式
     */
    @Cacheable(value = "staff", key = "#id.toString()", unless = "#result==null")
    public StaffInfo getStaff(Long id) {
        System.out.println("查询id为:" + id);
        StaffInfo info = staffMapper.getStaff(id);
        return info;
    }

    /**
     * @CachePut：既调用方法，又更新缓存数据；同步更新缓存 修改了数据库的某个数据，同时更新缓存；
     * 运行时机：
     * 执行调用目标方法 -> 将目标方法结果缓存
     * <p>
     * 测试步骤：
     * 1、查询1号员工；查到的结果会放在缓存中；
     * key：1  value：lastName：张三
     * 2、以后查询还是之前的结果
     * 3、更新1号员工；【lastName:zhangsan；gender:0】
     * 将方法的返回htttp值也放进缓存了；
     * key：传入的employee对象  值：返回的employee对象；
     * 4、查询1号员工？
     * 应该是更新后的员工；
     * key = "#staffInfo.id":使用传入的参数的员工id；
     * key = "#result.id"：使用返回后的id
     */
    @CachePut(/*value = "staff",*/ key = "#result.id")
    public StaffInfo updateStaff(StaffInfo staffInfo) {
        StaffInfo staff_db = _self.getStaff(staffInfo.getId());
        // 自身调用不会查询缓存  会直接执行查询的方法
//        StaffInfo staff_db = this.getStaff(staffInfo.getId());
        if (staff_db != null) {
            staff_db.setEmail(staffInfo.getEmail());
            staff_db.setLastName(staffInfo.getLastName());
            staffMapper.updateStaff(staffInfo);
        }
        return staff_db;
    }

    /**
     * @CacheEvict：缓存清除 key：指定要清除的数据
     * allEntries = true：指定清除这个缓存中所有的数据
     * beforeInvocation = false：缓存的清除是否在方法之前执行
     * 默认代表缓存清除操作是在方法执行之后执行;如果出现异常缓存就不会清除
     * beforeInvocation = true：
     * 代表清除缓存操作是在方法运行之前执行，无论方法是否出现异常，缓存都清除
     */
    @CacheEvict(value = "staff", key = "#id", beforeInvocation = true)
    public void delStaff(Long id) {
//        staffMapper.delStaff(id);
        System.out.println("用户被删除了....");
        int o = 10 / 0;
    }

    // 定义复杂的缓存  每次都会执行方法
    @Caching(
            cacheable = {
                    @Cacheable(key = "#lastName")
            },
            put = {
                    @CachePut(key = "#result.id", unless = "#result==null")
            }
    )
    public StaffInfo searchLastName(String lastName) {
        return staffMapper.searchLastName(lastName);
    }

}
