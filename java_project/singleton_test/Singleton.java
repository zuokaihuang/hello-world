package com.example.myapplication;

class Singleton_DLC {

    // dlc 双重检查 第一次加载时会比较慢， 在高并发环境下不合适
    private static volatile Singleton_DLC instance;  // 使用volatile 或多或少对性能有影响, 但是为了程序的正确性，这一点性能可以牺牲

    private Singleton_DLC() {

    }

    public static Singleton_DLC getInstance() {

        if (instance == null) {

            synchronized (Singleton_DLC.class) {
                if (instance == null) {
                    instance = new Singleton_DLC();
                }
            }

        }

        return instance;
    }
}

class Singleten_InnerStatic {

    // 使用了静态内部类， 当 Singleten_InnerStatic 被加载时，并不会初始化 instance，
    // 只有当调用 getInstance时，虚拟机加载 Singleten_InnerStatic_Holder 并初始化 instance.

    private Singleten_InnerStatic() {

    }

    public static Singleten_InnerStatic getInstance() {

        return Singleten_InnerStatic_Holder.instance;
    }

    private static class Singleten_InnerStatic_Holder {
        private static final Singleten_InnerStatic instance = new Singleten_InnerStatic();
    }

}








