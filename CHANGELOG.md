# Changes

## [2.0.0]

### Changed

* Reworked command execution to use the native JetBrains Terminal API.
* Send the current line or editor selection directly to the active IDE terminal.
* Commands are executed without moving focus away from the editor.
* Added native support for Linux/Wayland without clipboard or desktop automation.
* Added support for both reworked and classic JetBrains terminal implementations.
* Modernized the build for current IntelliJ Platform releases.
* Updated the minimum supported platform build to 263.

### Removed

* Removed legacy Windows and macOS external-terminal connectors.
* Removed the legacy settings UI and configurable evaluation actions.
* Removed Kotlin-specific import handling and expression evaluation.
 
## [1.7.0]

* Fixed compatibility with Intellij v2022.3

## [1.6.1]

* Fixed compatibility with Intellij v2022.3

## [1.5.1]

* Fixed compatibility with Intellij v2021.3

## [1.5.0]

* Migrated to more modern plugin infrastructure
* Fixed compatibility with Intellij v2021.2

## [1.4.0]

* Misc bugfixes
* Improved Windows compatibility

## [1.3.0]

### Changed

* Improved expression detection heuristics for kotlin
* Added automatic import push-2-console for Kotlin files: All imports of the current Kotlin file will be automatically
  pushed to the console before pushing the actual user code. To clear the internal import cache (which the plugin is
  using to remember the imports it had pushed already) the user can use the default key binding `ctrl alt meta c`

## [1.2.0]

### Changed

* Paste mode support when sending kotlin code to terminal. Currently this feature is just enabled for Kotlin source
  files

## [1.1.0]

* Added additional action to evaluate current most top-level expression in file
* Large text blocks are now chunked before sending them to terminal

## [1.0.0]

Initial Release.
 
This plugin was originally developed as part of [R language support for Intellij](https://github.com/holgerbrandl/r4intellij) but it now evolved separately.
            
            