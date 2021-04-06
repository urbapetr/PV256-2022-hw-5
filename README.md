# Homework 5

1. Follow instructions in [wiki](https://gitlab.fi.muni.cz/grp-pv256/wiki/wikis/home)
and proceed with forking this repo
2. Implement unit tests in `MainActivityViewModdelTest`
3. Implement instrumentation tests in `MainActivityTest`
   * You may need to implement more than bodies of empty test functions
4. Submit changes into a **submit** branch and push it to your forked repo
5. Create a merge request against _your_ master branch and assign it to _qtokar_

Your commit must pass Gitlab CI verification. To test this locally, run:
```
./gradlew check
```

To check unit tests locally, run:
```
./gradlew test
```

To check instrumented tests locally, run:
```
./gradlew connectedAndroidTest
```
Make sure, your device/emulator is connected