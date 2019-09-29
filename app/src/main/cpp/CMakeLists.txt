# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.
# 设置所需的最低版本CMake构建本地库
cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.库的名称
        native-lib

        # Sets the library as a shared library.//作为一个共享库
        SHARED

        # Provides a relative path to your source file(s).提供你的源文件的相对路径
        native-lib.cpp
        calculate.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.搜索指定的预构建图书馆和商店作为一个#变量的路径。因为CMake包括系统库搜索路径的#默认情况下,
#您只需要指定的名称#你想添加公共NDK图书馆。CMake验证图书馆存在#之前完成它的构建

find_library( # Sets the name of the path variable.设置path变量的名称
        log-lib

        # Specifies the name of the NDK library that指定NDK库的名
        # you want CMake to locate.你想要CMake定位
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.
#指定库CMake应该链接到目标库中。你可以链接多个库,如库定义在这个构建脚本,预先构建的第三方库,或者系统库

target_link_libraries( # Specifies the target library.
        native-lib

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})