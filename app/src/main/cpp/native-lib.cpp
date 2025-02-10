#include <jni.h>
#include <string>
#include <android/log.h>

#define APP_NAME "Call-Order-Native"

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
    JNIEnv* env;
    if (vm->GetEnv(reinterpret_cast<void**>(&env), JNI_VERSION_1_6) != JNI_OK) {
        return JNI_ERR;
    }
    __android_log_print(ANDROID_LOG_VERBOSE, APP_NAME,  "Native JNI_OnLoad Executed");
    return JNI_VERSION_1_6;
}