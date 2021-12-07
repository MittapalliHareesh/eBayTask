# mobile.de Task


<b>Idea of this Project :-</b>
    ---- -


<b>Design</b>:- Implemented by following MVVM Clean architecture by using Coroutines , HILT dependancy injection & Retrofit.

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/145054305-0434e5a0-86b0-41fb-839f-ef58d1dffc12.png" width="500" height="1000">
</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/145054451-8e5b523c-449c-4f33-990c-778161e39de4.png" width="500" height="1000">
</p>

<h1>Release Notes:-</h1> 

1) Developed Application by using Android JetPack Components like HILT, Navigation & UI, ViewModel , Livedata, DataBinding and Lifecycle-Aware Components.

2) Used "com.intuit.ssp:ssp-android:1.0.6" & "com.intuit.sdp:sdp-android:1.0.6" libraries

SSP : An android SDK that provides a new size unit - ssp (scalable sp). This size unit scales with the screen size based on the sp size unit (for texts). It can help Android developers with supporting multiple screens.

SDP : An android SDK that provides a new size unit - sdp (scalable dp). This size unit scales with the screen size. It can help Android developers with supporting multiple screens.

3) Used "Data Binding" for faster access and performance improvement.
The Data Binding Library is a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.

4) Used "com.github.bumptech.glide:glide"
By using of Glide library we are loading images.And it's an open source library that is used for efficiently loading and caching of images.

5) Used Android Coroutines. It mainly simplify code that executes asynchronously & help to manage long-running tasks in background without block the main thread. 

6) Developed application by using HILT dependancy injection. It's an opinionated dependency injection library for Android that reduces the boilerplate of using manual DI in your project.

7) Used Retrofit to make API calls.

8) Added Unit-tests for Busniess logic. Such as ViewModel and Repository.

9) Added Unit-tests for Retrofit Service API's by mocking OkHttp MockWebServer.

10) Added comments for fun's in Kotlin Standared Document (Kdoc) format.
