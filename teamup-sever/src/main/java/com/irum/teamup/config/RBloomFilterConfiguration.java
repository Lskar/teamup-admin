package com.irum.teamup.config;


/**
 * 布隆过滤器配置
 */
//@Configuration
//public class RBloomFilterConfiguration {
//
//    /**
//     * 防止用户注册查询数据库的布隆过滤器
//     */
////    @Bean
////    public RBloomFilter<String> userRegisterCachePenetrationBloomFilter(RedissonClient redissonClient) {
////        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("userRegisterCachePenetrationBloomFilter");
////        cachePenetrationBloomFilter.tryInit(100000000L, 0.001);
////        return cachePenetrationBloomFilter;
////    }
//}