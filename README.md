# mobile.de Task

<b>Idea of this Project :-</b>

The task is to display the images in UI. Todo that I have read the source
API(https://m.mobile.de/svc/a/328139645) using RetroFit REST client. Then,fetched images array of
URI's and displayed the images in UI using GRID layout model.

Upon clicking any selected image, app will navigate to second screen and display the bigger size of
selected image.

<b>Design</b>:- Implemented by following MVVM Clean architecture by using Coroutines, HILT
dependency injection & Retrofit.

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/145054305-0434e5a0-86b0-41fb-839f-ef58d1dffc12.png" width="500" height="1000">
</p>

<p align="center">
<img src="https://user-images.githubusercontent.com/16395251/145054451-8e5b523c-449c-4f33-990c-778161e39de4.png" width="500" height="1000">
</p>

<h1>Release Notes:-</h1> 

1) Developed Application by using Android JetPack Components like HILT, Navigation & UI, ViewModel ,
   Livedata, DataBinding and Lifecycle-Aware Components.

2) To Update data to RecyclerView adapter used DiffUtil logic. It’s an is a utility class that can
   calculate the difference between two lists and output a list of update operations that converts
   the first list into the second one.

3) Used "com.intuit.ssp:ssp-android:1.0.6" & "com.intuit.sdp:sdp-android:1.0.6" libraries

SSP : An android SDK that provides a new size unit - ssp (scalable sp). This size unit scales with
the screen size based on the sp size unit (for texts). It can help Android developers with
supporting multiple screens.

SDP : An android SDK that provides a new size unit - sdp (scalable dp). This size unit scales with
the screen size. It can help Android developers with supporting multiple screens.

4) Used "Data Binding" for faster access and performance improvement. The Data Binding Library is a
   support library that allows you to bind UI components in your layouts to data sources in your app
   using a declarative format rather than programmatically.

5) Used "com.github.bumptech.glide:glide"
   By using of Glide library we are loading images.And it's an open source library that is used for
   efficiently loading and caching of images.

6) Used Android Coroutines. It mainly simplify code that executes asynchronously & help to manage
   long-running tasks in background without block the main thread.

7) Developed application by using HILT dependency injection. It's an opinionated dependency
   injection library for Android that reduces the boilerplate of using manual DI in your project.

8) Used Retrofit to make API calls.

9) Added Unit-tests for Business logic. Such as ViewModel and Repository.

10) Added Unit-tests for Retrofit Service API's by mocking OkHttp MockWebServer.

11) Added comments for fun's in Kdoc format.