#include <jni.h>
#include <string>

/**
 * This function called whenever our native library (.so file) is loaded into
 * memory for th very first time. So I was able to this file using System.loadLibrary
 * statically inside my Application class
 *
 * This will make sure that this function is executed even before the application constructor is
 * involved
 * @param vm
 * @param reserved
 * @return
 */
JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }

    // Find Function class & method id
    jclass functionCls = env->FindClass("com/call/order/Function");
    jmethodID methodId = env->GetStaticMethodID(functionCls, "Call", "(Ljava/lang/String;)V");

    jstring log_msg = env->NewStringUTF("Native JNI_OnLoad Executed"); // prepare log message
    // cal our logging function
    env->CallStaticVoidMethod(functionCls, methodId, log_msg);
    env->DeleteLocalRef(log_msg);

    return JNI_VERSION_1_6;
}