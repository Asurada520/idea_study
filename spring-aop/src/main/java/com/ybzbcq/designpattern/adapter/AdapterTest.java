package com.ybzbcq.designpattern.adapter;

import org.springframework.util.StringUtils;

public class AdapterTest {
    public static void main(String[] args) {

        /*类的适配器模式*/
        System.out.println("类的适配器模式");
        TargetAble adapter = new Adapter();
        adapter.method1();
        adapter.method2();

        System.out.println("对象的适配器模式");
        /*对象的适配器模式*/
        Source source = new Source();
        Wrapper wrapper = new Wrapper(source);
        wrapper.method1();
        wrapper.method2();

        /* 接口的适配器模式 */
        System.out.println("接口的适配器模式");
        SourceSub1 sourceSub1 = new SourceSub1();
        SourceSub2 sourceSub2 = new SourceSub2();

        sourceSub1.method1();
        sourceSub1.method2();

        System.out.println();

        sourceSub2.method1();
        sourceSub2.method2();

    }
}
