package com.us.improve.function;

/**
 * @ClassName BusinessConsumer
 * @Desciption TODO
 * @Author loren
 * @Date 2019/6/21 1:09 AM
 * @Version 1.0
 **/
public class BusinessConsumer extends AbstractConsumer<String, Message> {

    @Override
    public void consume() {
        super.consume(new Consume() {
            @Override
            public void preConsume() {

            }

            @Override
            public void doConsume() {

            }

            @Override
            public void afterConsume() {

            }
        });
    }

}
