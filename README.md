# BillOfLoading Kotlin

<a href="https://github.com/aps-lab/BillOfLoadingKotlin/packages/509059">
        <img src="https://img.shields.io/badge/download-github%20packages-green"
            alt="Total alerts"/></a>

## Example

```ruby
        val billOfLoding = BillOfLoading.createBillOfLoadingList(100, "receiverId")
```

### Usage
The BillOfloading android Library is available on Github Packages

**Maven**
```java
<dependency>
  <groupId>de.adorsys.android</groupId>
  <artifactId>billofloading</artifactId>
  <version>0.0.3</version>
</dependency>
```
**Gradle** 
In project Build gradle These lines of code are only necessary, because this is a private repository.

```java
allprojects {
    repositories {
        google()
        jcenter()
        maven {
            url = "https://maven.pkg.github.com/aps-lab/BillOfLoadingKotlin"
            credentials {
                username = System.getenv('GITHUB_USER') ?: project.properties['GITHUB_USER']
                password = System.getenv('GITHUB_PERSONAL_ACCESS_TOKEN') ?: project.properties['GITHUB_PERSONAL_ACCESS_TOKEN']
            }
        }
    }
}
```
In module Build gradle:

```java
dependencies {
    implementation 'de.adorsys.android:billofloading:{currentVersion}'
}
```
And set GITHUB_USER and GITHUB_PERSONAL_ACCESS_TOKEN as local environment variable.

```


## Author

ica@adorsys.de

## License

BillOfLoading is available under the MIT license. See the LICENSE file for more info.
