package springbootapplication.demo.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import springbootapplication.demo.dao.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class TestRedis {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testRedisAddStudent() {
        Student student = new Student();
        student.setName("redis");
        student.setAge(11111);
        this.redisTemplate.opsForValue().set("redisStudent", student);
        Assert.assertEquals(true, redisTemplate.hasKey("redisStudent"));
    }
}
