# Android 10 PiP Reproduction

This is a reproduction of a bug we are seeing on Android 10 when using PiP. When PiP is first started from an activity that is not the main activity, it usually isn't visible. Tapping where you expect the PiP window to be causes it to show up.

## How To Reproduce

- Open up this project in Android Studio.
- Deploy it to an Android 10 device.
- On the main screen, click the fab to open a second activity.
- Click the fab on the second activity to trigger PiP.
- The PiP window won't be visible.
- If you click around where you expect it to be, it should appear.

Note: Sometimes it _does_ appear correctly. In this case, open the task switcher and kill all instances of the app. Open the app again and step through reproduction steps.

Note: This only occurs the first time PiP is started. Once it's already been started, it shows up fine every time.
