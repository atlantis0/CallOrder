Method
======

There is the option of declaring a native function that can be executed whenever its loaded for the very first time. This can be achieved by loading the native library statically in the Application's class. See below

![Native Load](native_load.png)

Then proceed to write this function in C 

![Native JNI Load](native_jni_load_call.png)

 