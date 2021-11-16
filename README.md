# Collapse Closing Tags (Jetbrains plugin)

![Build](https://github.com/TrianguloY/CollapseClosingTags/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/18020.svg)](https://plugins.jetbrains.com/plugin/18020)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/18020.svg)](https://plugins.jetbrains.com/plugin/18020)

<!-- Plugin description -->
This plugin allows collapsing ending xml tags:

From:

![pre](pre.png)

To:

![post](post.png)

They are implemented using the IDE folding features, so you can use the collapse/expand actions and its keywords.

Additionally, it includes an entry in the right-click menu to collapse all detected tags in the file (if any).
<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Collapse Closing
  Tags"</kbd> >
  <kbd>Install Plugin</kbd>

- Manually:

  Download the [latest release](https://github.com/TrianguloY/CollapseClosingTags/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
