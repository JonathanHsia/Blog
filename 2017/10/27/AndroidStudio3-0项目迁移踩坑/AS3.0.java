1.升级IDE
2.替换gradle-wrapper.properties文件中的distributionUrl=http://odqc1qfgd.bkt.clouddn.com/gradle-4.1-all.zip
此处先进行下载,然后放到七牛云中,防止墙的问题
3.替换最外层的build.gradle中的gradle插件版本到3.0.0

1.已经冲突AndResGuard资源压缩

2.me.tatarka.retrolambda插件 lambda表达式的插件异常问题

3.com.neenbedankt.gradle.plugins:android-apt:1.8 替换为官方的annotationProcessor
（Error:Cannot choose between the following configurations of project :mylibrary:）
报错:
Error:Cannot choose between the following configurations of project :mylibrary:
- debugApiElements
- debugRuntimeElements
- releaseApiElements
- releaseRuntimeElements
  All of them match the consumer attributes:
解决
//1.在project的build.gradle中删除
classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
//2.在module的build.gradle中删除
apply plugin: 'android-apt'
//3.将module的build.gradle文件中的dependency
apt 'com.jakewharton:butterknife-compiler:8.1.0'
//改为
annotationProcessor 'com.jakewharton:butterknife-compiler:8.1.0'

4.输出文件名的定义格式
（Cannot set the value of read-only property 'outputFile' ）
报错
Error:(56, 0) Cannot set the value of read-only property 'outputFile' for ApkVariantOutputImpl_Decorated{apkData=Main{type=MAIN, fullName=debug, filters=[]}} of type com.android.build.gradle.internal.api.ApkVariantOutputImpl.
<a href="openFile:D:\eclipseCode\ipay-android\xinlebao\build.gradle" rel="external nofollow" >Open File</a>​
解决 ：修改文件名代码请这样写
android.applicationVariants.all { variant ->
        variant.outputs.all {
          outputFileName = "xinlebao_${defaultConfig.versionName}_${releaseTime()}.apk"
        }
      }

5.多版本输出的定义异常问题


6.最低版本的BuildTools版本和Support包的版本

7.总依赖下载地址(增加google()的依赖下载地址)

8.统一子项目中的gradle的版本

9.Android dependency 'com.android.support:support-v4' has different version for the compile (23.0.0) and runtime (26.0.2) classpath. You should manually set the same version via DependencyResolution

10.aapt2问题
报错
Error:java.util.concurrent.ExecutionException: com.android.tools.aapt2.Aapt2Exception: AAPT2 error: check logs for details
解决：在gradle.properties中关闭APPT2 编译
android.enableAapt2=false
注：如果是eclipse转到as上的项目，可能没有gradle.properties文件，请在项目根目录中手动创建

11.引用百分比布局导致的包含旧版本的百分比布局,官方废弃推荐使用约束布局
https://github.com/JulienGenoud/android-percent-support-lib-sample

12.谷歌数据分析服务,依赖support包的23.0.0版本,会导致同步异常的问题

13.依赖导入不了的问题?
implementation api 和compile的区别吧~

14.打包异常:
Could not get unknown property 'resourceFile' for task ':app:packageTiger8shopgameRelease' of type com.android.build.gradle.tasks.PackageApplication.
 引入美团热更新引起//美团热更新
//        classpath "com.meituan.robust:gradle-plugin:${ROBUST_VERSION}"
//        classpath "com.meituan.robust:auto-patch-plugin:${ROBUST_VERSION}"
