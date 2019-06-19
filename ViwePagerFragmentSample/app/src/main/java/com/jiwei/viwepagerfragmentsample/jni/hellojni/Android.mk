LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)
 
LOCAL_MODULE := hello
LOCAL_LDFLAGS := -Wl,--build-id
LOCAL_SRC_FILES := \
	E:\AndroidStudioProject\ViwePagerFragmentSample\app\src\main\java\com\jiwei\viwepagerfragmentsample\jni\hellojni\Hello.cpp \
 
LOCAL_C_INCLUDES += E:\AndroidStudioProject\ViwePagerFragmentSample\app\src\debug\java\com\jiwei\viwepagerfragmentsample\jni\hellojni
LOCAL_C_INCLUDES += E:\AndroidStudioProject\ViwePagerFragmentSample\app\src\main\java\com\jiwei\viwepagerfragmentsample\jni\hellojni
 
include $(BUILD_SHARED_LIBRARY)