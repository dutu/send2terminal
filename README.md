# Send To Terminal

<!-- Plugin description -->
JetBrains IDE plugin to send the current editor line or selection directly to the active IDE terminal and execute it.
<!-- Plugin description end -->

This fork uses the native JetBrains Terminal API instead of platform-specific terminal automation.

## Usage

The plugin provides one action:

**Evaluate Line/Selection in Terminal**

- If text is selected, the selected text is sent to the active IDE terminal.
- If there is no selection, the current line is sent.
- The command is executed immediately.
- Editor focus remains in the editor.
- An existing selection is cleared after the command is sent.

No default keyboard shortcut is assigned.

A convenient binding is `F10`:

`Settings → Keymap → Evaluate Line/Selection in Terminal`

## Terminal support

The plugin sends commands directly to the terminal embedded in the IDE.

It supports both the current reworked JetBrains terminal and the classic terminal implementation.

No external terminal application, clipboard automation, or desktop automation is required.

This makes it suitable for Linux/Wayland environments as well as other platforms supported by JetBrains IDEs.

## Compatibility

Currently developed and tested with WebStorm based on IntelliJ Platform build `263`.

The plugin requires the JetBrains Terminal plugin.

Other JetBrains IDEs based on the same platform may also work but have not been specifically tested.

## Build

Clone the repository:

```bash
git clone https://github.com/dutu/send2terminal.git
cd send2terminal
```

Build using the JBR bundled with WebStorm:

```bash
JAVA_HOME="$HOME/.local/opt/WebStorm/jbr" ./gradlew clean build
```

Build an installable plugin ZIP:

```bash
JAVA_HOME="$HOME/.local/opt/WebStorm/jbr" ./gradlew buildPlugin
```

The resulting package is created under:

```text
build/distributions/
```

Install it using:

`Settings → Plugins → Install Plugin from Disk…`

## Development

Run a sandboxed WebStorm instance with the plugin installed:

```bash
JAVA_HOME="$HOME/.local/opt/WebStorm/jbr" ./gradlew runIde
```

## History

This repository is a fork of the original
[holgerbrandl/send2terminal](https://github.com/holgerbrandl/send2terminal)
plugin.

The original implementation supported several platform-specific external
terminal integrations and additional Kotlin-specific functionality.

Version 2.x simplifies the plugin around direct integration with the
JetBrains IDE terminal.

## License

BSD license. See [LICENSE](LICENSE).