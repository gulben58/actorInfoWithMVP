# actorInfoWithMVP
Build:

1.In AndroidManifest.xml file, add <uses-permission android:name="android.permission.INTERNET" />

2.In build gradle, dependencies should be like this;
dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.android.support:appcompat-v7:26.0.0-beta1'
    implementation 'com.android.support.constraint:constraint-layout:1.0.2'
    testImplementation 'junit:junit:4.12'
    testImplementation 'org.robolectric:robolectric:3.8'
    androidTestImplementation 'com.android.support.test:runner:0.5'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:2.2.2'
    compile 'com.squareup.picasso:picasso:2.5.2'
    
}

compile 'com.squareup.picasso:picasso:2.5.2' is Picasso library for downloading images.

Run:
1.Search: Enter a name and click search button.Results that contains the input string will be shown.
2.Show All:By clicking the show all button, first 20 popular actors will be shown according to their popularity scores. 
