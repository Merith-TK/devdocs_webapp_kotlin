I have utilized this guys source example template to make a kotlin version of the Website https://devdocs.io
THIS WILL NOT BE OFFICIALLY SUPPORTED as it will use a webveiw, not truely offline I know, but it will do. 

## IF YOU HAVE ISSUES WITH GRADLE
	Go to the cloned repo, and delete `.idea` and `.gradle` and let Android-Studio rebuild these directories, 
	This may require you to restart Android-Studio
	
	This project is being developed crossplatform from Win10 and ArchLinux, 
	If you receive a folder error like `/home/nala/` or `C:\Users\Merith` does not exist,
	you can safely ignore that.

## THINGS TO DO
~~~[X]	Remove annoying Header Bar~~~

~~~[X]	Suppress "Devdocs is running in Webveiw message"~~~

[ ]	Enable app cache to make the app know it can actually cache itself

## BUILDS
The current beta build is located in `/app/debug/app-debug.apk`

## ORIGINAL SOURCE
https://github.com/QuaestioOrg/kotlin-converted-webview/
## License

Licensed under the [Apache License, Version 2.0 (the "License")](http://www.apache.org/licenses/LICENSE-2.0); you may not use files of this sample except in compliance with its [License](/LICENSE).

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "as is" basis, without warranties or conditions of any kind, either express or implied.

See the License for the specific language governing permissions and limitations under the License.
