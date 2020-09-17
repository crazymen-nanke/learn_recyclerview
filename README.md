## Recyclerview的学习：

这是一个学习RecyclerView的Demo。



项目地址：[https://github.com/crazymen-nanke/learn_recyclerview](https://github.com/crazymen-nanke/learn_recyclerview)



因为之前RecyclerView的依赖包在AndroidX上面已经不可以使用了，所以我们需要使用最新的依赖包。

查阅官方AndroidX的工件映射表：[https://developer.android.google.cn/jetpack/androidx/migrate/artifact-mappings](https://developer.android.google.cn/jetpack/androidx/migrate/artifact-mappings)

![image-20200917184541540](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20200917184541540.png)

我添加依赖的时候犯了错误。直接复制后面的新工件到模块的build.gradle中会出现错误。



原因：

没有指定RecyclerView的版本号。

解决办法：

在模块下面的build.gradle中修改依赖包为：

````java
implementation 'androidx.recyclerview:recyclerview:1.0.0'
````



之后可能出现引用不了RecyclerView的问题。此时需要我们必须确保 Configuration：implementation。

![image-20200917184052302](https://zl.crazymen.cn/images/image-20200917184052302.png)

![image-20200917183939078](https://zl.crazymen.cn/images/image-20200917183939078.png)



项目树：

![image-20200917205806528](https://zl.crazymen.cn/images/image-20200917205806528.png)





设置布局管理器：线性布局管理器默认是垂直排列的，实现后的效果与LIstView相似

```java
 LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        binding.recyclerView.setLayoutManager(manager);
```



![image-20200917205607565](https://zl.crazymen.cn/images/image-20200917205607565.png)



设置布局管理器：线性布局管理器默认是垂直排列的，修改排列方向后实现水平排列效果

```java
 LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
        //设置RecyclerView布局的排列方向
		manager.setOrientation(RecyclerView.HORIZONTAL);
        binding.recyclerView.setLayoutManager(manager);
```



![image-20200917205440875](https://zl.crazymen.cn/images/image-20200917205440875.png)



设置布局管理器：使用StaggeredGridLayoutManager实现瀑布流排列效果

```java
 // 创建StaggeredGridLayoutManager实例，实现瀑布流效果
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        // 绑定布局管理器
        binding.recyclerView.setLayoutManager(layoutManager);
```



![image-20200917205013018](https://zl.crazymen.cn/images/image-20200917205013018.png)

