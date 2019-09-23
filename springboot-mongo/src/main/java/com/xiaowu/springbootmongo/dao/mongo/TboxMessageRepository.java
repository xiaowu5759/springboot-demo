package com.xiaowu.springbootmongo.dao.mongo;

import com.xiaowu.springbootmongo.entity.TboxMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @createBy XiaoWu
 * @date 2019/9/9 14:04
 */
@Repository
public interface TboxMessageRepository extends MongoRepository<TboxMessage,Integer> {

}
